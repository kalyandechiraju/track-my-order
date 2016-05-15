package com.challengers.trackmyorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.challengers.trackmyorder.util.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String userId, delBoyId, mapType;
    private String userLocation, delBoyLocation;
    private Marker lastMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if(getIntent().hasExtra(Constants.MAPS_TYPE)) {
            mapType = getIntent().getStringExtra(Constants.MAPS_TYPE);
            userId = getIntent().getStringExtra(Constants.CURRENT_USER);
            delBoyId = getIntent().getStringExtra(Constants.CURRENT_DELBOY);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(delBoyId != null) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.maps_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.show_directions_menu:
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + userLocation);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        if (mapType != null && mapType.equals("D")) {
            if (delBoyId != null && userId != null) {
                Firebase currentUserRef = Constants.userRef.child("/" + userId);
                currentUserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (lastMarker != null) {
                            lastMarker.remove();
                        }
                        String latLang = (String) dataSnapshot.child("currentLocation").getValue();
                        userLocation = latLang;
                        LatLng location = new LatLng(Double.parseDouble(latLang.split(Constants.LOCATION_DELIMITER)[0]), Double.parseDouble(latLang.split(Constants.LOCATION_DELIMITER)[1]));
                        lastMarker = mMap.addMarker(new MarkerOptions().position(location).title("User is here"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
                        // Zoom out to zoom level 10, animating with a duration of 1 second.
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 1000, null);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Toast.makeText(MapsActivity.this, "Check your network connection", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Log.e("Maps Activity", "One of users is null");
            }
        } else if (mapType != null && mapType.equals("U")) {
            if (delBoyId != null && userId != null) {
                Firebase currentDelBoyRef = Constants.delboyRef.child("/" + delBoyId);
                currentDelBoyRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (lastMarker != null) {
                            lastMarker.remove();
                        }
                        String latLang = (String) dataSnapshot.child("currentLocation").getValue();
                        delBoyLocation = latLang;
                        LatLng location = new LatLng(Double.parseDouble(latLang.split(Constants.LOCATION_DELIMITER)[0]), Double.parseDouble(latLang.split(Constants.LOCATION_DELIMITER)[1]));
                        lastMarker = mMap.addMarker(new MarkerOptions().position(location).title("Your Order is here"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
                        // Zoom out to zoom level 10, animating with a duration of 1 second.
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 1000, null);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Toast.makeText(MapsActivity.this, "Check your network connection", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Log.e("Maps Activity", "One of users is null");
            }
        }
    }
}
