package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.Objects;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap map;
    private SupportMapFragment mapFrag;
    private LocationRequest mLocationRequest;
    private Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;
    protected static final int REQUEST_FINE_LOCATION = 0x1;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        startLocationUpdates();

        Objects.requireNonNull(getSupportActionBar()).setTitle("Simpson College Map");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFusedLocationClient = getFusedLocationProviderClient(this);
        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.simpson_map);
        assert mapFrag != null;
        mapFrag.getMapAsync(this);

    }


    protected void startLocationUpdates() {

        final long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
        final long FASTEST_INTERVAL = 2000;

        // Create the location request to start receiving updates
        mLocationRequest = new LocationRequest();
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

        // new Google API SDK v11 uses getFusedLocationProviderClient(this)
        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest,
                new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        onLocationChanged(locationResult.getLastLocation());
                    }
                },
                Looper.myLooper());
    }

    public void onLocationChanged(Location location) {

        // UPDATING LOCATION IF CHANGED

        if(mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
            mCurrLocationMarker = null;
        }

        // Get current location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        // Get marker icon
        final Drawable starDrawable = getResources().getDrawable(R.drawable.ic_star_transparent_24dp);
        final BitmapDescriptor icon = getMarkerIconFromDrawable(starDrawable);

        // Set new location to current marker, set icon
        mCurrLocationMarker = Buildings.setMarker(mCurrLocationMarker, latLng, map, "Current Location");
        mCurrLocationMarker.setIcon(icon);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Set map to satellite mode
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Check permissions
        if (Permissions.checkPermissions(this)) {
            googleMap.setMyLocationEnabled(true);
        }

        // Set View Location
        Buildings.setViewLocation(map);

        // Get array of building marker objects
        final Marker[] buildingMarkers = Buildings.getBuildingMarkers(map);

        final Intent intent = new Intent(this,HistoryActivity.class );
        // Marker Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                for (int i = 0; i < buildingMarkers.length; i++) {
                    if (marker.getTag() == Buildings.buildingLatLngs[i]) {
                        int id = Buildings.buildingLayoutIDs[i];
                        intent.putExtra("layout_id", id);
                        startActivity(intent);
                    }
                }
                return false;

            }
        });

    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


}



