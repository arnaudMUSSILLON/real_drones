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
     * Calculate the distance between 2 adresses (Haversine formula)
     * @param a first address
     * @param b second address
     * @return distance in km
     */
    public double calculationDistance(Address a, Address b){
        double R = 6372.8;    // radius in km
        double dLat = Math.toRadians(b.getLat() - a.getLat());
        double dLon = Math.toRadians(b.getLong() - a.getLong());
        double latA = Math.toRadians(a.getLat());
        double latB = Math.toRadians(b.getLat());
 
        double aa = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(latA) * Math.cos(latB);
        double c = 2 * Math.asin(Math.sqrt(aa));
        return (R * c);
    }
}
