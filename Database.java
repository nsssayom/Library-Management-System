import java.sql.*;
import java.lang.*;

public class Database{
	private String dbHost;
	private String dbName;
	private String dbUser;
	private String dbPass;

	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public Database(String dbHost, String dbUser, String dbPass, String dbName){
		this.dbHost = dbHost;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}

	private void connectDatabase(){
		try{
			this.closeConnection();
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://" + this.dbHost + ":3306/" + this.dbName + "?autoReconnect=true&useSSL=false&allowMultiQueries=true" ,this.dbUser,this.dbPass);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
		}
		catch(Exception ex){
			System.out.println("Database Connection Error.");
			ex.printStackTrace();
		}
	}

    public ResultSet runQuery(PreparedStatement statement){
		//this.connectDatabase();
    try{
			rs = statement.executeQuery();
			return rs;
		}
    catch(Exception ex){
			System.out.println("Executing Query Error: " + ex.getMessage());
			return null;
		}
		finally{

		}
	}

	public Boolean runUpdate(PreparedStatement Statement){
		try{
			if (Statement.executeUpdate() < 1){
				return false;
			}
			return true;
		}
		catch(Exception ex){
			System.out.println("Executing Update Eror");
			ex.printStackTrace();
			return false;
		}
		finally{
			this.closeConnection();
		}
	}

	private void closeConnection(){
		try{
            if(rs!=null)
				rs.close();

            if(st!=null)
				st.close();

            if(con!=null)
				con.close();

						if(ps!=null)
				ps.close();
			}
    catch(Exception ex){
				System.out.println("Database connection closing failed");
				ex.printStackTrace();
			}
	}

	public Boolean signUp(String name, String ID, String email, String phone, String address, String userName, String password, String roleID, String... salary){
		String signUpQuery;
		if (roleID.equals("4") && salary.length == 0){
			signUpQuery = 	"BEGIN;"
											+ "INSERT INTO people (name, phoneNumber, email, address)"
	  									+ " VALUES(?, ?, ?, ?);"
											+ "INSERT INTO userAccount (peopleID, userName, password, roleID)"
	  									+ " VALUES(LAST_INSERT_ID(), ?, ?, ?);"
											+ " COMMIT;";
		}
		else{
			signUpQuery = 	"BEGIN;"
											+ " INSERT INTO people(name, phoneNumber, email, address)"
	  									+ " VALUES(?, ?, ?, ?);"
											+ " INSERT INTO userAccount(peopleID, userName, password, roleID)"
	  									+ " VALUES(LAST_INSERT_ID(), ?, ?, ?);"
											+ " INSERT INTO salary (accountID, salary)"
											+ " VALUES(LAST_INSERT_ID(), ?);"
											+ " COMMIT;";
		}
		this.connectDatabase();
		try{
			this.ps = this.con.prepareStatement(signUpQuery);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, userName);
			ps.setString(6, Crypto.SHA256(password).toUpperCase());
			ps.setString(7, roleID);
			if (salary.length > 0){
					ps.setString(8, salary[0]);
			}
			System.out.println(ps);
			this.runUpdate(ps);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			this.closeConnection();
		}
		return false;
	}

	public void logIn(String userName, String password) throws LibraryException{
		String userNameQuery = "SELECT accountID FROM userAccount WHERE " + "userName = ?);";
		this.connectDatabase();

		try{
			this.ps = this.con.prepareStatement(userNameQuery);
			ps.setString(1, userName);
			ResultSet result = this.runQuery(ps);
			if (result.isBeforeFirst()) {
				this.ps = null;
				String accountID = result.getString("accountID");
    		String loginQuery = "SELECT roleID FROM userAccount WHERE " + "accountID = ? AND password = ?);";

				try{
					this.ps = this.con.prepareStatement(loginQuery);
					this.ps.setString(1, accountID);
					this.ps.setString(2, Crypto.SHA256(password).toUpperCase());
					ResultSet resultLogin = this.runQuery(ps);
					if (resultLogin.isBeforeFirst()){
						System.out.println("Login Successful");
					}
					else{
						throw new LibraryException("Wrong Password", 202);
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			else{
				throw new LibraryException("User not found", 201);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			this.closeConnection();
		}
}

	public Boolean addNewBook(String bookTitle, String authorName, String ISBN,
														 String publicationYear, String shelf, String quantity){
      String bookAddQuery = "INSERT INTO books (booktitle, authorname, isbn, publicationyear, shelf, totalquantity, availablequantity)"
													+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
			this.connectDatabase();

			try{
				this.ps = this.con.prepareStatement(bookAddQuery);
				ps.setString(1, bookTitle);
				ps.setString(2, authorName);
				ps.setString(3, ISBN);
				ps.setString(4, publicationYear);
				ps.setString(5, shelf);
				ps.setString(6, quantity);
				ps.setString(7, quantity);
				this.runUpdate(ps);
				return true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				this.closeConnection();
			}
			return false;
	}

}
