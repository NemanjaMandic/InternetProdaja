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
public interface TableDAO extends Connectable{
   
     List<ProdajaModel> getAllSaleRecord();
}