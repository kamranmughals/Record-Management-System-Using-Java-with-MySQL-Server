

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;




public class Person {
	
	String url = "jdbc:mysql://localhost:3306/JavaSql";
	String user = "root";
	String password = "302716";
	//database connection
	Connection conn;
	//global Object for later use
		Scanner sc= new Scanner(System.in);
			int p_id;
			String p_name;
			int p_age;
			String p_phone;
			String p_qualify;
			int p_salary;
			String p_city;
			//Constructor calling
			public Person() {
				p_id = 0;
				p_name = "\0";
				p_age = 0;
				p_phone = "\0";
				p_qualify = "\0";
				p_salary = 0;
				p_city = "\0";
			}
			//returning variable values
			public int setID() {
				return p_id;
			}
			
			public String setName() {
				return p_name;
			}
			public int setAge() {
				return p_age;
			}
			public String setPhone() {
				return p_phone;
			}
			public String setQualify() {
				return p_qualify;
			}
			public int setSalary() {
				return p_salary;
			}
			public String setCity() {
				return p_city;
			}
			
			//Getting data from user
			public void getData() {
				System.out.println("Enter PersonID: ");
				p_id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Person-Name: ");
				p_name = sc.nextLine();
				System.out.println("Enter Person-Age: ");
				p_age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Person-Phone#: ");
				p_phone = sc.nextLine();
				System.out.println("Enter Person-Qualification: ");
				p_qualify = sc.nextLine();
				System.out.println("Enter Person-Salary: ");
				p_salary = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Person-City: ");
				p_city = sc.nextLine();
				System.out.println("Successfully Entered data! (s)");
			}	
		//make a connect between MYSQL Server
		public void GetConnection() {
			
			try {
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connect to database! successfully(s).");
			
			} catch (SQLException e) {
				System.out.println("Error: unable to connect!.");
		
				e.printStackTrace();
			}
		}
		
		public void InsertData() throws SQLException {
				String sql = "INSERT INTO PersonDB VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, setID());
				stmt.setString(2, setName());
				stmt.setInt(3, setAge());
				stmt.setString(4, setPhone());
				stmt.setString(5,setQualify());
				stmt.setInt(6, setSalary());
				stmt.setString(7,setCity());
				
				int rows = stmt.executeUpdate();
				
				if(rows > 0) {
					System.out.println("A row has inserted! .");
				}
				stmt.close();
		}
		
		
		public void Showdata() throws SQLException {
			
			java.sql.Statement selectStmt = conn.createStatement();
			ResultSet rs = selectStmt.executeQuery("Select * from PersonDB");
			System.out.printf("%5s---+%s---+%s---+%s---+%s---+%s---+%s---+", "----", "------------", "------------", "------------", "------------","------------","------------"  );
			System.out.println();
			System.out.printf("%5s	|%10s	|%10s	|%10s	|%10s	|%10s	|%10s	|", "P_ID", "P_NAME", "P_AGE", "P_PHONE", "P_QUALIF", "P_SALARY", "P_CITY");
			System.out.println();
			System.out.printf("%5s---+%s---+%s---+%s---+%s---+%s---+%s---+", "----", "------------", "------------", "------------", "------------","------------","------------"  );
			System.out.println();
			while(rs.next()) {
				System.out.printf("%5s	|%10s	|%10s	|%10s	|%10s	|%10s	|%10s	|", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7));
				System.out.println();
				System.out.printf("%5s---+%s---+%s---+%s---+%s---+%s---+%s---+", "----", "------------", "------------", "------------", "------------","------------","------------"  );
				System.out.println();
			}
		}
	
	public static void main (String[] args) throws SQLException {
		System.out.flush();  
		try (Scanner sc = new Scanner(System.in)) {
			Person newDB = new Person();
			int choice = 0;//for option
			newDB.GetConnection();
			while(true) {
				System.out.println("------> JAVA WITH MYSQL SERVER <------");
				System.out.println("+> 1. ADD RECORDS");
				System.out.println("+> 2. DISPLAY RECORDS");
				
				System.out.println("--> CHOICE: ");
				choice = sc.nextInt();
				
					if(choice == 1) {
						newDB.getData();
						newDB.InsertData();
						System.out.println("Press Enter key to continue...");
				        try
				        {
				            System.in.read();
				            sc.nextLine();
				        }  
				        catch(Exception e)
				        {} 
					}
					else if(choice == 2){
						newDB.Showdata();
						System.out.println("Press Enter key to continue...");
				        try
				        {
				            System.in.read();
				            sc.nextLine();
				        }  
				        catch(Exception e)
				        {} 
					}
			}
		}
		
		
		
		
		
	}
}

