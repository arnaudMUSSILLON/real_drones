/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import map.*;
import time.Timer;

/**
 *
 * @author arnaudmussillon
 */
public class Controller {
    private Depots depots;
    private Stores stores;
    private Customers customers;
    private Operations operations;
    private View view;
    private Distance distanceStore;
    private Distance distanceDepot;
    private int speed; //in km/h
    
    /**
     * Constructor
     */
    public Controller(View _view){
        this.operations = new Operations();
        this.speed = 60;
        
        //init depots, stores and customers addresses
        this.depots = new Depots();
        this.stores = new Stores();
        this.customers = new Customers();
        
        //load the adresses
        this.depots.loadData();
        this.stores.loadData();
        this.customers.loadData();
        
        //Handle the view
        this.view = _view;
        this.updateCustomerAdresses();
    }
    
    
    /**
     * Process of the application
     * @param customerAddress address of the customers
     */
    public void manager(Address customerAddress){
        
        //search for the closest store
        Address closestStore;
        closestStore = this.searchClosest(customerAddress, this.stores.getAddresses(), "stores");
        Timer timeStore = new Timer();
        
        //search for the closer depot
        Address closestDepot;
        closestDepot = this.searchClosest(closestStore, this.depots.getAddresses(), "depots");
        Timer timeDepot = new Timer();
        
        //calculate the time
        double toReachStore = timeStore.calculateTime(this.distanceStore.getDistance(), this.speed);
        double toReachDepot = timeDepot.calculateTime(this.distanceDepot.getDistance(), this.speed);
        
        //update the result in the view
        this.view.displayResult(closestStore.getLabel(), closestDepot.getLabel(), 
                this.distanceStore.getDistance(), this.distanceDepot.getDistance(),
                toReachStore, toReachDepot);
        //System.out.println(customerAddress.getLabel()+" --> "+closestStore.getLabel()+" --> "+closestDepot.getLabel());
    }
    
    
    /**
     * Search the closest address
     * @param a starting point
     * @param b array of targeted addresses 
     * @param listName which list of addresses is this
     * @return the closest address
     */
    public Address searchClosest(Address a, ArrayList<Address> b, String listName){
        Address address = null;
        double dist = 10000;
        for(int i=0; i<b.size(); i++){
            double temp = operations.calculationDistance(a, b.get(i));
            
            if(temp < dist){
                address = b.get(i);
                dist = temp;
            }
        }    
        //set the distance
        Distance d = new Distance(dist);
        if(listName == "stores"){
            this.distanceStore = d;
        }else{
            this.distanceDepot = d;
        }
        
        return address;
    }
    
    
    /**
     * update the combobox in the view
     */
    public void updateCustomerAdresses(){
        for(int i=0;i<this.customers.getAddresses().size(); i++){
            view.addCustomerComboBox(this.customers.getAddresses().get(i).getLabel());
        }
    }
    
    
    /**
     * Giving a string, return the address object
     * @param label string
     * @return Address
     */
    public Address findAdressCustomer(String label){
        Address res = null;
        for(int i=0;i<this.customers.getAddresses().size(); i++){
            if(label.equals(this.customers.getAddresses().get(i).getLabel())){
                res = this.customers.getAddresses().get(i);
            }
        }
        
        return res;
    }
    
}
