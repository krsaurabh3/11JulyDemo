import java.sql.*;

public class DeleteRecordExample1 {

  public static void main(String[] args) {
  
    String jdbcUrl = "jdbc:mysql://localhost:3306/emp";

    String username = "root";
    String password = "root";
    String sql = "delete from employee where idemployee=3";

    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        Statement stmt = conn.createStatement();) {
      
      stmt.executeUpdate(sql);
      System.out.println("Record deleted successfully");
      
     /* ResultSet rs = stmt.executeQuery("select *  from employee;");
      while (rs.next())
      {
    	  System.out.print("ID: " + rs.getInt("idemployee"));
          System.out.print(", Name: " + rs.getInt("name"));
          System.out.print(", Age: " + rs.getString("age"));
      }
      
      rs.close();*/
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
}