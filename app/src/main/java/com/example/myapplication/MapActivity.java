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
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Zoom in vicinity of Simpson Campus
        final LatLng simpson = new LatLng(41.365475, -93.564849);
        final CameraUpdate newLoc = CameraUpdateFactory.newLatLngZoom(simpson, 17);
        map.animateCamera(newLoc);

        // Initialize Building LatLng and Markers
        final LatLng WallaceHallLatLng = new LatLng(41.365112, -93.562948);
        final Marker WallaceHall = map.addMarker(new MarkerOptions().position(WallaceHallLatLng)
                .title("Wallace Hall"));
        WallaceHall.setTag(WallaceHallLatLng);

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTag() == WallaceHallLatLng)
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
}



