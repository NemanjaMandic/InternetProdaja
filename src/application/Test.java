/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.Connection;
import java.sql.Date;


/**
 *
 * @author nemus
 */
public class Test {
    
    static Connection conn = null;
   public static void main(String[] args) throws Exception{
     
      
    ProdajaDAOImpl prod = new ProdajaDAOImpl();
    prod.getConnection();
       
    //  prod.getAllSaleRecord();
    
       
      
   } 
   
   public static void checkConn(){
       // conn = DBConnection.DBConnector();
        if(conn == null){
            System.err.println("Jaajjkkss");
        }else{
            System.out.println("Konekcija je OKEJ");
        }
   }
}
