package com.br.phonenumberutil;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;

import com.br.commonutils.data.common.Address;
import com.br.commonutils.log.Logger;
import com.br.commonutils.provider.Task;
import com.br.commonutils.validator.Validator;
import com.br.phonenumberutil.data.ContactInfo;
import com.br.phonenumberutil.data.EmailType;
import com.br.phonenumberutil.data.PhoneNumberType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Contact {

    private static final String TAG = Contact.class.getSimpleName();

    private static Contact contact;

    private Context context;
    private String countryISO = "IN";
    private PhoneNumber phoneNumber;

    private Contact(Context context) {
        this.context = context;

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String networkISO = telephonyManager.getNetworkCountryIso().toUpperCase();
        if (Validator.isValid(networkISO))
            countryISO = networkISO;

        phoneNumber = PhoneNumber.getInstance();
    }

    public static void init(@NonNull Context context) {
        contact = new Contact(context);
    }

    public static Contact getInstance() throws IllegalAccessException {
        if (!Validator.isValid(contact))
            throw new IllegalAccessException("Call init()");

        return contact;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(@NonNull String countryISO) {
        this.countryISO = countryISO;
    }

    @RequiresPermission(Manifest.permission.READ_CONTACTS)
    public void loadSIMContacts(@NonNull Task<List<ContactInfo>> task) {
        List<ContactInfo> retVal = new ArrayList<>();

        Uri uri = Uri.parse("content://icc/adn");
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = "name ASC";

        Cursor cursor = context.getContentResolver().query(uri, selectionArgs, selection, projection, sortOrder);
        if (Validator.isValid(cursor) && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String contact_id = cursor.getString(cursor.getColumnIndex("_id"));
                String displayName = cursor.getString(cursor.getColumnIndex("name"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("number"));
                String email = cursor.getString(cursor.getColumnIndex("emails"));

                Set<String> numbers = new HashSet<>();
                numbers.add(phoneNumber);

                Map<PhoneNumberType, Set<String>> phoneNumbers = new HashMap<>();
                phoneNumbers.put(PhoneNumberType.OTHERS, numbers);

                Set<String> _email = new HashSet<>();
                _email.add(email);

                Map<EmailType, Set<String>> emails = new HashMap<>();
                emails.put(EmailType.OTHERS, _email);

                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setId(contact_id);
                contactInfo.setDisplayName(displayName);
                contactInfo.setPhoneNumbers(phoneNumbers);
                contactInfo.setEmails(emails);

                retVal.add(contactInfo);
            }
        }

        task.success(retVal);
    }

    @RequiresPermission(Manifest.permission.READ_CONTACTS)
    public void loadPhoneContacts(@NonNull Task<List<ContactInfo>> task) {
        List<ContactInfo> retVal = new ArrayList<>();

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC";

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        if (Validator.isValid(cursor) && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String contact_id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String avatar = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
                Map<PhoneNumberType, Set<String>> phoneNumbers = readPhoneNumbers(contentResolver, cursor, contact_id);
                Map<EmailType, Set<String>> emails = readEmails(contentResolver, contact_id);
                Address address = readAddress(contentResolver, contact_id);

                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setId(contact_id);
                contactInfo.setDisplayName(displayName);
                contactInfo.setAvatar(avatar);
                contactInfo.setPhoneNumbers(phoneNumbers);
                contactInfo.setEmails(emails);
                contactInfo.setAddress(address);

                retVal.add(contactInfo);
            }
        }

        task.success(retVal);
    }

    private Map<PhoneNumberType, Set<String>> readPhoneNumbers(ContentResolver contentResolver, Cursor cursor, String contact_id) {
        Map<PhoneNumberType, Set<String>> retVal = new HashMap<>();

        int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
        if (hasPhoneNumber > 0) {
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            String[] projection = null;
            String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
            String[] selectionArgs = new String[]{contact_id};
            String sortOrder = null;

            Cursor phoneCursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
            while (phoneCursor.moveToNext()) {
                try {
                    String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    String formattedPhoneNumber = this.phoneNumber.getFormattedNumber(phoneNumber, countryISO);
                    PhoneNumberType phoneNumberType = this.phoneNumber.getNumberType(formattedPhoneNumber, countryISO);

                    Set<String> numbers = retVal.get(phoneNumberType);
                    if (!Validator.isValid(numbers))
                        numbers = new HashSet<>();

                    numbers.add(formattedPhoneNumber);
                    retVal.put(phoneNumberType, numbers);
                } catch (Exception e) {
                    Logger.logWarn(TAG, e.getLocalizedMessage());
                }
            }

            phoneCursor.close();
        }

        return retVal;
    }

    private Map<EmailType, Set<String>> readEmails(ContentResolver contentResolver, String contact_id) {
        Map<EmailType, Set<String>> retVal = new HashMap<>();

        Uri uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String[] projection = null;
        String selection = ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?";
        String[] selectionArgs = new String[]{contact_id};
        String sortOrder = null;

        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        while (cursor.moveToNext()) {
            String email = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
            EmailType emailType = EmailType.to(email);

            if (Validator.isValid(emailType)) {
                Set<String> _email = retVal.get(emailType);
                if (!Validator.isValid(_email))
                    _email = new HashSet<>();

                _email.add(email);
                retVal.put(emailType, _email);
            }
        }

        cursor.close();
        return retVal;
    }

    private Address readAddress(ContentResolver contentResolver, String contact_id) {
        Address retVal = new Address();

        Uri uri = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI;
        String[] projection = null;
        String selection = ContactsContract.CommonDataKinds.StructuredPostal.CONTACT_ID + " = ?";
        String[] selectionArgs = new String[]{contact_id};
        String sortOrder = null;

        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        while (cursor.moveToNext()) {
            String addressLine = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));
            String street = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
            String city = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
            String state = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION));
            String zipCode = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE));

            retVal.setAddressLine(addressLine);
            retVal.setState(street);
            retVal.setCity(city);
            retVal.setState(state);
            retVal.setZipCode(zipCode);
        }

        cursor.close();
        return retVal;
    }
}
