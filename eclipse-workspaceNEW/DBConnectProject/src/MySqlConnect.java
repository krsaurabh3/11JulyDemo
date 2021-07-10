
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("MySQL Connect Example.");
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		// String dbUrl = "jdbc:mysql://localhost:3306/emp";
		String dbUrl = "jdbc:mysql://localhost:3306/emp";

		// Database Username
		String username = "root";

		// Database Password
		String password = "root";

		// Query to Execute
		String query = "select *  from employee;";

		// Load mysql jdbc driver
		// Class.forName("com.mysql.jdbc.Driver"); //Loading class
		// `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is
		// `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the
		// SPI and manual loading of the driver class is generally unnecessary.

		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Before");
		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("MySQL connection established");

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			int idemployee = rs.getInt(1);
			String myName = rs.getString(2);
			String myAge = rs.getString(3);
			System.out.println(idemployee + "  " + myName + "  " + myAge);
		}
		rs.close();
		// closing DB Connection
		con.close();
	}

}
