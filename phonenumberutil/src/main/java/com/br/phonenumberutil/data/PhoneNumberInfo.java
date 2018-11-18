package com.br.phonenumberutil.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberInfo implements Serializable {

    private int countryCode;
    private long nationalNumber;
    private boolean isPossibleNumber;
    private boolean isValidNumber;
    private boolean isValidNumberForRegion;
    private String regionCode;
    private String formattedNumber;
    private String nationalFormattedNumber;
    private String internationalFormattedNumber;
    private PhoneNumberType phoneNumberType;
    private String location;
    private String carrier;
    private List<String> timeZone;

    public PhoneNumberInfo() {
        timeZone = new ArrayList<>();
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public long getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(long nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public boolean isPossibleNumber() {
        return isPossibleNumber;
    }

    public void setPossibleNumber(boolean possibleNumber) {
        isPossibleNumber = possibleNumber;
    }

    public boolean isValidNumber() {
        return isValidNumber;
    }

    public void setValidNumber(boolean validNumber) {
        isValidNumber = validNumber;
    }

    public boolean isValidNumberForRegion() {
        return isValidNumberForRegion;
    }

    public void setValidNumberForRegion(boolean validNumberForRegion) {
        isValidNumberForRegion = validNumberForRegion;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getFormattedNumber() {
        return formattedNumber;
    }

    public void setFormattedNumber(String formattedNumber) {
        this.formattedNumber = formattedNumber;
    }

    public String getNationalFormattedNumber() {
        return nationalFormattedNumber;
    }

    public void setNationalFormattedNumber(String nationalFormattedNumber) {
        this.nationalFormattedNumber = nationalFormattedNumber;
    }

    public String getInternationalFormattedNumber() {
        return internationalFormattedNumber;
    }

    public void setInternationalFormattedNumber(String internationalFormattedNumber) {
        this.internationalFormattedNumber = internationalFormattedNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public List<String> getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(List<String> timeZone) {
        this.timeZone = timeZone;
    }
}
