/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.utility;
import co.za.kataassessment.json.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author brookmaphophe
 */
public class JsonUtility {

    private static final Logger LOGGER = Logger.getLogger("JsonUtility");

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param addresses
     *
     * @throws Exception
     *
     * @return void 
     *
     */
    public String formatType(List<Address>addresses) {
        StringBuilder value = new StringBuilder();
        try {
            if (addresses == null || addresses.isEmpty()) {
                throw new Exception("Addresses array is null or empty");
            }
            // formating the requered fields
            for (Address address : addresses) {
                
                value.append("Type :").append(address.getAddressLineDetail().getLine1()).append(" -city ").append(address.getCityOrTown()).append(" -province/state ").append(address.getProvinceOrState().getName()).append("  -postal code  ").append(address.getPostalCode()).append("  -country  ").append(address.getCountry().getName()).append("\n\n");
            }

            return value.toString();
        } catch (Exception e) {

            LOGGER.log(Level.WARNING, e.toString());
        }
        return "";
    }

    /**
     * @param addresses
     *
     * This Method is to formats the JSon
     * 
     * @throws Exception
     *
     * @return void 
     *
     */
    public String prettyPrintAddress(List<Address> addresses) {
        String formatedJson = "";
        try {
            if (addresses == null || addresses.isEmpty()) {
                throw new Exception("Addresses array is null or empty");
            }
            // formating the json
            formatedJson = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT).writerWithDefaultPrettyPrinter().writeValueAsString(addresses);
        } catch (Exception e) {

            LOGGER.log(Level.WARNING, e.toString());
        }

        return formatedJson;
    }

    /**
     * @param addresses 
     * @param addressType
     *
     * This is to display the address
     * 
     * 
     *
     * @return void
     *
     */
    public String chooseAddresType(List<Address> addresses, String addressType) {

        String jsonStr = "";
        try {
            if (addresses == null || addresses.isEmpty()) {
                throw new Exception("Addresses array is null or empty");
            }

            for (Address address : addresses) {
                // get the Address that matches the address type
                if (address.getType().getName().toUpperCase().equals(addressType.toUpperCase())) {
                    jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
                    break;
                }
            }

        } catch (Exception e) {

            LOGGER.log(Level.WARNING, e.toString());
        }
        return jsonStr;
    }

    /**
     * @param addresses
     *
     * This Method Checks if Address are valid
     * 
     * 
     *
     * @return boolean
     *
     */
    public boolean areAddressesValid(List<Address> addresses) {
        try {
            if (addresses == null || addresses.isEmpty()) {
                throw new Exception("Addresses array is null or empty");
            }

            for (Address address : addresses) {
                // Checking if the Postal code is not empty or null
                if ("".equals(address.getPostalCode()) || !NumberUtils.isNumber(address.getPostalCode())) {
                    throw new Exception("PostalCode is null or empty");
                }
                // Checking if the code has ZA
                if (address.getCountry().getCode().toUpperCase().contains("ZA")) {
                    if (address.getProvinceOrState().getName() == null) {
                        throw new Exception("Code is not ZA");
                    }
                }

                // Checking if AddressLineDetail  is not null
                if (address.getAddressLineDetail().getLine1() == null || address.getAddressLineDetail().getLine2() == null) {
                    throw new Exception("AddressLineDetail is null ");
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString());
            return false;
        }

        return true;

    }

    /**
     * @param addresses
     * 
     *
     * This method check if the JSon is Valid
     *
     * @return boolean
     *
     */
    public boolean isJsonValid(List<Address> addresses) {

        try {
             if (addresses == null || addresses.isEmpty()) {
                throw new Exception("Addresses array is null or empty");
            }
            // Attempt write and read to check if JSon is valid
            String jsonStr = objectMapper.writeValueAsString(addresses);
            objectMapper.readTree(jsonStr);

        } catch (Exception ex) {

            LOGGER.log(Level.WARNING, ex.toString());
            return false;
        }
        return true;
    }

}
