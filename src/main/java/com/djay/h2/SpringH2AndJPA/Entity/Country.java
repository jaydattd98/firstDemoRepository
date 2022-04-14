package com.djay.h2.SpringH2AndJPA.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
@NamedQuery(name = "Country.getAllCountries", query = "SELECT c FROM Country c")
public class Country {
    @Id
    String code;
    String name;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
