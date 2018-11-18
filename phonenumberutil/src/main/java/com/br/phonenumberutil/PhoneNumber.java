package com.br.phonenumberutil;

import android.support.annotation.NonNull;

import com.br.phonenumberutil.data.Country;
import com.br.phonenumberutil.data.PhoneNumberInfo;
import com.br.phonenumberutil.data.PhoneNumberType;
import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberToTimeZonesMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class PhoneNumber {

    private static PhoneNumber phoneNumber = new PhoneNumber();

    private PhoneNumberUtil phoneNumberUtil;
    private PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder;
    private PhoneNumberToCarrierMapper phoneNumberToCarrierMapper;
    private PhoneNumberToTimeZonesMapper phoneNumberToTimeZonesMapper;

    private PhoneNumber() {
        phoneNumberUtil = PhoneNumberUtil.getInstance();
        phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
        phoneNumberToCarrierMapper = PhoneNumberToCarrierMapper.getInstance();
        phoneNumberToTimeZonesMapper = PhoneNumberToTimeZonesMapper.getInstance();
    }

    public static PhoneNumber getInstance() {
        return phoneNumber;
    }

    public ArrayList<Country> getCountryDetails() {
        ArrayList<Country> country = new ArrayList();

        country.add(new Country("Afghanistan", 93, "AF"));
        country.add(new Country("Albania", 355, "AL"));
        country.add(new Country("Algeria", 213, "DZ"));
        country.add(new Country("American Samoa", 1, "AS"));
        country.add(new Country("Andorra", 376, "AD"));
        country.add(new Country("Angola", 244, "AO"));
        country.add(new Country("Anguilla", 1, "AI"));
        country.add(new Country("Antigua and Barbuda", 1, "AG"));
        country.add(new Country("Argentina", 54, "AR"));
        country.add(new Country("Armenia", 374, "AM"));
        country.add(new Country("Aruba", 297, "AW"));
        country.add(new Country("Ascension Island", 247, "AC"));
        country.add(new Country("Australia", 61, "AU"));
        country.add(new Country("Austria", 43, "AT"));
        country.add(new Country("Azerbaijan", 994, "AZ"));
        country.add(new Country("Bahamas", 1, "BS"));
        country.add(new Country("Bahrain", 973, "BH"));
        country.add(new Country("Bangladesh", 880, "BD"));
        country.add(new Country("Barbados", 1, "BB"));
        country.add(new Country("Belarus", 375, "BY"));
        country.add(new Country("Belgium", 32, "BE"));
        country.add(new Country("Belize", 501, "BZ"));
        country.add(new Country("Benin", 229, "BJ"));
        country.add(new Country("Bermuda", 1, "BM"));
        country.add(new Country("Bhutan", 975, "BT"));
        country.add(new Country("Bolivia", 591, "BO"));
        country.add(new Country("Bosnia and Herzegovina", 387, "BA"));
        country.add(new Country("Botswana", 267, "BW"));
        country.add(new Country("Brazil", 55, "BR"));
        country.add(new Country("British Indian Ocean Territory", 246, "IO"));
        country.add(new Country("British Virgin Islands", 1, "VG"));
        country.add(new Country("Brunei", 673, "BN"));
        country.add(new Country("Bulgaria", 359, "BG"));
        country.add(new Country("Burkina Faso", 226, "BF"));
        country.add(new Country("Burundi", 257, "BI"));
        country.add(new Country("Cambodia", 855, "KH"));
        country.add(new Country("Cameroon", 237, "CM"));
        country.add(new Country("Canada", 1, "CA"));
        country.add(new Country("Cape Verde", 238, "CV"));
        country.add(new Country("Caribbean Netherlands", 599, "BQ"));
        country.add(new Country("Cayman Islands", 1, "KY"));
        country.add(new Country("Central African Republic", 236, "CF"));
        country.add(new Country("Chad", 235, "TD"));
        country.add(new Country("Chile", 56, "CL"));
        country.add(new Country("China", 86, "CN"));
        country.add(new Country("Christmas Island", 61, "CX"));
        country.add(new Country("Cocos (Keeling) Islands", 61, "CC"));
        country.add(new Country("Colombia", 57, "CO"));
        country.add(new Country("Comoros", 269, "KM"));
        country.add(new Country("Congo (DRC)", 243, "CD"));
        country.add(new Country("Congo (Republic)", 242, "CG"));
        country.add(new Country("Cook Islands", 682, "CK"));
        country.add(new Country("Costa Rica", 506, "CR"));
        country.add(new Country("Croatia", 385, "HR"));
        country.add(new Country("Cuba", 53, "CU"));
        country.add(new Country("Curaçao", 599, "CW"));
        country.add(new Country("Cyprus", 357, "CY"));
        country.add(new Country("Czech Republic", 420, "CZ"));
        country.add(new Country("Côte d’Ivoire", 225, "CI"));
        country.add(new Country("Denmark", 45, "DK"));
        country.add(new Country("Djibouti", 253, "DJ"));
        country.add(new Country("Dominica", 1, "DM"));
        country.add(new Country("Dominican Republic", 1, "DO"));
        country.add(new Country("Ecuador", 593, "EC"));
        country.add(new Country("Egypt", 20, "EG"));
        country.add(new Country("El Salvador", 503, "SV"));
        country.add(new Country("Equatorial Guinea", 240, "GQ"));
        country.add(new Country("Eritrea", 291, "ER"));
        country.add(new Country("Estonia", 372, "EE"));
        country.add(new Country("Ethiopia", 251, "ET"));
        country.add(new Country("Falkland Islands (Islas Malvinas)", 500, "FK"));
        country.add(new Country("Faroe Islands", 298, "FO"));
        country.add(new Country("Fiji", 679, "FJ"));
        country.add(new Country("Finland", 358, "FI"));
        country.add(new Country("France", 33, "FR"));
        country.add(new Country("French Guiana", 594, "GF"));
        country.add(new Country("French Polynesia", 689, "PF"));
        country.add(new Country("Gabon", 241, "GA"));
        country.add(new Country("Gambia", 220, "GM"));
        country.add(new Country("Georgia", 995, "GE"));
        country.add(new Country("Germany", 49, "DE"));
        country.add(new Country("Ghana", 233, "GH"));
        country.add(new Country("Gibraltar", 350, "GI"));
        country.add(new Country("Greece", 30, "GR"));
        country.add(new Country("Greenland", 299, "GL"));
        country.add(new Country("Grenada", 1, "GD"));
        country.add(new Country("Guadeloupe", 590, "GP"));
        country.add(new Country("Guam", 1, "GU"));
        country.add(new Country("Guatemala", 502, "GT"));
        country.add(new Country("Guernsey", 44, "GG"));
        country.add(new Country("Guinea", 224, "GN"));
        country.add(new Country("Guinea-Bissau", 245, "GW"));
        country.add(new Country("Guyana", 592, "GY"));
        country.add(new Country("Haiti", 509, "HT"));
        country.add(new Country("Honduras", 504, "HN"));
        country.add(new Country("Hong Kong", 852, "HK"));
        country.add(new Country("Hungary", 36, "HU"));
        country.add(new Country("Iceland", 354, "IS"));
        country.add(new Country("India", 91, "IN"));
        country.add(new Country("Indonesia", 62, "ID"));
        country.add(new Country("Iran", 98, "IR"));
        country.add(new Country("Iraq", 964, "IQ"));
        country.add(new Country("Ireland", 353, "IE"));
        country.add(new Country("Isle of Man", 44, "IM"));
        country.add(new Country("Israel", 972, "IL"));
        country.add(new Country("Italy", 39, "IT"));
        country.add(new Country("Jamaica", 1, "JM"));
        country.add(new Country("Japan", 81, "JP"));
        country.add(new Country("Jersey", 44, "JE"));
        country.add(new Country("Jordan", 962, "JO"));
        country.add(new Country("Kazakhstan", 7, "KZ"));
        country.add(new Country("Kenya", 254, "KE"));
        country.add(new Country("Kiribati", 686, "KI"));
        country.add(new Country("Kuwait", 965, "KW"));
        country.add(new Country("Kyrgyzstan", 996, "KG"));
        country.add(new Country("Laos", 856, "LA"));
        country.add(new Country("Latvia", 371, "LV"));
        country.add(new Country("Lebanon", 961, "LB"));
        country.add(new Country("Lesotho", 266, "LS"));
        country.add(new Country("Liberia", 231, "LR"));
        country.add(new Country("Libya", 218, "LY"));
        country.add(new Country("Liechtenstein", 423, "LI"));
        country.add(new Country("Lithuania", 370, "LT"));
        country.add(new Country("Luxembourg", 352, "LU"));
        country.add(new Country("Macau", 853, "MO"));
        country.add(new Country("Macedonia (FYROM)", 389, "MK"));
        country.add(new Country("Madagascar", 261, "MG"));
        country.add(new Country("Malawi", 265, "MW"));
        country.add(new Country("Malaysia", 60, "MY"));
        country.add(new Country("Maldives", 960, "MV"));
        country.add(new Country("Mali", 223, "ML"));
        country.add(new Country("Malta", 356, "MT"));
        country.add(new Country("Marshall Islands", 692, "MH"));
        country.add(new Country("Martinique", 596, "MQ"));
        country.add(new Country("Mauritania", 222, "MR"));
        country.add(new Country("Mauritius", 230, "MU"));
        country.add(new Country("Mayotte", 262, "YT"));
        country.add(new Country("Mexico", 52, "MX"));
        country.add(new Country("Micronesia", 691, "FM"));
        country.add(new Country("Moldova", 373, "MD"));
        country.add(new Country("Monaco", 377, "MC"));
        country.add(new Country("Mongolia", 976, "MN"));
        country.add(new Country("Montenegro", 382, "ME"));
        country.add(new Country("Montserrat", 1, "MS"));
        country.add(new Country("Morocco", 212, "MA"));
        country.add(new Country("Mozambique", 258, "MZ"));
        country.add(new Country("Myanmar (Burma)", 95, "MM"));
        country.add(new Country("Namibia", 264, "NA"));
        country.add(new Country("Nauru", 674, "NR"));
        country.add(new Country("Nepal", 977, "NP"));
        country.add(new Country("Netherlands", 31, "NL"));
        country.add(new Country("New Caledonia", 687, "NC"));
        country.add(new Country("New Zealand", 64, "NZ"));
        country.add(new Country("Nicaragua", 505, "NI"));
        country.add(new Country("Niger", 227, "NE"));
        country.add(new Country("Nigeria", 234, "NG"));
        country.add(new Country("Niue", 683, "NU"));
        country.add(new Country("Norfolk Island", 672, "NF"));
        country.add(new Country("North Korea", 850, "KP"));
        country.add(new Country("Northern Mariana Islands", 1, "MP"));
        country.add(new Country("Norway", 47, "NO"));
        country.add(new Country("Oman", 968, "OM"));
        country.add(new Country("Pakistan", 92, "PK"));
        country.add(new Country("Palau", 680, "PW"));
        country.add(new Country("Palestine", 970, "PS"));
        country.add(new Country("Panama", 507, "PA"));
        country.add(new Country("Papua New Guinea", 675, "PG"));
        country.add(new Country("Paraguay", 595, "PY"));
        country.add(new Country("Peru", 51, "PE"));
        country.add(new Country("Philippines", 63, "PH"));
        country.add(new Country("Poland", 48, "PL"));
        country.add(new Country("Portugal", 351, "PT"));
        country.add(new Country("Puerto Rico", 1, "PR"));
        country.add(new Country("Qatar", 974, "QA"));
        country.add(new Country("Romania", 40, "RO"));
        country.add(new Country("Russia", 7, "RU"));
        country.add(new Country("Rwanda", 250, "RW"));
        country.add(new Country("Réunion", 262, "RE"));
        country.add(new Country("Saint Barthélemy", 590, "BL"));
        country.add(new Country("Saint Helena", 290, "SH"));
        country.add(new Country("Saint Kitts and Nevis", 1, "KN"));
        country.add(new Country("Saint Lucia", 1, "LC"));
        country.add(new Country("Saint Martin", 590, "MF"));
        country.add(new Country("Saint Pierre and Miquelon", 508, "PM"));
        country.add(new Country("Samoa", 685, "WS"));
        country.add(new Country("San Marino", 378, "SM"));
        country.add(new Country("Saudi Arabia", 966, "SA"));
        country.add(new Country("Senegal", 221, "SN"));
        country.add(new Country("Serbia", 381, "RS"));
        country.add(new Country("Seychelles", 248, "SC"));
        country.add(new Country("Sierra Leone", 232, "SL"));
        country.add(new Country("Singapore", 65, "SG"));
        country.add(new Country("Sint Maarten", 1, "SX"));
        country.add(new Country("Slovakia", 421, "SK"));
        country.add(new Country("Slovenia", 386, "SI"));
        country.add(new Country("Solomon Islands", 677, "SB"));
        country.add(new Country("Somalia", 252, "SO"));
        country.add(new Country("South Africa", 27, "ZA"));
        country.add(new Country("South Korea", 82, "KR"));
        country.add(new Country("South Sudan", 211, "SS"));
        country.add(new Country("Spain", 34, "ES"));
        country.add(new Country("Sri Lanka", 94, "LK"));
        country.add(new Country("St. Vincent & Grenadines", 1, "VC"));
        country.add(new Country("Sudan", 249, "SD"));
        country.add(new Country("Suriname", 597, "SR"));
        country.add(new Country("Svalbard and Jan Mayen", 47, "SJ"));
        country.add(new Country("Swaziland", 268, "SZ"));
        country.add(new Country("Sweden", 46, "SE"));
        country.add(new Country("Switzerland", 41, "CH"));
        country.add(new Country("Syria", 963, "SY"));
        country.add(new Country("São Tomé and Príncipe", 239, "ST"));
        country.add(new Country("Taiwan", 886, "TW"));
        country.add(new Country("Tajikistan", 992, "TJ"));
        country.add(new Country("Tanzania", 255, "TZ"));
        country.add(new Country("Thailand", 66, "TH"));
        country.add(new Country("Timor-Leste", 670, "TL"));
        country.add(new Country("Togo", 228, "TG"));
        country.add(new Country("Tokelau", 690, "TK"));
        country.add(new Country("Tonga", 676, "TO"));
        country.add(new Country("Trinidad and Tobago", 1, "TT"));
        country.add(new Country("Tristan da Cunha", 290, "TA"));
        country.add(new Country("Tunisia", 216, "TN"));
        country.add(new Country("Turkey", 90, "TR"));
        country.add(new Country("Turkmenistan", 993, "TM"));
        country.add(new Country("Turks and Caicos Islands", 1, "TC"));
        country.add(new Country("Tuvalu", 688, "TV"));
        country.add(new Country("U.S. Virgin Islands", 1, "VI"));
        country.add(new Country("Uganda", 256, "UG"));
        country.add(new Country("Ukraine", 380, "UA"));
        country.add(new Country("United Arab Emirates", 971, "AE"));
        country.add(new Country("United Kingdom", 44, "GB"));
        country.add(new Country("United States", 1, "US"));
        country.add(new Country("Uruguay", 598, "UY"));
        country.add(new Country("Uzbekistan", 998, "UZ"));
        country.add(new Country("Vanuatu", 678, "VU"));
        country.add(new Country("Vatican City", 39, "VA"));
        country.add(new Country("Venezuela", 58, "VE"));
        country.add(new Country("Vietnam", 84, "VN"));
        country.add(new Country("Wallis and Futuna", 681, "WF"));
        country.add(new Country("Western Sahara", 212, "EH"));
        country.add(new Country("Yemen", 967, "YE"));
        country.add(new Country("Zambia", 260, "ZM"));
        country.add(new Country("Zimbabwe", 263, "ZW"));
        country.add(new Country("Åland Islands", 358, "AX"));

        return country;
    }

    public String getSampleMobileNumber(@NonNull String countryISO) throws Exception {
        return getSampleNumber(PhoneNumberType.MOBILE, countryISO);
    }

    public String getSampleNumber(@NonNull PhoneNumberType phoneNumberType, @NonNull String countryISO) throws Exception {
        PhoneNumberUtil.PhoneNumberType numberType = PhoneNumberUtil.PhoneNumberType.MOBILE;

        switch (phoneNumberType) {
            case HOME:
                numberType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE;
                break;

            case MOBILE:
                numberType = PhoneNumberUtil.PhoneNumberType.MOBILE;
                break;

            case WORK:
                numberType = PhoneNumberUtil.PhoneNumberType.UAN;
                break;

            case PAGER:
                numberType = PhoneNumberUtil.PhoneNumberType.PAGER;
                break;

            case OTHERS:
                numberType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE;
                break;
        }

        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.getExampleNumberForType(countryISO, numberType);
        return getFormattedNumber(String.valueOf(phoneNumber.getNationalNumber()), countryISO);
    }

    public String getISO(@NonNull int countryCode) {
        return phoneNumberUtil.getRegionCodeForCountryCode(countryCode);
    }

    public int getCountryCode(@NonNull String countryISO) {
        return phoneNumberUtil.getCountryCodeForRegion(countryISO);
    }

    public int getCountryCode(@NonNull String number, @NonNull String countryISO) throws Exception {
        return normalize(number, countryISO).getCountryCode();
    }

    public long getNationalNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        return normalize(number, countryISO).getNationalNumber();
    }

    public boolean isPossibleNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberUtil.isPossibleNumber(normalize(number, countryISO));
    }

    public boolean isValidNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberUtil.isValidNumber(normalize(number, countryISO));
    }

    public boolean isValidNumberForRegion(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberUtil.isValidNumberForRegion(normalize(number, countryISO), countryISO);
    }

    public String getRegionCode(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberUtil.getRegionCodeForNumber(normalize(number, countryISO));
    }

    public String getFormattedNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        if (!isValidNumberForRegion(number, countryISO))
            throw new Exception(number + " is invalid");

        return phoneNumberUtil.format(normalize(number, countryISO), PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    public String getNationalFormattedNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        if (!isValidNumberForRegion(number, countryISO))
            throw new Exception(number + " is invalid");

        return phoneNumberUtil.format(normalize(number, countryISO), PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
    }

    public String getInternationalFormattedNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        if (!isValidNumberForRegion(number, countryISO))
            throw new Exception(number + " is invalid");

        return phoneNumberUtil.format(normalize(number, countryISO), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
    }

    public String getFormatOutOfCountryCallingNumber(@NonNull String number, @NonNull String countryISO) throws Exception {
        if (!isValidNumberForRegion(number, countryISO))
            throw new Exception(number + " is invalid");

        return phoneNumberUtil.formatOutOfCountryCallingNumber(normalize(number, countryISO), countryISO);
    }

    public PhoneNumberType getNumberType(@NonNull String number, @NonNull String countryISO) throws Exception {
        PhoneNumberType retVal;

        switch (phoneNumberUtil.getNumberType(normalize(number, countryISO))) {
            case FIXED_LINE:
                retVal = PhoneNumberType.HOME;
                break;

            case MOBILE:
            case FIXED_LINE_OR_MOBILE:
            case PERSONAL_NUMBER:
            case VOIP:
                retVal = PhoneNumberType.MOBILE;
                break;

            case UAN:
                retVal = PhoneNumberType.WORK;
                break;

            case PAGER:
                retVal = PhoneNumberType.PAGER;
                break;

            case TOLL_FREE:
            case PREMIUM_RATE:
            case SHARED_COST:
            case VOICEMAIL:
                retVal = PhoneNumberType.OTHERS;
                break;

            case UNKNOWN:
            default:
                retVal = PhoneNumberType.OTHERS;
                break;
        }

        return retVal;
    }

    public String getLocation(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberOfflineGeocoder.getDescriptionForNumber(normalize(number, countryISO), Locale.ENGLISH);
    }

    public String getCarrier(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberToCarrierMapper.getNameForNumber(normalize(number, countryISO), Locale.ENGLISH);
    }

    public List<String> getTimeZone(@NonNull String number, @NonNull String countryISO) throws Exception {
        return phoneNumberToTimeZonesMapper.getTimeZonesForNumber(normalize(number, countryISO));
    }

    public PhoneNumberInfo getNumberInfo(@NonNull String number, @NonNull String countryISO) throws Exception {
        return getPhoneNumberInfo(number, countryISO);
    }

    public List<PhoneNumberInfo> getNumbersInfoFromString(@NonNull String data, @NonNull String countryISO) throws Exception {
        List<PhoneNumberInfo> retVal = new ArrayList<>();

        Iterable<PhoneNumberMatch> matches = phoneNumberUtil.findNumbers(data, countryISO);
        Iterator<PhoneNumberMatch> iterator = matches.iterator();
        while (iterator.hasNext()) {
            PhoneNumberMatch phoneNumberMatch = iterator.next();
            retVal.add(getPhoneNumberInfo(phoneNumberMatch.rawString(), countryISO));
        }

        return retVal;
    }

    private PhoneNumberInfo getPhoneNumberInfo(String number, String countryISO) throws Exception {
        PhoneNumberInfo retVal = new PhoneNumberInfo();
        retVal.setCountryCode(getCountryCode(number, countryISO));
        retVal.setNationalNumber(getNationalNumber(number, countryISO));
        retVal.setPossibleNumber(isPossibleNumber(number, countryISO));
        retVal.setValidNumber(isValidNumber(number, countryISO));
        retVal.setValidNumberForRegion(isValidNumberForRegion(number, countryISO));
        retVal.setRegionCode(getRegionCode(number, countryISO));
        retVal.setFormattedNumber(getFormattedNumber(number, countryISO));
        retVal.setNationalFormattedNumber(getNationalFormattedNumber(number, countryISO));
        retVal.setInternationalFormattedNumber(getInternationalFormattedNumber(number, countryISO));
        retVal.setPhoneNumberType(getNumberType(number, countryISO));
        retVal.setLocation(getLocation(number, countryISO));
        retVal.setCarrier(getCarrier(number, countryISO));
        retVal.setTimeZone(getTimeZone(number, countryISO));

        return retVal;
    }

    private Phonenumber.PhoneNumber normalize(String number, String countryISO) throws Exception {
        return phoneNumberUtil.parse(number, countryISO);
    }
}
