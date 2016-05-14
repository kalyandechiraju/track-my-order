package com.challengers.trackmyorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.challengers.trackmyorder.util.Constants;

public class LoginDBoy extends AppCompatActivity {
    EditText userIdEditText,userPassEditText;
    String userName,userPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dboy);
        setTitle("Login");
        userIdEditText = (EditText) findViewById(R.id.userName);
        userPassEditText = (EditText) findViewById(R.id.userPass);
    }

    public void doLogin(View v){
        userName = userIdEditText.getText().toString();
        userPass = userPassEditText.getText().toString();
        String usernameString = "delboy1";
        if(userName.equals(usernameString) && userPass.equals("d")) {
            Intent intent = new Intent(this, DBoy_main_menu.class);
            intent.putExtra(Constants.CURRENT_DELBOY, usernameString);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Wrong Username or Password",Toast.LENGTH_SHORT).show();
        }
    }
}
