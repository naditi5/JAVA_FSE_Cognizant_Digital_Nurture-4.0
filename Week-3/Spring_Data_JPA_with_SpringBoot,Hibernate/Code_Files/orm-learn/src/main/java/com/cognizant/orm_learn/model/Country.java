package com.cognizant.orm_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    // getters and setters
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="co_name")
    public String getName() {
    	return name;
    }
    
    @Column(name="co_code")
    public String getCode() {
    	return code;
    }
    

    // toString()
    @Override
    public String toString() {
        return "Country {name=" + name + ", code=" + code + "}";
    }

}
