package com.challengers.trackmyorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

     if(userName.equals("c") && userPass.equals("c")) {

         startActivity(new Intent(LoginDBoy.this,DBoy_main_menu.class));
     } else {

         Toast.makeText(this,"Wrong user name and Password",Toast.LENGTH_SHORT).show();
     }


 }//doLogin



}
