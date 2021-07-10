import java.sql.*;

public class InsertRecordExample {

  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/emp";
    String username = "root";
    String password = "root";

    Connection conn = null;
    Statement stmt = null;

    try {
      //Open connection
      conn = DriverManager.getConnection(jdbcUrl, username, password);
      
      //Create statement
      stmt = conn.createStatement();

      //Insert first reocod
      
   //   INSERT INTO `emp`.`employee` (`idemployee`, `name`, `age`) VALUES ('1', 'Saurabh', '35')	1 row(s) affected	0.016 sec

      String record1="INSERT INTO employee (idemployee, name, age) "
          + "VALUES (4,'Joe','20')";
      stmt.executeUpdate(record1);
      
    
      System.out.println("Records inserted");

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        // Close connection
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}