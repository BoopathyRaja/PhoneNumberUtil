package com.br.phonenumberutil.data;

import com.br.commonutils.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public enum EmailType {

    GMAIL("@gmail.com"),
    YAHOO("@yahoo.com"),
    HOTMAIL("@hotmail.com"),
    OUTLOOK("@outlook.com"),
    LIVE("@live.com"),
    OTHERS("");

    private static final Map<String, EmailType> VALUES = new HashMap<>();

    private String emailType;

    EmailType(String emailType) {
        this.emailType = emailType;
    }

    public static EmailType to(String emailAddress) {
        EmailType retVal = null;

        if (Validator.isValid(emailAddress)) {
            String domain = emailAddress.substring(emailAddress.indexOf("@"));
            EmailType result = VALUES.get(domain);

            retVal = Validator.isValid(result) ? result : EmailType.OTHERS;
        }

        return retVal;
    }

    static {
        for (EmailType type : values())
            VALUES.put(type.emailType, type);
    }
}
