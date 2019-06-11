
import co.za.kataassessment.utility.HighestCommonFactor;
import org.junit.Assert;
import static org.junit.Assert.fail;
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
public class HCFTest {
    
    
    @Test
    public void positiveGetHCFTest(){
        
        int[] values = {1701,3768,96};
        HighestCommonFactor highestCommonFactor = new HighestCommonFactor();
        
        int expexted = 3;
        
        int realValue = highestCommonFactor.getHCF(values);
        
        Assert.assertEquals(expexted, realValue);
       
    }
     
    @Test
    public void negativeGetHCFTest(){
        
        int[] values = null;
        HighestCommonFactor highestCommonFactor = new HighestCommonFactor();
        
        int expexted = 0;
        
        int realValue = highestCommonFactor.getHCF(values);
        
        Assert.assertEquals(expexted, realValue);
       
    }
        
}
