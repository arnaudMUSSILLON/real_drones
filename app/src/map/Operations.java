/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author arnaudmussillon
 */
public class Operations {
    
    /**
     * Constructor
     */
    public Operations(){
        
    }
    
    /**
     * Calculate the distance between 2 adresses
     * @param a first address
     * @param b second address
     * @return 
     */
    public double calculationDistance(Address a, Address b){
        double distance = Math.sqrt(Math.pow(b.getPosX()-a.getPosX(),2) + Math.pow(b.getPosY()-a.getPosY(), 2));
        return distance;
    }
}
