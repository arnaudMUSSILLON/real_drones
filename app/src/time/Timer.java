/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author arnaudmussillon
 */
public class Timer {
    
    /**
     * Constructor
     */
    public Timer(){
    }
    
    /**
     * Calculate the time to reach a destination
     * @param distance distance to do
     * @param speed 
     * @return time in seconds
     */
    public double calculateTime(double distance, double speed){
        double time;
        speed = speed/3.6;     //speed in m/s
        distance *= 1000;
        time = distance / speed;
        
        return time;
    }
    
}
