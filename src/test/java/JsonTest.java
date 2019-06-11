
import co.za.kataassessment.json.model.Address;
import co.za.kataassessment.json.model.AddressLineDetail;
import co.za.kataassessment.json.model.CodeAndName;
import co.za.kataassessment.utility.AddressType;
import co.za.kataassessment.utility.JsonUtility;
import co.za.kataassessment.utility.Jsonloader;
import java.util.ArrayList;
import java.util.List;
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
public class JsonTest {

    Jsonloader jsonloader = new Jsonloader();

    JsonUtility jsonUtility = new JsonUtility();

    @Test
    public void positiveJsonLoaderTest() {

        List<Address> addresses = jsonloader.loadJson("addresses.json");

        int expexted = 3;

        int realVlaue = addresses.size();

        Assert.assertEquals(expexted, realVlaue);

    }

    @Test
    public void negativeJsonLoaderTest() {

        List<Address> addresses = jsonloader.loadJson("addresses1.json");

        List<Address> expexted = null;

        List<Address> realVlaue = addresses;

        Assert.assertEquals(expexted, realVlaue);

    }

    @Test
    public void isFormatTypeNullTest() {

        String expexted = "";

        String realValue = jsonUtility.formatType(null);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isFormatEmptyTest() {

        List<Address> addresses = new ArrayList<>();

        String expexted = "";

        String realValue = jsonUtility.formatType(addresses);
        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isPrettyPrintAddressNullTest() {

        String expexted = "";

        String realValue = jsonUtility.prettyPrintAddress(null);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isPrettyPrintAddressEmptyTest() {

        List<Address> addresses = new ArrayList<>();
        String expexted = "";

        String realValue = jsonUtility.prettyPrintAddress(addresses);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isChooseAddresTypeNullTest() {

        String expexted = "";

        String realValue = jsonUtility.chooseAddresType(null, AddressType.EMPTY_ADDRESS);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isChooseAddresTypeEmptyTest() {

        List<Address> addresses = new ArrayList<>();
        String expexted = "";

        String realValue = jsonUtility.chooseAddresType(addresses, AddressType.EMPTY_ADDRESS);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void positiveChooseAddresTypTest() {

        Address address = new Address();

        address.setCityOrTown("City 1");
        address.setSuburbOrDistrict(" Test suburbOrDistrict");
        address.setPostalCode("1234");

        CodeAndName codeAndName = new CodeAndName();
        codeAndName.setCode("2");
        codeAndName.setName("Eastern Cape");
        address.setProvinceOrState(codeAndName);

        CodeAndName codeAndNameCountry = new CodeAndName();
        codeAndNameCountry.setCode("ZA");
        codeAndNameCountry.setName("South Africa");
        address.setCountry(codeAndNameCountry);

        AddressLineDetail addressLineDetail = new AddressLineDetail();

        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        address.setAddressLineDetail(addressLineDetail);

        CodeAndName codeAndNameType = new CodeAndName();
        codeAndNameType.setCode("1");
        codeAndNameType.setName("Physical Address");

        address.setType(codeAndNameType);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        String expexted = "";

        String realValue = jsonUtility.chooseAddresType(addresses, AddressType.PHYSICAL_ADDRESS);

        Assert.assertNotSame(realValue, expexted);

    }

    @Test
    public void negativeChooseAddresTypTest() {

        Address address = new Address();

        address.setCityOrTown("City 1");
        address.setSuburbOrDistrict(" Test suburbOrDistrict");
        address.setPostalCode("1234");

        CodeAndName codeAndName = new CodeAndName();
        codeAndName.setCode("2");
        codeAndName.setName("Eastern Cape");
        address.setProvinceOrState(codeAndName);

        CodeAndName codeAndNameCountry = new CodeAndName();
        codeAndNameCountry.setCode("ZA");
        codeAndNameCountry.setName("South Africa");
        address.setCountry(codeAndNameCountry);

        AddressLineDetail addressLineDetail = new AddressLineDetail();

        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        address.setAddressLineDetail(addressLineDetail);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        String expexted = "";

        String realValue = jsonUtility.chooseAddresType(addresses, AddressType.PHYSICAL_ADDRESS);

        Assert.assertEquals(expexted, realValue);

    }

    @Test
    public void areAddressesValidNullTest() {

        boolean expexted = false;

        boolean realValue = jsonUtility.areAddressesValid(null);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void areAddressesValidEmptyTest() {

        List<Address> addresses = new ArrayList<>();
        boolean expexted = false;

        boolean realValue = jsonUtility.areAddressesValid(addresses);

        Assert.assertEquals(expexted, realValue);
    }
    
    
     @Test
    public void positiveAreAddressesValidTest() {

        Address address = new Address();

        address.setCityOrTown("City 1");
        address.setSuburbOrDistrict(" Test suburbOrDistrict");
        address.setPostalCode("1234");

        CodeAndName codeAndName = new CodeAndName();
        codeAndName.setCode("2");
        codeAndName.setName("Eastern Cape");
        address.setProvinceOrState(codeAndName);

        CodeAndName codeAndNameCountry = new CodeAndName();
        codeAndNameCountry.setCode("ZA");
        codeAndNameCountry.setName("South Africa");
        address.setCountry(codeAndNameCountry);

        AddressLineDetail addressLineDetail = new AddressLineDetail();

        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        address.setAddressLineDetail(addressLineDetail);

        CodeAndName codeAndNameType = new CodeAndName();
        codeAndNameType.setCode("1");
        codeAndNameType.setName("Physical Address");

        address.setType(codeAndNameType);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        boolean expexted = true;

        boolean realValue = jsonUtility.areAddressesValid(addresses);

        Assert.assertEquals(realValue, expexted);

    }

    @Test
    public void negativeAreAddressesValidTest() {

        Address addressA = new Address();

        addressA.setCityOrTown("City 1");
        addressA.setSuburbOrDistrict(" Test suburbOrDistrict");
        addressA.setPostalCode("1234");

        CodeAndName codeAndNameCountry = new CodeAndName();
        codeAndNameCountry.setCode("ZA");
        codeAndNameCountry.setName("South Africa");
        addressA.setCountry(codeAndNameCountry);

        AddressLineDetail addressLineDetail = new AddressLineDetail();

        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        addressA.setAddressLineDetail(addressLineDetail);

        List<Address> addresses = new ArrayList<>();
        addresses.add(addressA);

        boolean expexted = false;

        boolean realValue = jsonUtility.areAddressesValid(addresses);

        Assert.assertEquals(expexted, realValue);

    }
    
    
     @Test
    public void isJsonValiddNullTest() {

        boolean expexted = false;

        boolean realValue = jsonUtility.isJsonValid(null);

        Assert.assertEquals(expexted, realValue);
    }

    @Test
    public void isJsonValidEmptyTest() {

        List<Address> addresses = new ArrayList<>();
        boolean expexted = false;

        boolean realValue = jsonUtility.isJsonValid(addresses);

        Assert.assertEquals(expexted, realValue);
    }
    
    

}
