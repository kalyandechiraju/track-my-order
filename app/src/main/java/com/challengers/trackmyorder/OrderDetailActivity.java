package com.challengers.trackmyorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.challengers.trackmyorder.model.Order;
import com.challengers.trackmyorder.model.User;
import com.challengers.trackmyorder.util.Constants;
import com.challengers.trackmyorder.util.Prefs;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class OrderDetailActivity extends AppCompatActivity {

    TextView orderIdText;
    TextView itemInOrderText;
    TextView statusText;
    ImageView staticUserLocationImage;
    String orderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        if(getIntent().hasExtra(Constants.ORDER_ID)) {
            orderId = getIntent().getStringExtra(Constants.ORDER_ID);
            if(orderId != null) {
                Realm realm = Realm.getDefaultInstance();
                Order order = realm.where(Order.class).equalTo("orderId", orderId).findFirst();
                User user = realm.where(User.class).equalTo("currentOrderId", orderId).findFirst();

                orderIdText = (TextView) findViewById(R.id.order_detail_id);
                itemInOrderText = (TextView) findViewById(R.id.order_detail_item);
                statusText = (TextView) findViewById(R.id.order_detail_status);
                staticUserLocationImage = (ImageView) findViewById(R.id.user_location_static_map);

                orderIdText.setText(order.getOrderId());
                itemInOrderText.setText(order.getItem());
                if(order.getStatus().equals(Constants.STATUS_GOING_TO_PICKUP)) {
                    statusText.setText("Going to pickup");
                } else if (order.getStatus().equals(Constants.STATUS_PICKEDUP)) {
                    statusText.setText("Item picked up");
                } else if(order.getStatus().equals(Constants.STATUS_DELIVERED)) {
                    statusText.setText("Item Delivered");
                }


                Firebase currentUserRef = Constants.userRef.child("/" + user.getUserId());
                currentUserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String latLan = (String) dataSnapshot.child("currentLocation").getValue();
                        String placeUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + latLan + "&zoom=17&size=1200x250&maptype=roadmap&markers=color:red%7C" + latLan + "&key=AIzaSyBP_hEMi4Pu0VGFRRzeFH4Podfkf2qGEks";
                        Picasso.with(OrderDetailActivity.this).load(placeUrl).resize(staticUserLocationImage.getWidth(), 300).centerCrop().into(staticUserLocationImage);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

                staticUserLocationImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Go to Map Activity
                    }
                });
            }
        } else {
            Toast.makeText(this, "Invalid Order", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, DBoy_main_menu.class);
        intent.putExtra(Constants.CURRENT_DELBOY, Prefs.getString(Constants.CURRENT_DELBOY, null));
        startActivity(intent);
    }
}
