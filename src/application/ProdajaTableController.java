/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author nemus
 */
public class ProdajaTableController implements Initializable, TableDAO {

    @FXML private TableView<ProdajaModel> salesTable;
    @FXML private TableColumn id;
    @FXML private TableColumn fname;
    @FXML private TableColumn lname;
    @FXML private TableColumn city;
    @FXML private TableColumn address;
    @FXML private TableColumn email;
    @FXML private TableColumn speed;
    @FXML private TableColumn date;
    @FXML private TableColumn serialNo;
    
    private Connection conn = null;
    final ObservableList<ProdajaModel> data = FXCollections.observableArrayList();
    
    private PreparedStatement ps;
    private ResultSet rs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
    @Override
    public List<ProdajaModel> getAllSaleRecord() {
        List<ProdajaModel> sales = new LinkedList<>();
        try{
            String sql = "SELECT * FROM sales";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            ProdajaModel sale = new ProdajaModel();
            while(rs.next()){
                sale.setId(rs.getLong("id"));
                sale.setFirstName(rs.getString("firstName"));
                sale.setLastName(rs.getString("lastName"));
                sale.setCity(rs.getString("city"));
                sale.setAddress(rs.getString("address"));
                sale.setEmail(rs.getString("email"));
                sale.setSpeed(rs.getString("speed"));
                sale.setDate(rs.getString("date"));
                sale.setSerialNo(rs.getLong("serialNo"));
                
                salesTable.setItems((ObservableList<ProdajaModel>) sales);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(sales);
        return sales;
    }
  */

      @Override
    public List<ProdajaModel> getAllSaleRecord() {
        ProdajaModel prod = new ProdajaModel();
      try{
          String sql = "SELECT * FROM sales";
          ps = conn.prepareStatement(sql);
          rs = ps.executeQuery();
          while(rs.next()){
              data.add(new ProdajaModel(
                      rs.getLong("id"),
                      rs.getString("firstName"),
                      rs.getString("lastName"),
                      rs.getString("city"),
                      rs.getString("address"),
                      rs.getString("email"),
                      rs.getString("speed"),
                      rs.getString("date"),
                      rs.getLong("serialNo")
              ));
              
              salesTable.setItems(data);
          }
          ps.close();
          rs.close();
      }catch(Exception ex){
          ex.printStackTrace();
      }
        return null;
    }
   
    
}
