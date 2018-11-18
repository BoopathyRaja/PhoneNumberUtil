package com.br.phonenumberutil.data;

import java.io.Serializable;

public class Country implements Serializable {

    private String countryName;
    private int countryCode;
    private String countryISO;

    public Country(String countryName, int countryCode, String countryISO) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryISO = countryISO;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return "+" + countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }
}
