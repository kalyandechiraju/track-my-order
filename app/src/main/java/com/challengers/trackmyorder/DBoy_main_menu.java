package com.challengers.trackmyorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.challengers.trackmyorder.model.DelBoy;
import com.challengers.trackmyorder.service.LocationUpdateService;
import com.challengers.trackmyorder.util.Constants;
import com.challengers.trackmyorder.util.Prefs;

import java.util.List;

import io.realm.Realm;

public class DBoy_main_menu extends AppCompatActivity {

    private String[] orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboy_main_menu);

        if(getIntent().hasExtra(Constants.CURRENT_DELBOY)) {
            String username = getIntent().getStringExtra(Constants.CURRENT_DELBOY);
            Prefs.putString(Constants.CURRENT_DELBOY, username);
            Intent intent = new Intent(this, LocationUpdateService.class);
            startService(intent);

            //Get the data from the local DB
            Realm realm = Realm.getDefaultInstance();
            List<String> orderIdList = realm.where(DelBoy.class).equalTo("id", username).findFirst().getCurrentOrderIds();

            //Convert into an array of order ids to pass into dialog
            orders = new String[orderIdList.size()];
            for (int i = 0; i < orderIdList.size(); i++) {
                orders[i] = orderIdList.get(i);
            }
        } else {
            finish();
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
        }
        Button myOrdersButton = (Button) findViewById(R.id.dboy_my_order);
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










}
