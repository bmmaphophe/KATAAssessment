/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.utility;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brookmaphophe
 */
public class HighestCommonFactor {
    
      private static final Logger LOGGER = Logger.getLogger("HighestCommonFactor");
    
    /**
     * @param  arr of number
     * 
     * This Method is getting Highest Common factor from an Array of number
     * 
     * @return  integer
     **/
    public int getHCF(int arr[]) {
        int firstNumber = 0;
        try {

            if (arr.length == 0) {

                throw new Exception("array is null or empty");
            }
            firstNumber = arr[0];

            for (int i = 1; i < arr.length; i++) {

                firstNumber = hcf(arr[i], firstNumber);
            }

        } catch (Exception e) {

            LOGGER.log(Level.WARNING, e.toString());
        }
        return firstNumber;
    }
    
    /**
     * @param  integer
     * 
     * this Method Checks the Remender of numbers
     * 
     * @return  integer
     **/
    private int hcf(int a, int b){
       
        if(a == 0){
            return b;
        }
        return hcf(b % a , a);
    }
    
}
