
package application;

import java.io.Serializable;

import java.util.Random;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProdajaModel implements Serializable {
  
    private final SimpleLongProperty id = new SimpleLongProperty();
  
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
   
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
  
    private final SimpleStringProperty city = new SimpleStringProperty("");
    
    private final SimpleStringProperty address = new SimpleStringProperty("");
  
    private final SimpleStringProperty email = new SimpleStringProperty("");
   
    private final SimpleStringProperty speed = new SimpleStringProperty("");
    
    private final SimpleStringProperty date = new SimpleStringProperty("");
    
   private static final long LOWER_RANGE = 1;
   private static final long UPPER_RANGE = 1000000000;
     private Random randomNo = new Random();
    
     private long serialNo = LOWER_RANGE + (long)(randomNo.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
     
  
     
    
   public ProdajaModel(long id, String firstName, String lastName, String city, String address, String email, String speed, String date, long serialNo){
       setId(id);
       setFirstName(firstName);
       setLastName(lastName);
       setCity(city);
       setAddress(address);
       setEmail(email);
       setSpeed(speed);
       setDate(date);
      this.serialNo=serialNo;
   }
    public ProdajaModel(){
        
    }
    public long getId() {
        return id.get();
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id.set(id);
    }
   
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName.get();
    }

    
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName.get();
    }

   
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

 
     
    public String getCity() {
        return city.get();
    }
   
   
    public void setCity(String city) {
        this.city.set(city);
    }

    
    public String getAddress() {
        return address.get();
    }

    
    public void setAddress(String address) {
        this.address.set(address);
    }

   
    public String getEmail() {
        return email.get();
    }

    
    public void setEmail(String email) {
        this.email.set(email);
    }

   
    public String getSpeed() {
        return speed.get();
    }

   
    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

   public void setSerialNo(long serialNo){
       this.serialNo=serialNo;
   }
    public long getSerialNo(){
        return  serialNo;
    }

    public String getDate(){
        return date.get();
    }
    void setDate(String date) {
        this.date.set(date);
    }
   
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Ime: ").append(firstName).append("\n");
        sb.append("Prezime: ").append(lastName).append("\n");
        sb.append("Grad: ").append(city).append("\n");
        sb.append("Adresa: ").append(address).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Brzina: ").append(speed).append("\n");
        sb.append("Datum: ").append(date).append("\n");
        sb.append("Serijski broj: ").append(serialNo).append("\n");
        return sb.toString();
      
    }
}
