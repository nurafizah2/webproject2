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
import Model.client;
import Connection.DBConnection;

public class ClientDao {
  
    Connection connection = null;
    private String jdbcURL =  "jdbc:mysql://localhost:3306/User";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    
    private static final String INSERT_CLIENT_SQL = "INSERT INTO Client (username, password, role) VALUES"+"(?,?,?);";
    private static final String SELECT_CLIENT_BY_ID="select id username, password, role from Client where id=?";
    private static final String SELECT_ALL_CLIENT="select*from Client";
    private static final String DELETE_CLIENT_SQL="delete from Client where id=?";
    private static final String UPDATE_CLIENT_SQL="update Client set username =?,password=? where id=?;";
    private static final String SELECT_CLIENT_BY_USERNAME="select id username, password, role from Client where id=?";
      
      public ClientDao(){}
      
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
      
     public void insertClient(client client) throws SQLException{
         System.out.println(INSERT_CLIENT_SQL);
         
         try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL )){
             preparedStatement.setString(1, client.getUsername());
             preparedStatement.setString(2, client.getPassword());
             preparedStatement.setString(3, client.getRole());
             System.out.println(preparedStatement);
             preparedStatement.executeUpdate();
         }catch (SQLException e){
             printSQLException (e);
         }
     }
     
     public client selectClient(int id){
         client client = null;
         
         try (Connection connection = getConnection();
                 
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);){
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);
                
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    client = new client(id, username, password, role);
                }
                }catch (SQLException e){
                    printSQLException(e);
         }
         return client;
     }
     
     public client selectClientByUsername(String username) {
        client client = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("role");
                client = new client(id, username, password, role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return client;
    }
     
public client getClientByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM Client WHERE username = ? AND password = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        client client = null;

        if (rs.next()) {
            client = new client();
            client.setUsername(rs.getString("username"));
            client.setPassword(rs.getString("password"));
            client.setRole(rs.getString("role"));
        }

        rs.close();
        pstmt.close();
        return client;
    }

     
     public List <client>selectAllClient(){
         
         List <client>client = new ArrayList<>();
         
         try (Connection connection = getConnection();
                 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT);){
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();
             
              while (rs.next()){
                  int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    client.add(new client(id, username, password, role));
                }
                }catch (SQLException e){
                    printSQLException(e);
         }
         return client;
     }
     
     public boolean deleteClient(int id) throws SQLException{
         boolean rowDeleted;
         try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL);){
             statement.setInt(1, id);
             rowDeleted = statement.executeUpdate()>0;
         }
         return rowDeleted;
     }
     
     public boolean updateClient(client client)throws SQLException{
         boolean rowUpdated;
         try (Connection connection = getConnection();
         PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_SQL);){
             statement.setString(1, client.getUsername());
             statement.setString(2, client.getPassword());
             statement.setInt(4, client.getId());
     
             rowUpdated = statement.executeUpdate() > 0;
         }
         return rowUpdated;
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
    


  

