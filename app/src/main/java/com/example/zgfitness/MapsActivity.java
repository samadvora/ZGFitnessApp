package com.example.zgfitness;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.zgfitness.databinding.ActivityMapsBinding;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng location;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        location = new LatLng(43.45, -80.55);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("ZG Fitness - 235 William Street, Kitchener")
                .position(new LatLng(43.45,-80.55))
                .snippet("Open 24 Hours."));

        markerOptions.add(new MarkerOptions().title("ZG Fitness - 181 Westvale Drive, Hamilton")
                .position(new LatLng(43.25,-79.81))
                .snippet("Open 24 Hours."));

        markerOptions.add(new MarkerOptions().title("ZG Fitness - 81 Brooke Street, Missisauga")
                .position(new LatLng(43.61,-79.75))
                .snippet("Open 24 Hours."));

        markerOptions.add(new MarkerOptions().title("ZG Fitness - 11 Laurentian Hills Plaza, Richmond")
                .position(new LatLng(49.15,-123.12))
                .snippet("Open 24 Hours."));

        markerOptions.add(new MarkerOptions().title("ZG Fitness - 21 Town Road, Calgary")
                .position(new LatLng(50.99,-114.05))
                .snippet("Open 24 Hours."));
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

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        for (MarkerOptions mark: markerOptions) {
            mMap.addMarker(mark);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,8));
    }
}