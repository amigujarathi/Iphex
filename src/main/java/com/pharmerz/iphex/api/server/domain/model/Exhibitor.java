package com.pharmerz.iphex.api.server.domain.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by i5 on 4/15/2017.
 */

@Entity
@Table(name = "EXHIBITORS")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Exhibitor.findAll", query = "SELECT e FROM Exhibitor e"),

})
public class Exhibitor extends Domain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "STALL")
    private String stall;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "PERSON")
    private String person;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY_CODE")
    private String countrycode;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "COMPANY_PROFILE")
    private String companyprofile;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "PXL")
    private String pxl;


    public Exhibitor() {
    }


    public Exhibitor(String stall, String company, String person, String address, String city, String pincode, String state, String countrycode, String mobile, String email, String website, String companyprofile, String product, String pxl) {
        this.stall = stall;
        this.company = company;
        this.person = person;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.countrycode = countrycode;
        this.mobile = mobile;
        this.email = email;
        this.website = website;
        this.companyprofile = companyprofile;
        this.product = product;
        this.pxl = pxl;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStall() {
        return stall;
    }

    public void setStall(String stall) {
        this.stall = stall;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyprofile() {
        return companyprofile;
    }

    public void setCompanyprofile(String companyprofile) {
        this.companyprofile = companyprofile;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPxl() {
        return pxl;
    }

    public void setPxl(String pxl) {
        this.pxl = pxl;
    }


}
