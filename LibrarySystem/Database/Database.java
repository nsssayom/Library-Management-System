package LibrarySystem.Database;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;

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
			System.out.println("Statement: " + statement);
			rs = statement.executeQuery();
			System.out.println(rs);
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
	String userNameQuery = "SELECT accountID FROM userAccount WHERE " + "userName = ?;";
	String loginQuery = "SELECT roleID FROM userAccount WHERE " + "accountID = ? AND password = ?;";
	this.connectDatabase();
	ResultSet result;
	ResultSet resultLogin;
	String accountID = "";
	String roleID;
	int roleIDInt = -1;

	//prepare statement and execute sql to find user
	try{
		this.ps = this.con.prepareStatement(userNameQuery);
		ps.setString(1, userName);
		System.out.println(ps);
		result = this.runQuery(ps);
	}
	catch(Exception ex){
		throw new LibraryException ("SQL Error", 301);
	}

	//extracting SQL return to get user accountID
	try{
		if (result.first()) {
				this.ps = null;
				System.out.println("=>" + result);
				accountID = result.getString("accountID");
				Global.ACCOUNTID = Integer.parseInt(accountID);
				System.out.println("Found User!");
			}
			else{
				System.out.println("User not Found");
				throw new LibraryException("User not found", 201);
			}
	}
	catch(Exception ex){
		if (!(ex instanceof LibraryException)){
			throw new LibraryException("SQL Error", 301);
		}
		else{
			throw new LibraryException("User not found", 201);
		}
	}

	//prepare statement and execute SQL to match password
	try{
		this.ps = this.con.prepareStatement(loginQuery);
		this.ps.setString(1, accountID);
		this.ps.setString(2, Crypto.SHA256(password).toUpperCase());
		System.out.println(ps);
		resultLogin = this.runQuery(ps);
	}
	catch(Exception ex){
		throw  new LibraryException ("SQL Error", 301);
	}

	//extracting SQL return to get user roleID
	try{
		if (resultLogin.first()){
			this.ps = null;
			System.out.println("Login Successful");
			roleID = resultLogin.getString("roleID");
			System.out.println(roleID);
			roleIDInt = Integer.parseInt(roleID);
			Global.ROLEID = roleIDInt;
			System.out.println("User Role Found!");
		}
		else{
			System.out.println("User Role not Found");
			throw new LibraryException("Wrong Password", 202);
		}
	}
	catch(Exception ex){
		if (!(ex instanceof LibraryException)){
			throw new LibraryException("SQL Error", 301);
		}
		else{
			System.out.println("Hello World Error");
			throw new LibraryException("Wrong Password", 202);
		}
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
