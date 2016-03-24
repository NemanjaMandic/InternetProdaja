/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.List;

/**
 *
 * @author nemus
 */
public interface ProdajaDAO{
    
    public void insert(ProdajaModel prodaja) throws Exception;
    public void update(ProdajaModel prodaja) throws Exception;
    public void delete(ProdajaModel prodaja) throws Exception;
    List<ProdajaModel> getAllSaleRecord();
      
   

}