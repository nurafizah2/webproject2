package DAO;
/**
 * @author Nurafizah
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.admin;
import Connection.DBConnection;

public class AdminDAO {
     Connection connection = null;
     private String jdbcURL =  "jdbc:mysql://localhost:3306/User";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    
    private static final String INSERT_ADMIN_SQL = "INSERT INTO Admin (username, password, role) VALUES"+"(?,?,?);";
    private static final String SELECT_ADMIN_BY_ID="select id username, password, role from Admin where id=?";
    private static final String SELECT_ALL_ADMIN="select*from Admin";
    private static final String DELETE_ADMIN_SQL="delete from Admin where id=?";
      private static final String UPDATE_ADMIN_SQL="update Admin set username =?,password=? where id=?;";
      private static final String SELECT_ADMIN_BY_USERNAME="select id username, password, role from Admin where username=?";
       private static final String SELECT_ADMIN_BY_USERNAME_AND_PASSWORD="select id username, password, from Admin where username=? password=?";

      public AdminDAO(){}
      
      protected Connection getConnection(){
          Connection connection = null;
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
          }catch (SQLException e){
              e.printStackTrace();
          }catch (ClassNotFoundException e ){
              e.printStackTrace();
          }
          return connection;
      }
      
     public void insertAdmin(admin admin) throws SQLException{
         System.out.println(INSERT_ADMIN_SQL);
         
         try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL )){
             preparedStatement.setString(1, admin.getUsername());
             preparedStatement.setString(2, admin.getPassword());
             preparedStatement.setString(3, admin.getRole());
             System.out.println(preparedStatement);
             preparedStatement.executeUpdate();
         }catch (SQLException e){
             printSQLException (e);
         }
     }
     
     public admin selectAdmin(int id){
         admin admin = null;
         
         try (Connection connection = getConnection();
                 
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);){
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);
                
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    admin = new admin(id, username, password, role);
                }
                }catch (SQLException e){
                    printSQLException(e);
         }
         return admin;
     }
     
          public admin selectAdmintByUsername(String username) {
        admin admin = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("role");
                admin = new admin(id, username, password, role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admin;
    }
     
     
     public List <admin>selectAllAdmin(){
         
         List <admin>admin = new ArrayList<>();
         
         try (Connection connection = getConnection();
                 
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMIN);){
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             
              while (rs.next()){
                  int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    admin.add(new admin(id, username, password, role));
                }
                }catch (SQLException e){
                    printSQLException(e);
         }
         return admin;
     }
     
     public boolean deleteAdmin(int id) throws SQLException{
         boolean rowDeleted;
         try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);){
             statement.setInt(1, id);
             rowDeleted = statement.executeUpdate()>0;
         }
         return rowDeleted;
     }
     
     public boolean updateAdmin(admin admin)throws SQLException{
         boolean rowUpdated;
         try (Connection connection = getConnection();
         PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);){
             statement.setString(1, admin.getUsername());
             statement.setString(2, admin.getPassword());
             statement.setString(3, admin.getRole());
             statement.setInt(4, admin.getId());
     
             rowUpdated = statement.executeUpdate() > 0;
         }
         return rowUpdated;
         }
     
       
        public admin getAdminByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM Admin WHERE username = ? AND password = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        admin admin = null;

        if (rs.next()) {
            admin = new admin();
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setRole(rs.getString("role"));
        }

        rs.close();
        pstmt.close();
        return admin;
    } 

         private void printSQLException(SQLException ex){
             for (Throwable e: ex){
                 if (e instanceof SQLException){
                     e.printStackTrace(System.err);
                     System.err.println("SQLState:"+((SQLException)e).getSQLState());
                     System.err.println("Error Code:"+((SQLException) e).getErrorCode());
                     System.err.println("Message:"+ e.getMessage());
                     Throwable t = ex.getCause();
                     while (t != null){
                         System.out.println("Cause: "+ t);
                         t = t.getCause();
                     }
                 }
             }
         }
     }
    

