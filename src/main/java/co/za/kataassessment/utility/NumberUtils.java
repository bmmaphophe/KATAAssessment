/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.utility;

/**
 *
 * @author brookmaphophe
 */
public class NumberUtils {
    
    
    public static boolean  isNumber(String value){
        
       
        return value.matches("-?\\d+(\\.\\d+)?");
    }
}
