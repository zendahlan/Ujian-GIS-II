package com.example.ujiangis;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Tinggede and move the camera
        LatLng Tinggede = new LatLng(-0.93082, 119.86944);
        LatLng Untad = new LatLng(-0.83643, 119.89369);
        // coustum size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);
        // add marker to map
        mMap.addMarker(new MarkerOptions().position(Tinggede).title("Marker in Tinggede")
        .snippet("Ini adalah Rumah Saya")
        .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(Untad).title("Marker in Untad")
                .snippet("Ini adalah Kampus Kami")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                Tinggede,
                new LatLng(-0.93082, 119.86944),
                new LatLng(-0.92642, 119.86983),
                new LatLng(-0.92585, 119.86970),
                new LatLng(-0.92205, 119.87012),
                new LatLng(-0.91898, 119.87694),
                new LatLng(-0.91908, 119.88491),
                new LatLng(-0.91609, 119.88492),
                new LatLng(-0.91599, 119.88623),
                new LatLng(-0.91327, 119.88616),
                new LatLng(-0.91341, 119.89078),
                new LatLng(-0.89787, 119.88736),
                new LatLng(-0.88817, 119.88542),
                new LatLng(-0.87116, 119.88695),
                new LatLng(-0.83636, 119.88939),
                new LatLng(-0.83558, 119.89320),
                new LatLng(-0.83589, 119.89358),
                new LatLng(-0.83608, 119.89352),
                new LatLng(-0.83644, 119.89369),
                Untad
                ).width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tinggede, 14.5f));

    }
}