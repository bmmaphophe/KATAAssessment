/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.kataassessment.json.model;

import java.util.Date;
/**
 *
 * @author brookmaphophe
 */
public class Address {
    private int id;
    private CodeAndName type;
    private AddressLineDetail addressLineDetail ;
    private CodeAndName provinceOrState ;
    private String  cityOrTown;
    private CodeAndName country;
    private String postalCode;
    private Date lastUpdated ;
    private String suburbOrDistrict;

    
      public Address() {
        this.id = 0;
        this.type = new CodeAndName();
        this.addressLineDetail = new AddressLineDetail();
        this.provinceOrState = new CodeAndName();
        this.cityOrTown = "";
        this.country = new CodeAndName();
        this.postalCode = "";
        this.lastUpdated = new Date();
        this.suburbOrDistrict = "";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public CodeAndName getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(CodeAndName type) {
        this.type = type;
    }

    /**
     * @return the addressLineDetail
     */
    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    /**
     * @param addressLineDetail the addressLineDetail to set
     */
    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    /**
     * @return the provinceOrState
     */
    public CodeAndName getProvinceOrState() {
        return provinceOrState;
    }

    /**
     * @param provinceOrState the provinceOrState to set
     */
    public void setProvinceOrState(CodeAndName provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    /**
     * @return the cityOrTown
     */
    public String getCityOrTown() {
        return cityOrTown;
    }

    /**
     * @param cityOrTown the cityOrTown to set
     */
    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    /**
     * @return the country
     */
    public CodeAndName getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(CodeAndName country) {
        this.country = country;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the suburbOrDistrict
     */
    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    /**
     * @param suburbOrDistrict the suburbOrDistrict to set
     */
    public void setSuburbOrDistrict(String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }
}
