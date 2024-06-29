package Connection;
/**
 * @author Nurafizah
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection myConnection=null;
    private static String myURL = myURL = "jdbc:mysql://localhost:3306/User";
    
    DBConnection(){
        
    }
    
    public static Connection getConnection() throws ClassNotFoundException{
        if (myConnection != null){
            return myConnection;
        }
        else
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection(myURL, "root", "admin");
                
            }
        catch (SQLException e){
            e.printStackTrace();
        }
        return myConnection;
    }
    
    public void closeConnection() throws ClassNotFoundException{
        try{
            myConnection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}