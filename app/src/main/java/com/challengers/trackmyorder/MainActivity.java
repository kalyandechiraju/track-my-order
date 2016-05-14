package com.challengers.trackmyorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//oncreate

    public void deliveryBoy(View v) {

    startActivity(new Intent(MainActivity.this,LoginDBoy.class));
    }//deliveyBoy


}
