/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  Abstract class containing 
 * @author arnaudmussillon
 */
public abstract class Adresses {
    protected String path;
    protected final ArrayList<Address> addresses;
    
    /**
     * Constructor
     * @param _path path+name of the csv file
     */
    public Adresses(String _path){
        this.addresses = new ArrayList();
        this.path = _path;
    }
    
    
    /**
     * Load data of a CSV file in an array of adresses
     */
    public void loadData(){
        try{
            FileReader fr = new FileReader(this.path);        
            BufferedReader br = new BufferedReader(fr);

            String stringRead = br.readLine();
            
            //while line isn't empty
            while( stringRead != null )
            {
                StringTokenizer st = new StringTokenizer(stringRead, ";");
                String addr = st.nextToken();
                double x = Double.parseDouble(st.nextToken());  //change type in double
                double y = Double.parseDouble(st.nextToken());
          
                Address address = new Address(addr,x,y);        //create an adress object
                this.addresses.add(address);

                // read the next line
                stringRead = br.readLine();
            }

            br.close();
            fr.close();
        }catch(Exception e){
            e.getMessage();
        }
        
    }
    
    /**
     * get Addresses
     * @return array of addresses
     */
    public ArrayList<Address> getAddresses(){
        return this.addresses;
    }
    
    /**
     *get path
     * @return path+name of the csv file
     */
    public String getPath(){
        return this.path;
    }
   
}
