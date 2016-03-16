
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class ProdajaDAOImpl implements ProdajaDAO{

    private Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;
     
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/internet_sale", "root","");
            return conn;
        }catch(SQLException ex){
            System.err.println("Error");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           System.err.println("Error");
            ex.printStackTrace();
        }
        return null;
    }
    
   
       


    @Override
    public void insert(ProdajaModel prodaja) throws Exception {
       
      String sql = "INSERT INTO sales(firstName, lastName, city, address, email, speed, serialNo) VALUES(?, ?, ?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      
      ps.setString(1, prodaja.getFirstName());
      ps.setString(2, prodaja.getLastName());
      ps.setString(3, prodaja.getCity());
      ps.setString(4, prodaja.getAddress());
      ps.setString(5, prodaja.getEmail());
      ps.setString(6, prodaja.getSpeed());
     // ps.setDate(7, UtilToSQL.convertUtilToSql(prodaja.getDate()));
      ps.setLong(7, prodaja.getSerialNo());
      ps.executeUpdate();
     ps.close();
    }

    @Override
    public boolean update(ProdajaModel prodaja) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ProdajaModel prodaja) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProdajaModel> getAllSaleRecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    
}
