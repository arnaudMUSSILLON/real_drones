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
public class Address {
    private final String label;
    private final double lat;
    private final double lon;
    
    public Address(String _label, double _lat, double _lon){
        this.label = _label;
        this.lat = _lat;
        this.lon = _lon;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public double getLong(){
        return this.lon;
    }
    
    public double getLat(){
        return this.lat;
    }
}
