package com.challengers.trackmyorder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.challengers.trackmyorder.service.LocationUpdateService;
import com.challengers.trackmyorder.util.Constants;
import com.challengers.trackmyorder.util.Prefs;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class DboyActivity extends AppCompatActivity {

    private String[] orders;
    private String orderList;
    private Button myOrdersButton;
    private static int LOCATION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboy_main_menu);

        if(getIntent().hasExtra(Constants.CURRENT_DELBOY)) {
            String username = getIntent().getStringExtra(Constants.CURRENT_DELBOY);
            Prefs.putString(Constants.CURRENT_DELBOY, username);

            //Get the data from the local DB
            //Realm realm = Realm.getDefaultInstance();

            myOrdersButton = (Button) findViewById(R.id.dboy_my_order);

            Firebase currentDelBoyRef = Constants.delboyRef.child("/" + username);
            currentDelBoyRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    orderList = (String) dataSnapshot.child("currentOrders").getValue();
                    orders = orderList.split(Constants.LOCATION_DELIMITER);

                    if(myOrdersButton != null) {
                        myOrdersButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                PickOrderDialog pickOrderDialog = new PickOrderDialog();
                                pickOrderDialog.setOrders(orders);
                                pickOrderDialog.show(getFragmentManager(),"Pick Order Dialog");
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(DboyActivity.this, "Check network connection", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
            finish();
        }

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    /*|| ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {*/
                //Request for Permission
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    Toast.makeText(this, "Location Permission is needed to proceed", Toast.LENGTH_SHORT).show();
                }
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        } else {
            Intent intent = new Intent(this, LocationUpdateService.class);
            startService(intent);
        }

    }

    public void launchUpdateOrderStatusActivity(View v){
        startActivity(new Intent(DboyActivity.this,UpdateOrderActivity.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_REQUEST_CODE) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(this, LocationUpdateService.class);
                startService(intent);
            } else {
                Toast.makeText(DboyActivity.this, "Need Location permission to show in map", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
