package com.example.myapplication;


import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.os.Looper;
import android.view.View;

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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);




        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.simpson_map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);



    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        // Set map to satellite mode
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Zoom in vicinity of Simpson Campus
        final LatLng simpson = new LatLng(41.365475, -93.564849);
        final CameraUpdate newLoc = CameraUpdateFactory.newLatLngZoom(simpson, 17);
        map.animateCamera(newLoc);

        // Initialize Building LatLng and Markers
        final LatLng wallaceHallLatLng = new LatLng(41.365112, -93.562948);
        final LatLng maryBerryLatLng = new LatLng(41.365537, -93.564544);
        final LatLng carverHallLatLng = new LatLng(41.363742, -93.563243);
        final LatLng collegeHallLatLng = new LatLng(41.364976, -93.563648);
        final LatLng amyRobinsonLatLng = new LatLng(41.364743, -93.562664);
        final LatLng smithChapelLatLng = new LatLng(41.364191, -93.562678);
        final LatLng hopperGymLatLng = new LatLng(41.365530, -93.565462);
        final LatLng cowlesLatLng = new LatLng(41.365907, -93.565964);
        final LatLng mcNeillHallLatLng = new LatLng(41.364399, -93.564544);
        final LatLng hillmanHallLatLng = new LatLng(41.364231, -93.564044);
        // TO DO - (LatLng) Barker, Great/Pfieffer, Kresge, Kent

        final Marker wallaceHall = map.addMarker(new MarkerOptions().position(wallaceHallLatLng)
                .title("Wallace Hall"));
        final Marker maryBerry = map.addMarker(new MarkerOptions().position(maryBerryLatLng)
                .title("Mary Berry"));
        final Marker carverHall = map.addMarker(new MarkerOptions().position(carverHallLatLng)
                .title("Carver Hall"));
        final Marker collegeHall = map.addMarker(new MarkerOptions().position(collegeHallLatLng)
                .title("College Hall"));
        final Marker amyRobinson = map.addMarker(new MarkerOptions().position(amyRobinsonLatLng)
                .title("Amy Robinson Music Center"));
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
        // TO DO - (Marker) Barker, Great/Pfieffer, Kresge, Kent

        wallaceHall.setTag(wallaceHallLatLng);
        maryBerry.setTag(maryBerryLatLng);
        carverHall.setTag(carverHallLatLng);
        collegeHall.setTag(collegeHallLatLng);
        amyRobinson.setTag(amyRobinsonLatLng);
        smithChapel.setTag(smithChapelLatLng);
        hopperGym.setTag(hopperGymLatLng);
        cowlesFieldhouse.setTag(cowlesLatLng);
        mcNeillHall.setTag(mcNeillHallLatLng);
        hillmanHall.setTag(hillmanHallLatLng);
        // TO DO - (setTag) Barker, Great/Pfieffer, Kresge, Kent


        // Wallace Marker clicker
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

        // Mary Berry Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == maryBerryLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Carver hall Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == carverHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // College Hall Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == collegeHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Smith Chapel CLicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == smithChapelLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Hopper Gym Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == hopperGymLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Cowles Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == cowlesLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // McNeill Hall Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == mcNeillHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Hillman Hall Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == hillmanHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // BPAC Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == bpacLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Kent Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == kentLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Lekburg Hall Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == lekburgHallLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Great Hall/ Pfieffer Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == greatPfiefferLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Buxton Stadium Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == buxtonStadiumLatLng)
                {
                    // change to wallacehistory
                    Intent intent = new Intent(MapActivity.this, MapPopActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        // Dunn Library Clicker
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == dunnLibraryLatLng)
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
        //final LatLng latLng = new LatLng(41.365475, -93.564849);
        if(mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
            mCurrLocationMarker = null;
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        // probably need to make star bigger
        final Drawable starDrawable = getResources().getDrawable(R.drawable.ic_star_transparent_24dp);
        final BitmapDescriptor icon = getMarkerIconFromDrawable(starDrawable);
        mCurrLocationMarker = map.addMarker(new MarkerOptions().position(latLng)
                .title("Current Location").icon(icon));
        mCurrLocationMarker.setTag("Current Location");

    }

    public void click_Home(View view) {
        setContentView(R.layout.activity_main_home);

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


    public void click_Home(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}



