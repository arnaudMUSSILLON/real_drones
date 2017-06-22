/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import map.*;

/**
 *
 * @author arnaudmussillon
 */
public class Controller {
    private Depots depots;
    private Stores stores;
    private Customers customers;
    private Operations operations;
    
    /**
     * Constructor
     */
    public Controller(){
        this.operations = new Operations();
        
        //init depots, stores and customers addresses
        this.depots = new Depots();
        this.stores = new Stores();
        this.customers = new Customers();
        
        //load the adresses
        this.depots.loadData();
        this.stores.loadData();
        this.customers.loadData();
        
        this.Manager(this.customers.getAddresses().get(3));
    }
    
    
    
    public void Manager(Address customerAddress){
        
        //search for the closest store
        Address closestStore;
        closestStore = this.searchClosest(customerAddress, this.stores.getAddresses());
        
        //search for the closer depot
        Address closestDepot;
        closestDepot = this.searchClosest(closestStore, this.depots.getAddresses());
        
        System.out.println(customerAddress.getLabel()+" --> "+closestStore.getLabel()+" --> "+closestDepot.getLabel());
    }
    
    
    public Address searchClosest(Address a, ArrayList<Address> b){
        Address address = null;
        double dist = 10000;
        for(int i=0; i<b.size(); i++){
            double temp = operations.calculationDistance(a, b.get(i));
            temp *= 100; //conversion in km
            
            System.out.println(temp +" "+ dist);
            if(temp < dist){
                address = b.get(i);
                dist = temp;
            }
        }
        
        return address;
    }
}
