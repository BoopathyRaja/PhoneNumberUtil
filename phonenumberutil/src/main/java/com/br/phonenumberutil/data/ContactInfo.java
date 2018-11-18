package com.br.phonenumberutil.data;

import com.br.commonutils.data.common.Address;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class ContactInfo implements Serializable {

    private String id;
    private String displayName;
    private String avatar;
    private Map<PhoneNumberType, Set<String>> phoneNumbers;
    private Map<EmailType, Set<String>> emails;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Map<PhoneNumberType, Set<String>> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneNumberType, Set<String>> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<EmailType, Set<String>> getEmails() {
        return emails;
    }

    public void setEmails(Map<EmailType, Set<String>> emails) {
        this.emails = emails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
