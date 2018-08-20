import java.lang.*;
import java.sql.*;

public class MainClass{
	public static void main(String[] args){
		Database database = new Database("localhost", "test", "root", "");
		String query = "SELECT `name` FROM `test`;"; 
		ResultSet result = database.runQuery(query);

		System.out.println("results received");
		
		try{
			while(result.next()){
				String userId = result.getString("name");
				System.out.println("name: " +userId);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
