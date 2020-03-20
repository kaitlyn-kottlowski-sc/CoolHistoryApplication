package com.simpsonhistory.simpsonhistoryapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import java.util.Objects;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        startLocationUpdates();

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        // Reference: https://stackoverflow.com/questions/10108774/how-to-implement-the-android-actionbar-back-button
        String mapTitle = getResources().getString(R.string.mapOfSimpsonCollegeCampus);
        Objects.requireNonNull(getSupportActionBar()).setTitle(mapTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Reference: https://www.youtube.com/watch?v=eiexkzCI8m8&feature=youtu.be
        SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.simpsonMap);
        if(mapFrag == null) throw new AssertionError("Object cannot be null");
        mapFrag.getMapAsync(this);
    }

    // Reference: https://guides.codepath.com/android/Retrieving-Location-with-LocationServices-API
    private void startLocationUpdates() {

        final long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
        final long FASTEST_INTERVAL = 2000;

        // Create the location request to start receiving updates
        final LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);

        // Create LocationSettingsRequest object using location request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        // Check whether location settings are satisfied
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);
    }

    // Reference: https://www.youtube.com/watch?v=eiexkzCI8m8&feature=youtu.be
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Check permissions
        if (Permissions.checkPermissions(this)) {
            googleMap.setMyLocationEnabled(true);
        }

        // Set map to satellite mode
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Set View Location
        Buildings.setViewLocation(googleMap);

        // Get array of building marker objects
        final Marker[] buildingMarkers = Buildings.getBuildingMarkers(googleMap);

        final Intent intent = new Intent(this,HistoryInfoActivity.class );
        // Marker Clicker
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                for (int i = 0; i < buildingMarkers.length; i++) {
                    if (marker.getTag() == Buildings.buildingLatLngs[i]) {
                        final String name = Buildings.buildingNames[i];
                        int[] ids = Buildings.buildingInfo[i];

                        intent.removeExtra("image2");
                        intent.removeExtra("history2");

                        for (int j = 0; j < ids.length; j++)
                        {
                            if (ids.length == 5)
                            {
                                intent.putExtra(Buildings.idNamesForOneImage[j], ids[j]);

                            }
                            else intent.putExtra(Buildings.idNamesForTwoImages[j], ids[j]);
                        }

                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                }
                return false;
            }
        });
    }
}