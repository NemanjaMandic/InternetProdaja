
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
   
   
   public static Connection DBConnector(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/internet_sale", "root","");
            return conn;
       } catch (ClassNotFoundException | SQLException ex) {
           ex.printStackTrace();
       } 
       return null;
   }
}
