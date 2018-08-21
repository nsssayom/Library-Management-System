import java.sql.*;
public class Database{
	private String dbHost;
	private String dbName;
	private String dbUser;
	 String dbPass;

	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

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
        //String query = "SELECT `name` FROM `test`;";
		this.connectDatabase();
		System.out.println(query);
        try{
			rs = st.executeQuery(query);//getting result
			return rs;
		}
        catch(Exception ex){
			System.out.println("Executing Query Error: " + ex.getMessage());
			return null;
		}
		finally{
			//this.closeConnection();
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
            }
            catch(Exception ex){
				System.out.println("Database connection closing failed");
				ex.printStackTrace();
			}
	}
}
