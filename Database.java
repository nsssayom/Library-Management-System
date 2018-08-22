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
			con = DriverManager.getConnection("jdbc:mysql://" + this.dbHost + ":3306/" + this.dbName + "?autoReconnect=true&useSSL=false" ,this.dbUser,this.dbPass);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
		}
		catch(Exception ex){
			System.out.println("Database Connection Error.");
			ex.printStackTrace();
		}
	}

    public ResultSet runQuery(String query){
		this.connectDatabase();
		System.out.println(query);
        try{
			rs = st.executeQuery(query);
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

	public Boolean addNewBook(String bookID, String bookTitle, String authorName, String ISBN,
														 String publicationYear, String shelf, String bookAddDate, String popularity, String quantity){
      String bookAddQuery = "INSERT INTO books (bookid, booktitle, authorname, isbn, publicationyear, shelf, bookadddate, popularity)"
													+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
			this.connectDatabase();

			try{
				this.ps = this.con.prepareStatement(bookAddQuery);
				ps.setString(1, bookID);
				ps.setString(2, bookTitle);
				ps.setString(3, authorName);
				ps.setString(4, ISBN);
				ps.setString(5, publicationYear);
				ps.setString(6, shelf);
				ps.setString(7, bookAddDate);
				ps.setString(8, popularity);
				this.runUpdate(ps);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}

			String bookQuantityQuery = "INSERT INTO bookQuantity (bookid, totalquantity, availablequantity)"
																+ "VALUES(?, ?, ?);";
			this.connectDatabase();

			try{
				this.ps = this.con.prepareStatement(bookQuantityQuery);
				ps.setString(1, bookID);
				ps.setString(2, quantity);
				ps.setString(3, quantity);
				this.runUpdate(ps);
				return true;
			}
			catch(Exception ex){
				ex.printStackTrace();
				return false;
			}
	}

}
