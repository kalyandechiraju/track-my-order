package com.challengers.trackmyorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.challengers.trackmyorder.model.Order;
import com.challengers.trackmyorder.model.User;
import com.challengers.trackmyorder.util.Constants;

import io.realm.Realm;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        if(getIntent().hasExtra(Constants.ORDER_ID)) {
            String orderId = getIntent().getStringExtra(Constants.ORDER_ID);
            if(orderId != null) {
                Realm realm = Realm.getDefaultInstance();
                Order order = realm.where(Order.class).equalTo("orderId", orderId).findFirst();
                User user = realm.where(User.class).equalTo("currentOrderId", orderId).findFirst();
            }
        } else {
            Toast.makeText(this, "Invalid Order", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
