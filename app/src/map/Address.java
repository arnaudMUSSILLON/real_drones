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
    private final double posX;
    private final double posY;
    
    public Address(String _label, double _x, double _y){
        this.label = _label;
        this.posX = _x;
        this.posY = _y;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public double getPosX(){
        return this.posX;
    }
    
    public double getPosY(){
        return this.posY;
    }
}
