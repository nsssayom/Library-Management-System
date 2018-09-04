package LibrarySystem.Database;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;

import java.sql.*;
import java.lang.*;
import java.util.List;
import java.util.*;

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

	public void runUpdate(PreparedStatement Statement) throws Exception{
		try{
			if (Statement.executeUpdate() < 1){
			}
		}
		catch(Exception ex){
			throw ex;
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
			//ex.printStackTrace();
		}
		finally{
			this.closeConnection();
		}
		return false;
	}

public void logIn(String userName, String password) throws LibraryException{
	String userNameQuery = "SELECT accountID FROM userAccount WHERE " + "userName = ? AND isDeleted = 0;";
	String loginQuery = "SELECT roleID, peopleID FROM userAccount WHERE " + "accountID = ? AND password = ?;";
	String peopleQuery = "SELECT * FROM people WHERE " + "peopleID = ?;";
	this.connectDatabase();
	ResultSet result;
	ResultSet resultLogin;
	ResultSet resultPeople;

	String accountID = "";
	String peopleID = "";
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
				Global.USERNAME = userName;
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
			peopleID = resultLogin.getString("peopleID");
			Global.PEOPLEID = peopleID;
			System.out.println(roleID);
			roleIDInt = Integer.parseInt(roleID);
			Global.ROLEID = roleIDInt;

			System.out.println("User Role Found!");
			System.out.println("PeopleID: " + peopleID);
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
			System.out.println("Error");
			throw new LibraryException("Wrong Password", 202);
		}
	}

	//prepare statement and execute sql to find user Details
	try{
		this.ps = this.con.prepareStatement(peopleQuery);
		ps.setString(1, peopleID);
		System.out.println(ps);
		resultPeople = this.runQuery(ps);
	}
	catch(Exception ex){
		throw new LibraryException ("SQL Error", 301);
	}

	//extracting SQL return to get user Details
	try{
		if (resultPeople.first()) {
				this.ps = null;
				System.out.println("=>" + result);

				Global.NAME = resultPeople.getString("name");
				Global.EMAIL = resultPeople.getString("email");
				Global.ADDRESS = resultPeople.getString("address");
				Global.PHONE = resultPeople.getString("phoneNumber");
				System.out.println("Name: " + Global.NAME);
			}
			else{
				throw new LibraryException("User detail not found", 203);
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
				//ex.printStackTrace();
			}
			finally{
				this.closeConnection();
			}
			return false;
	}

	public Object[][] readBookList() throws LibraryException{
		String bookQuery = "SELECT * FROM books WHERE " + " isDeleted = 0 ORDER BY popularity DESC;";
		this.connectDatabase();
		ResultSet result;
		Object[][] resultArray = null;
		List<List<String>> bookList = new ArrayList<List<String>>();
		int rowCount = 0;

		//run query to get books
		try{
			this.ps = this.con.prepareStatement(bookQuery);
			System.out.println(ps);
			result = this.runQuery(ps);
		}
		catch(Exception ex){
			throw new LibraryException ("SQL Error", 301);
		}

		//extracting SQL return to Object[][]
		try{
				int cnt = 0;
				while(result.next()){
					List<String> bookDetail = new ArrayList<String>();
					bookDetail.add(result.getString("bookID"));
					bookDetail.add(result.getString("bookTitle"));
					bookDetail.add(result.getString("authorName"));
					bookDetail.add(result.getString("publicationYear"));
					bookDetail.add(result.getString("shelf"));
					bookDetail.add(result.getString("availableQuantity"));
					bookList.add(bookDetail);
					System.out.println(Arrays.deepToString(bookDetail.toArray()));
				}
				System.out.println("Data Extraction completed: ");
				rowCount = bookList.size();
				System.out.println(Arrays.deepToString(bookList.toArray()));

				resultArray = new Object[rowCount][6];
				try{
					for(int i = 0; i < rowCount; i++){
						for(int j = 0; j < 6; j++){
							resultArray[i][j] = bookList.get(i).get(j);
						}
					}
						//bookList.forEach((book)->book.forEach((field)->System.out.println(field)));
					}
					catch(Exception ex){
						System.out.println("Error exporting result to an array");
					}
		}
		catch(Exception ex){
			if (!(ex instanceof LibraryException)){
				throw new LibraryException("SQL Error", 301);
			}
			else{
				throw new LibraryException("No Data found", 205);
			}
		}
		finally{
			return resultArray;
		}
	}


	public Object[][] search(String dataSet, String keyWord) throws LibraryException{
		String searchQuery = "SELECT * FROM books WHERE " + dataSet + " LIKE ? AND isDeleted = 0;";
		this.connectDatabase();
		ResultSet result;
		Object[][] resultArray = null;
		List<List<String>> bookList = new ArrayList<List<String>>();
		int rowCount = 0;

		//run query to get books
		try{
			this.ps = this.con.prepareStatement(searchQuery);
			this.ps.setString(1, "%" + keyWord + "%");
			System.out.println(ps);
			result = this.runQuery(ps);
		}
		catch(Exception ex){
			throw new LibraryException ("SQL Error", 301);
		}

		//extracting SQL return to Object[][]
		try{
				int cnt = 0;
				while(result.next()){
					List<String> bookDetail = new ArrayList<String>();
					bookDetail.add(result.getString("bookID"));
					bookDetail.add(result.getString("bookTitle"));
					bookDetail.add(result.getString("authorName"));
					bookDetail.add(result.getString("publicationYear"));
					bookDetail.add(result.getString("shelf"));
					bookDetail.add(result.getString("availableQuantity"));
					bookList.add(bookDetail);
					System.out.println(Arrays.deepToString(bookDetail.toArray()));
				}
				System.out.println("Data Extraction completed: ");
				rowCount = bookList.size();
				System.out.println(Arrays.deepToString(bookList.toArray()));

				resultArray = new Object[rowCount][6];
				try{
					for(int i = 0; i < rowCount; i++){
						for(int j = 0; j < 6; j++){
							resultArray[i][j] = bookList.get(i).get(j);
						}
					}
						//bookList.forEach((book)->book.forEach((field)->System.out.println(field)));
					}
					catch(Exception ex){
						System.out.println("Error exporting result to an array");
					}
		}
		catch(Exception ex){
			if (!(ex instanceof LibraryException)){
				throw new LibraryException("SQL Error", 301);
			}
			else{
				throw new LibraryException("No Data found", 205);
			}
		}
		finally{
			return resultArray;
		}
	}

	public Boolean deleteAccount(){
	      String bookAddQuery = "UPDATE userAccount SET isDeleted = ? WHERE accountID = ?;";
				this.connectDatabase();

				try{
					this.ps = this.con.prepareStatement(bookAddQuery);
					ps.setString(1, "1");
					ps.setString(2, String.valueOf(Global.ACCOUNTID));
					this.runUpdate(ps);
					return true;
				}
				catch(Exception ex){
					//ex.printStackTrace();
				}
				finally{
					this.closeConnection();
				}
				return false;
		}

		public Boolean updateSelfInfo(String name, String phoneNumber, String email, String address){
		      String bookAddQuery = "UPDATE people SET name = ?, phoneNumber = ?, email = ?, address = ? WHERE peopleID = ?;";
					this.connectDatabase();
					try{
						this.ps = this.con.prepareStatement(bookAddQuery);
						ps.setString(1, name);
						ps.setString(2, phoneNumber);
						ps.setString(3, email);
						ps.setString(4, address);
						ps.setString(5, String.valueOf(Global.PEOPLEID));
						this.runUpdate(ps);

						Global.NAME = name;
						Global.PHONE = phoneNumber;
						Global.EMAIL = email;
						Global.ADDRESS = address;

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

		public Boolean verifyPassword(String  password){
			String passwordQuery = "SELECT peopleID FROM userAccount WHERE " + "accountID = ? AND password = ?;";
			this.connectDatabase();
				ResultSet resultLogin = null;
				Boolean resultBool = false;
			try{
				this.ps = this.con.prepareStatement(passwordQuery);
				this.ps.setString(1, String.valueOf(Global.ACCOUNTID));
				this.ps.setString(2, Crypto.SHA256(password).toUpperCase());
				System.out.println(ps);
				resultLogin = this.runQuery(ps);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}

			try{
					this.ps = null;
					if (resultLogin.first()) {
						if (Global.PEOPLEID.equals(resultLogin.getString("peopleID"))){
							return true;
						}
					}
					else{
						return false;
					}
			}
			catch(Exception ex){
				ex.printStackTrace();
				return false;
			}
			return false;
		}

		public Boolean updatePassword(String password){
		      String updatePasswordQuery = "UPDATE userAccount SET password = ? WHERE accountID = ?;";
					this.connectDatabase();
					try{
						this.ps = this.con.prepareStatement(updatePasswordQuery);
						ps.setString(1, Crypto.SHA256(password).toUpperCase());
						ps.setString(2, String.valueOf(Global.ACCOUNTID));
						this.runUpdate(ps);
						this.closeConnection();
						return true;
					}
					catch(Exception ex){
						ex.printStackTrace();
						this.closeConnection();
						return false;
					}
			}


			public Boolean updateBook(String bookID, String title, String author, String pubYear, String quantity){
			      String updatePasswordQuery = "UPDATE books SET bookTitle = ?, authorName = ?, publicationYear = ?, availableQuantity = ? WHERE bookID = ?;";
						this.connectDatabase();
						try{
							this.ps = this.con.prepareStatement(updatePasswordQuery);
							ps.setString(1, title);
							ps.setString(2, author);
							ps.setString(3, pubYear);
							ps.setString(4, quantity);
							ps.setString(5, bookID);
							this.runUpdate(ps);
							this.closeConnection();
							return true;
						}
						catch(Exception ex){
							ex.printStackTrace();
							this.closeConnection();
							return false;
						}
				}

		public Object[][] readUserInfo(int mode) throws LibraryException{
				//mode == 0 : User
				//mode == 1: Employee
				String peopleQuery = "";

				if (mode == 0){
					peopleQuery = "SELECT name, phoneNumber, email, address FROM people, userAccount " +
												"WHERE people.peopleID = userAccount.peopleID AND userAccount.roleID = 4 AND " +
												"userAccount.isDeleted = 0 ORDER BY people.name ASC;";
				}
				else{
					peopleQuery = "SELECT name, phoneNumber, email, address FROM people, userAccount " +
												"WHERE people.peopleID = userAccount.peopleID AND userAccount.roleID < 4 AND " +
												"userAccount.isDeleted = 0 ORDER BY people.name ASC;";
				}

				this.connectDatabase();
				ResultSet result;
				Object[][] resultArray = null;
				List<List<String>> bookList = new ArrayList<List<String>>();
				int rowCount = 0;

				//run query to get books
				try{
					this.ps = this.con.prepareStatement(peopleQuery);
					System.out.println(ps);
					result = this.runQuery(ps);
				}
				catch(Exception ex){
					throw new LibraryException ("SQL Error", 301);
				}

				//extracting SQL return to Object[][]
				try{
						int cnt = 0;
						while(result.next()){
							List<String> bookDetail = new ArrayList<String>();
							bookDetail.add(result.getString("name"));
							bookDetail.add(result.getString("phoneNumber"));
							bookDetail.add(result.getString("email"));
							bookDetail.add(result.getString("address"));
							bookList.add(bookDetail);
							System.out.println(Arrays.deepToString(bookDetail.toArray()));
						}
						System.out.println("Data Extraction completed: ");
						rowCount = bookList.size();
						System.out.println(Arrays.deepToString(bookList.toArray()));

						resultArray = new Object[rowCount][4];
						try{
							for(int i = 0; i < rowCount; i++){
								for(int j = 0; j < 4; j++){
									resultArray[i][j] = bookList.get(i).get(j);
								}
							}
								//bookList.forEach((book)->book.forEach((field)->System.out.println(field)));
						}
						catch(Exception ex){
								System.out.println("Error exporting result to an array");
						}
				}
				catch(Exception ex){
					if (!(ex instanceof LibraryException)){
						throw new LibraryException("SQL Error", 301);
					}
					else{
						throw new LibraryException("No Data found", 205);
					}
				}
				finally{
					return resultArray;
				}
			}


			public Object[][] readBorrowedBooks() throws LibraryException{
					String peopleQuery = "";
					peopleQuery = "SELECT * FROM borrowInfo, books " +
												"WHERE borrowInfo.accountID = ? AND books.bookID = borrowInfo.bookID " +
												"AND books.isDeleted = 0 ORDER BY borrowInfo.borrowDate DESC;";

					this.connectDatabase();
					ResultSet result;
					Object[][] resultArray = null;
					List<List<String>> bookList = new ArrayList<List<String>>();
					int rowCount = 0;

					//run query to get books
					try{
						this.ps = this.con.prepareStatement(peopleQuery);
						this.ps.setString(1, String.valueOf(Global.ACCOUNTID));
						System.out.println(ps);
						result = this.runQuery(ps);
					}
					catch(Exception ex){
						throw new LibraryException ("SQL Error", 301);
					}

					//extracting SQL return to Object[][]
					try{
							int cnt = 0;
							while(result.next()){
								List<String> bookDetail = new ArrayList<String>();
								bookDetail.add(result.getString("bookID"));
								bookDetail.add(result.getString("bookTitle"));
								bookDetail.add(result.getString("authorName"));
								bookDetail.add(result.getString("borrowDate"));
								bookList.add(bookDetail);
								System.out.println(Arrays.deepToString(bookDetail.toArray()));
							}
							System.out.println("Data Extraction completed: ");
							rowCount = bookList.size();
							System.out.println(Arrays.deepToString(bookList.toArray()));

							resultArray = new Object[rowCount][4];
							try{
								for(int i = 0; i < rowCount; i++){
									for(int j = 0; j < 4; j++){
										resultArray[i][j] = bookList.get(i).get(j);
									}
								}
									//bookList.forEach((book)->book.forEach((field)->System.out.println(field)));
							}
							catch(Exception ex){
									System.out.println("Error exporting result to an array");
							}
					}
					catch(Exception ex){
						if (!(ex instanceof LibraryException)){
							throw new LibraryException("SQL Error", 301);
						}
						else{
							throw new LibraryException("No Data found", 205);
						}
					}
					finally{
						return resultArray;
					}
				}

				public void issueBook(String bookID, String userName) throws Exception{
					String borrowQuery;
						borrowQuery = 	"BEGIN;"
														+ "INSERT INTO borrowInfo (bookID, accountID)"
														+ " VALUES(?, (SELECT accountID FROM userAccount WHERE userName = ?));"
														+ "UPDATE books SET availableQuantity = availableQuantity - 1"
														+ " WHERE bookID = ? AND availableQuantity > 0;"
														+ " COMMIT;";

					this.connectDatabase();
					try{
						this.ps = this.con.prepareStatement(borrowQuery);
						ps.setString(1, bookID);
						ps.setString(2, userName);
						ps.setString(3, bookID);
						System.out.println(ps);
						this.runUpdate(ps);
					}
					catch(Exception ex){
						throw ex;
					}
					finally{
						this.closeConnection();
					}
				}

				public void returnBook(String borrowID) throws Exception{
					String borrowQuery;
						borrowQuery = 	"BEGIN;"
														+ "INSERT INTO returnInfo (borrowID)"
														+ " VALUES(?);"
														+ "UPDATE books SET availableQuantity = availableQuantity + 1"
														+ " WHERE bookID = (SELECT bookID FROM borrowInfo WHERE borrowID = ?) AND availableQuantity < totalQuantity;"
														+ " COMMIT;";

					this.connectDatabase();
					try{
						this.ps = this.con.prepareStatement(borrowQuery);
						ps.setString(1, borrowID);
						ps.setString(2, borrowID);
						System.out.println(ps);
						this.runUpdate(ps);
					}
					catch(Exception ex){
						throw ex;
					}
					finally{
						this.closeConnection();
					}
				}
}
