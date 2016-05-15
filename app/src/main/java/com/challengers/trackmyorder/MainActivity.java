package com.challengers.trackmyorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.challengers.trackmyorder.util.Constants;

public class MainActivity extends AppCompatActivity {

    Button userButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userButton = (Button) findViewById(R.id.user_login_button);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra(Constants.LOGINTYPE, "U");
                startActivity(intent);
            }
        });
    }

    public void deliveryBoy(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra(Constants.LOGINTYPE, "D");
        startActivity(intent);
    }
}
