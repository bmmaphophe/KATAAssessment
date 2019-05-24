/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.utility;


import co.za.kataassessment.json.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;



/**
 *
 * @author brookmaphophe
 */
public class JsonUtility {

    ObjectMapper objectMapper = new ObjectMapper();
    
    String type = "business Address";

    public void loadJson() {
        try {
            
            Address[] addresses = objectMapper.readValue(new File("addresses.json"), Address[].class); 

            formatType(addresses);
            
            prettyPrintAddress(addresses);
            
            chooseAddresType(addresses,type);
            
            validateAddress(addresses);
            
            isJsonValid(addresses);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formatType(Address[] addresses) {
        try {
            for (Address address : addresses) {
                System.out.println("Type :" + address.getAddressLineDetail().getLine1() + " -city " + address.getCityOrTown() + " -province/state " + address.getProvinceOrState().getName() + "  -postal code  " + address.getPostalCode() + "  -country  " + address.getCountry().getName());
            }

        } catch (Exception e) {

        }

    }

    private void prettyPrintAddress(Address[] addresses) throws JsonProcessingException {
        
        String jsonStr = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT).writerWithDefaultPrettyPrinter().writeValueAsString(addresses);
        System.out.println("\n\n "+jsonStr);
    }
    
    private void chooseAddresType(Address[] addresses , String addressType) throws JsonProcessingException{
        
        for(Address address: addresses){
            if(address.getType().getName().toUpperCase().equals(addressType.toUpperCase())){
                String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
                System.out.println(" CHOOSEN ADDRESS: \n\n "+jsonStr + "\n");
                break;
            }
        }
    }
    
    
    private void validateAddress(Address[] addresses){
        boolean isAddressValid = true;
        for(Address address: addresses){
            
            if("".equals(address.getPostalCode()) || !NumberUtils.isNumber(address.getPostalCode())){
                isAddressValid = false;
            }
            if(address.getCountry().getCode().toUpperCase().contains("ZA")){
                if(address.getProvinceOrState()== null){
                   isAddressValid = false;
                }
            } 
            if(address.getAddressLineDetail().getLine1() == null){
                isAddressValid = false;
            }
               
            if(!isAddressValid){
                System.out.println("This Address is Not Valid : " + address.getType().getName());
            }
        }
    }
    
    private void isJsonValid(Address[] addresses) throws JsonProcessingException{

        String jsonStr = objectMapper.writeValueAsString(addresses);
        try {
           objectMapper.readTree(jsonStr);
        } catch (IOException ex) {
            System.out.println("This Json File id not Valid: " + ex);
        }
 
    }
    
    

}
