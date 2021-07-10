import java.sql.*;

public class DeleteRecordExample2 {

  public static void main(String[] args) {
    String jdbcUrl =  "jdbc:mysql://localhost:3306/emp";
    
    String username = "root";
    String password = "root";
    String sql = "delete from employee where idemployee=?";

    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      
      stmt.setInt(1, 4);
      stmt.executeUpdate();
      
      System.out.println("Record deleted successfully");
     
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}