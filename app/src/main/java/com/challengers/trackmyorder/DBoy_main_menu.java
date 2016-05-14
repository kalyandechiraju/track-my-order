package com.challengers.trackmyorder;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.Button;

public class DBoy_main_menu extends AppCompatActivity {

    String orders[] = {"Order1001", "Order1002", "Order1003", "Order1004"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboy_main_menu);
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
