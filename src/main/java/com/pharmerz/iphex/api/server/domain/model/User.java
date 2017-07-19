/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmerz.iphex.api.server.domain.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ankur
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    })
public class User extends Domain implements Serializable {

    private static final long serialVersionUID = 1L;



    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;

    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;



    @Basic(optional = false)
    @Column(name = "EMAIL", unique = true)
    private String email;

    @Basic(optional = false)
    @Column(name = "MOBILE")
    private String mobile;


    @Column(name = "DESIGNATION")
    @Basic(optional = false)
    private String designation;


    @Column(name = "TYPE")
    @Basic(optional = false)
    private String type;

    @Column(name = "CITY")
    @Basic(optional = false)
    private String city;


    @Column(name = "COUNTRY")
    @Basic(optional = false)
    private String country;




    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
