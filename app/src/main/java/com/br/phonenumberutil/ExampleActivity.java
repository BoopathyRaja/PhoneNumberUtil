package com.br.phonenumberutil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.br.commonutils.base.CUBasedActivity;
import com.br.commonutils.base.permission.PermissionHandler;
import com.br.commonutils.data.permission.DangerousPermission;
import com.br.commonutils.helper.jsonizer.GsonJsonizer;
import com.br.commonutils.log.Logger;
import com.br.commonutils.provider.Task;
import com.br.commonutils.util.CommonUtil;
import com.br.phonenumberutil.data.ContactInfo;
import com.br.phonenumberutil.data.PhoneNumberInfo;

import java.util.List;

public class ExampleActivity extends CUBasedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        init();
    }

    @Override
    public void init() {
        checkPermission(CommonUtil.asList(DangerousPermission.READ_CONTACTS));
    }

    private void checkPermission(List<DangerousPermission> dangerousPermissionList) {
        requestPermission(dangerousPermissionList, new PermissionHandler() {
            @Override
            public void result(List<DangerousPermission> granted, List<DangerousPermission> denied) {
                try {
                    readPhoneNumberInfo();
                    readContact();
                } catch (Exception e) {

                }
            }

            @Override
            public boolean permissionRationale() {
                return true;
            }

            @Override
            public void permissionRationaleFor(List<DangerousPermission> dangerousPermissions) {
                checkPermission(dangerousPermissionList);
            }

            @Override
            public void info(String message) {

            }
        });
    }

    private void readPhoneNumberInfo() throws Exception {
        PhoneNumberInfo numberNumberInfo = PhoneNumber.getInstance().getNumberInfo("9688220919", "IN");
        Logger.logInfo("PhoneNumberInfo", GsonJsonizer.getInstance().to(numberNumberInfo));
    }

    private void readContact() throws Exception {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            return;

        Contact.init(this);
        Contact.getInstance().loadPhoneContacts(new Task<List<ContactInfo>>() {
            @Override
            public void success(List<ContactInfo> result) {

            }

            @Override
            public void failure(String message) {

            }
        });
    }
}
