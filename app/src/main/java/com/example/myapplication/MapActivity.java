package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

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

    public void click_Wallace(View view)
    {

    }

    public void click_Main(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}



