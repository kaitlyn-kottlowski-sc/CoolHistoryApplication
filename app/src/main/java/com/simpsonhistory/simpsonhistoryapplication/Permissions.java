package com.simpsonhistory.simpsonhistoryapplication;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


class Permissions {

    private static final int REQUEST_FINE_LOCATION = 0x1;
    static boolean checkPermissions(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissions(activity);
            return false;
        }
    }

    private static void requestPermissions(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_FINE_LOCATION);
    }
}
