/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import map.*;

/**
 *
 * @author arnaudmussillon
 */
public class Controller {
    
    /**
     * Constructor
     */
    public Controller(){
        
        //init depots, stores and customers addresses
        Depots depots = new Depots();
        Stores stores = new Stores();
        Customers customers = new Customers();
        
        //load the adresses
        depots.loadData();
        stores.loadData();
        customers.loadData();
        
        System.out.println(depots.getAddresses());
    }
}
