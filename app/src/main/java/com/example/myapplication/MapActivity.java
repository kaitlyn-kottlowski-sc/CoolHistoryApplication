package com.example.myapplication;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MapActivity extends FragmentActivity implements
        OnMapReadyCallback

{

    private GoogleMap map;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;
    protected static final int REQUEST_FINE_LOCATION = 0x1;

    private long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        startLocationUpdates();

        mFusedLocationClient = getFusedLocationProviderClient(this);
        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.simpson_map);
        assert mapFrag != null;
        mapFrag.getMapAsync(this);

    }

    protected void startLocationUpdates() {

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
        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        // do work here
                        onLocationChanged(locationResult.getLastLocation());
                    }
                },
                Looper.myLooper());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        // Set map to satellite mode
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        if(checkPermissions()) {
            googleMap.setMyLocationEnabled(true);
        }

        // Zoom in vicinity of Simpson Campus
        final LatLng simpson = new LatLng(41.365475, -93.564849);
        final CameraUpdate newLoc = CameraUpdateFactory.newLatLngZoom(simpson, 17);
        map.animateCamera(newLoc);


        // Initialize Building LatLng and Markers
        final LatLng wallaceHallLatLng = new LatLng(41.365112, -93.562948);
        final LatLng maryBerryLatLng = new LatLng(41.365537, -93.564544);
        final LatLng carverHallLatLng = new LatLng(41.363742, -93.563243);
        final LatLng collegeHallLatLng = new LatLng(41.364976, -93.563648);
        final LatLng smithChapelLatLng = new LatLng(41.364191, -93.562678);
        final LatLng hopperGymLatLng = new LatLng(41.365530, -93.565462);
        final LatLng cowlesLatLng = new LatLng(41.365907, -93.565964);
        final LatLng mcNeillHallLatLng = new LatLng(41.364399, -93.564544);
        final LatLng hillmanHallLatLng = new LatLng(41.364231, -93.564044);
        final LatLng bpacLatLng = new LatLng(41.365412, -93.567308);
        final LatLng kentLatLng = new LatLng(41.366596, -93.565547);
        final LatLng lekburgHallLatLng = new LatLng(41.364779, -93.562696);
        final LatLng greatPfiefferLatLng = new LatLng(41.365849, -93.563772);
        final LatLng buxtonStadiumLatLng = new LatLng(41.364268, -93.565690);
        final LatLng dunnLibraryLatLng = new LatLng(41.365502, -93.563619);

        final Marker wallaceHall = map.addMarker(new MarkerOptions().position(wallaceHallLatLng)
                .title("Wallace Hall"));
        final Marker marryBerry = map.addMarker(new MarkerOptions().position(maryBerryLatLng)
                .title("Mary Berry"));
        final Marker carverHall = map.addMarker(new MarkerOptions().position(carverHallLatLng)
                .title("Carver Hall"));
        final Marker collegeHall = map.addMarker(new MarkerOptions().position(collegeHallLatLng)
                .title("College Hall"));
        final Marker smithChapel = map.addMarker(new MarkerOptions().position(smithChapelLatLng)
                .title("Smith Chapel"));
        final Marker hopperGym = map.addMarker(new MarkerOptions().position(hopperGymLatLng)
                .title("Hopper Gymnasium"));
        final Marker cowlesFieldhouse = map.addMarker(new MarkerOptions().position(cowlesLatLng)
                .title("Cowles Fieldhouse"));
        final Marker mcNeillHall = map.addMarker(new MarkerOptions().position(mcNeillHallLatLng)
                .title("McNeill Hall"));
        final Marker hillmanHall = map.addMarker(new MarkerOptions().position(hillmanHallLatLng)
                .title("Hillman Hall"));
        final Marker bpac = map.addMarker(new MarkerOptions().position(bpacLatLng)
                .title("BPAC"));
        final Marker kent = map.addMarker(new MarkerOptions().position(kentLatLng)
                .title("Kent Campus Center"));
        final Marker lekburgHall = map.addMarker(new MarkerOptions().position(lekburgHallLatLng)
                .title("Lekburg Recital Hall"));
        final Marker greatPfieffer = map.addMarker(new MarkerOptions().position(greatPfiefferLatLng)
                .title("Great Hall/Pfieffer"));
        final Marker buxtonStadium = map.addMarker(new MarkerOptions().position(buxtonStadiumLatLng)
                .title("Bill Buxton Stadium"));
        final Marker dunnLibrary = map.addMarker(new MarkerOptions().position(dunnLibraryLatLng)
                .title("Dunn Library"));

        wallaceHall.setTag(wallaceHallLatLng);
        marryBerry.setTag(maryBerryLatLng);
        carverHall.setTag(carverHallLatLng);
        collegeHall.setTag(collegeHallLatLng);
        smithChapel.setTag(smithChapelLatLng);
        hopperGym.setTag(hopperGymLatLng);
        cowlesFieldhouse.setTag(cowlesLatLng);
        mcNeillHall.setTag(mcNeillHallLatLng);
        hillmanHall.setTag(hillmanHallLatLng);
        bpac.setTag(bpacLatLng);
        kent.setTag(kentLatLng);
        lekburgHall.setTag(lekburgHallLatLng);
        greatPfieffer.setTag(greatPfiefferLatLng);
        buxtonStadium.setTag(buxtonStadiumLatLng);
        dunnLibrary.setTag(dunnLibraryLatLng);


        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == wallaceHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

    }

    public void onLocationChanged(Location location) {
        // You can now create a LatLng Object for use with maps
        final LatLng latLng = new LatLng(41.365475, -93.564849);
        // LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        // probably need to make star bigger
        final Drawable starDrawable = getResources().getDrawable(R.drawable.ic_star_black_24dp);
        final BitmapDescriptor icon = getMarkerIconFromDrawable(starDrawable);
        mCurrLocationMarker = map.addMarker(new MarkerOptions().position(latLng)
                .title("Current Location").icon(icon));
        mCurrLocationMarker.setTag("Current Location");

    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissions();
            return false;
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_FINE_LOCATION);
    }




}



