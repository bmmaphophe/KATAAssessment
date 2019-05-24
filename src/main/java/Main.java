
import co.za.kataassessment.utility.JsonUtility;
import co.za.kataassessment.json.model.Address;
import co.za.kataassessment.utility.HighestCommonFactor;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brookmaphophe
 */
public class Main {

    public static void main(String[] args) {
        
        int[] values = {1701,3768,96};
        int size = values.length;
        HighestCommonFactor hcf = new HighestCommonFactor();
        System.out.println("Highest Common Factor: " + hcf.getHCF(values, size)+ "\n\n") ;
        
        JsonUtility json = new JsonUtility();
        json.loadJson();
       
    }

}
