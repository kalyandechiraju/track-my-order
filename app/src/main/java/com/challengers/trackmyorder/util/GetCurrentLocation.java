package com.challengers.trackmyorder.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
@Deprecated
public class GetCurrentLocation implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private Context context;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private static int LOCATION_REQUEST_CODE = 101;

    public GetCurrentLocation(Context context) {
        this.context = context;
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission_group.LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);
                if (mLastLocation != null) {
                    Toast.makeText(context, ""+mLastLocation.getLatitude() + " " + mLastLocation.getLongitude() + " " + mLastLocation.getAltitude(), Toast.LENGTH_SHORT).show();
                }
            } else {
                //Request for Permission
                if(ActivityCompat.shouldShowRequestPermissionRationale((Activity)context, Manifest.permission_group.LOCATION)) {
                    Toast.makeText(context, "Location Permission is needed to proceed", Toast.LENGTH_SHORT).show();
                }
                ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission_group.LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    private void getLocation() {
        /*mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            Toast.makeText(context, ""+mLastLocation.getLatitude() + " " + mLastLocation.getLongitude() + " " + mLastLocation.getAltitude(), Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
