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
public class Distance {
    private double km;
    
    public Distance(double _km){
        this.km = _km;
    }
    
    public double getDistance(){
        return this.km;
    }
}
