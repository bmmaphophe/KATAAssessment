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
public class HighestCommonFactor {
    
    public int getHCF(int arr[] , int numberOfElements){
        
        int firstNumber = arr[0];
        
        for(int i  =  1;i < numberOfElements;i++ ){
            
            firstNumber = hcf(arr[i] , firstNumber);
        }
        return firstNumber;
    }
    
    private int hcf(int a, int b){
       
        if(a == 0){
            return b;
        }
        return hcf(b % a , a);
    }
    
}
