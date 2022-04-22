package com.example.togara_rudo_s1906627;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Activity extends FragmentActivity implements OnMapReadyCallback {
    Button openMap;

    GoogleMap map;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        viewFlipper = findViewById(R.id.viewFlipper);

       SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        LatLng England = new LatLng(52.16440759171102, -1.9593319416276886);
        map.addMarker(new MarkerOptions().position(England).title("England"));
        map.moveCamera(CameraUpdateFactory.newLatLng(England));
    }

    public void showMap(View view) {
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.mapId)));
    }
}
