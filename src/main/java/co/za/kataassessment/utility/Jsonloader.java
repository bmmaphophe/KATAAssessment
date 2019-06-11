/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.utility;

import co.za.kataassessment.json.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brookmaphophe
 */
public class Jsonloader {
    
      private static final Logger LOGGER = Logger.getLogger("Jsonloader");

    ObjectMapper objectMapper = new ObjectMapper();
    
     /**
     *
     * @param fileName
     *
     * This Method loads JSon and it Converts to JOPO
     *
     * @return addresses
     */
    public List<Address> loadJson(String fileName) {
        try {

            List<Address> addresses = Arrays.asList(objectMapper.readValue(new File(fileName), Address[].class));
            
            return addresses;
            
        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.toString());
        }

        return null;
    }
    
}
