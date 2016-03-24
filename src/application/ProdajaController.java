/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author nemus
 */
public class ProdajaController implements Initializable, ProdajaDAO {
    
    private Connection conn = null;
   
    @FXML private DatePicker dateField;
    @FXML private TextField fnameField;
    @FXML private TextField lnameField;
    @FXML private TextField cityTextField;
    @FXML private TextField addressField;
    @FXML private TextField emailTextField;
    @FXML private TextField idTextField;
    @FXML private ComboBox<String> speedCombo;
    
    @FXML private TableView<ProdajaModel> salesTable;
    
    
    @FXML
    private TableColumn<ProdajaModel, Long> id;


    @FXML
    private TableColumn<ProdajaModel, String> dateCol;

    @FXML
    private TableColumn<ProdajaModel, String> fname;


    @FXML
    private TableColumn<ProdajaModel, String> address;


    @FXML
    private TableColumn<ProdajaModel, String> city;

    @FXML
    private TableColumn<ProdajaModel, String> email;

    @FXML
    private TableColumn<ProdajaModel, String> speed;

    @FXML
    private TableColumn<ProdajaModel, Long> serialNo;

    @FXML
    private TableColumn<ProdajaModel, String> lname;
    ObservableList<String> list = FXCollections.observableArrayList("10","20","50","100");
   
    final ObservableList<ProdajaModel> data = FXCollections.observableArrayList();
    
    private PreparedStatement ps;
    private ResultSet rs;
     
   
    @FXML
    private void save(ActionEvent event) throws Exception {
    
      
      // LocalDate localDate = date.getValue();
        ProdajaModel prod = new ProdajaModel();
        prod.setFirstName(fnameField.getText());
        prod.setLastName(lnameField.getText());
        prod.setCity(cityTextField.getText());
        prod.setAddress(addressField.getText());
        prod.setEmail(emailTextField.getText());
        prod.setSpeed(speedCombo.getValue());
        prod.setDate(dateField.getValue().toString());
        prod.getSerialNo();
       
       
        insert(prod);
     
        
    }
    @FXML 
    private void delete(ActionEvent event){
        ProdajaModel prod = new ProdajaModel();
        prod.setId(Long.parseLong(idTextField.getText()));
        try {
            delete(prod);
        } catch (Exception ex) {
            Logger.getLogger(ProdajaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void edit(ActionEvent event){
        ProdajaModel prod = new ProdajaModel();
        prod.setId(Long.parseLong(idTextField.getText()));
        try{
            update(prod);
        } catch (Exception ex) {
            Logger.getLogger(ProdajaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void pregled(ActionEvent event) throws IOException{
       
        getAllSaleRecord();
    }
    @FXML
    private void fetchDataFromTable(ActionEvent event){
        List selected = (List) salesTable.getSelectionModel();
    }
    private void clearFields(){
        fnameField.clear();
        lnameField.clear();
        cityTextField.clear();
        addressField.clear();
        emailTextField.clear();
        speedCombo.setValue(null);
        dateField.setValue(null);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       speedCombo.setItems(list);
       
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
       fname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
       lname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
       address.setCellValueFactory(new PropertyValueFactory<>("address"));
       city.setCellValueFactory(new PropertyValueFactory<>("city"));
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
       speed.setCellValueFactory(new PropertyValueFactory<>("speed"));
       dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       serialNo.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
       
   }    

    @Override
    public void insert(ProdajaModel prodaja) throws Exception {
      conn = DBConnection.DBConnector();
      String sql = "INSERT INTO sales(firstName, lastName, city, address, email, speed, date, serialNo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      
      ps.setString(1, prodaja.getFirstName());
      ps.setString(2, prodaja.getLastName());
      ps.setString(3, prodaja.getCity());
      ps.setString(4, prodaja.getAddress());
      ps.setString(5, prodaja.getEmail());
      ps.setString(6, prodaja.getSpeed());
    
      ps.setString(7, ((TextField)dateField.getEditor()).getText());
      ps.setLong(8, prodaja.getSerialNo());
      ps.executeUpdate();
      
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Podatak o prodaji je uspesno unet.");
        alert.showAndWait();
        clearFields();
        
      getAllSaleRecord();
     ps.close();
    }

    @Override
    public void update(ProdajaModel prodaja) throws Exception {
       conn = DBConnection.DBConnector();
      String sql = "UPDATE sales SET firstName=?, lastName=?, city=?, address=?, email=?, speed=?, date=?, serialNo=? WHERE id='"+prodaja.getId()+"'";
      ps = conn.prepareStatement(sql);
      
      ps.setString(1, prodaja.getFirstName());
      ps.setString(2, prodaja.getLastName());
      ps.setString(3, prodaja.getCity());
      ps.setString(4, prodaja.getAddress());
      ps.setString(5, prodaja.getEmail());
      ps.setString(6, prodaja.getSpeed());
    
      ps.setString(7, ((TextField)dateField.getEditor()).getText());
      ps.setLong(8, prodaja.getSerialNo());
      ps.executeUpdate();
      
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Podatak je izmenjen.");
        alert.showAndWait();
        clearFields();
        
      getAllSaleRecord();
     ps.close();
    }

    @Override
    public void delete(ProdajaModel prodaja) throws Exception {
       conn = DBConnection.DBConnector();
       
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrdi");
        alert.setHeaderText(null);
        alert.setContentText("Obriši podatak ?");
       Optional<ButtonType>action = alert.showAndWait();
        if(action.get() == ButtonType.OK){
            String sql = "DELETE FROM sales WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Long.toString(prodaja.getId()));
        
            ps.executeUpdate();
            ps.close();
        }
       
       
       clearFields();
       getAllSaleRecord();
    }

    @Override
    public List<ProdajaModel> getAllSaleRecord() {
      
      try{
            conn = DBConnection.DBConnector();
            
             data.clear();
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
