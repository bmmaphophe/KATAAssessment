
import co.za.kataassessment.utility.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brookmaphophe
 */
public class NumberUtilsTest {
    
    
     @Test
    public void positiveisNumberTest(){
        
        boolean expexted = true;
        
        boolean realValue = NumberUtils.isNumber("565");
        
        Assert.assertEquals(expexted, realValue);
       
    }
     
    @Test
    public void negativeisNumberTest(){
        
        boolean expexted = false;
        
        boolean realValue = NumberUtils.isNumber("fffff");
        
        Assert.assertEquals(expexted, realValue);
       
    }
    
}
