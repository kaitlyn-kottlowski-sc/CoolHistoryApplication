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
        map.clear();

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
        final Marker marryBerry = map.addMarker(new MarkerOptions().position(maryBerryLatLng)
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
        marryBerry.setTag(maryBerryLatLng);
        carverHall.setTag(carverHallLatLng);
        collegeHall.setTag(collegeHallLatLng);
        amyRobinson.setTag(amyRobinsonLatLng);
        smithChapel.setTag(smithChapelLatLng);
        hopperGym.setTag(hopperGymLatLng);
        cowlesFieldhouse.setTag(cowlesLatLng);
        mcNeillHall.setTag(mcNeillHallLatLng);
        hillmanHall.setTag(hillmanHallLatLng);
        // TO DO - (setTag) Barker, Great/Pfieffer, Kresge, Kent


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
}



