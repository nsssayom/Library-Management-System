import java.lang.*;
import java.sql.*;

public class MainClass{
	public static void main(String[] args){
		//Database database = new Database("localhost", "test", "root", "");
		Database database = new Database("54.37.227.144", "my_library", "Library009", "library_database");

		/*String query = "SELECT `name` FROM `test`;";
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
		*/

		try{
			//database.addNewBook( "bookTitle", "authorName", "10010", "2018", "7", "5");
			//database.signUp("Sayom Shakib", "17-33926-1", "nsssayom@gmail.com", "+8801717018376", "address", "nsssayom", "11223344", "1", "1600");
			//System.out.println(Crypto.SHA256("HHH").toUpperCase());
			try{
				database.logIn("nsssayom", "11223344");
			}
			catch(LibraryException lx){
				System.out.println(lx.getCode());
			}

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
