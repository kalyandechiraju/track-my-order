package com.challengers.trackmyorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UpdateOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order);
    }//onCreate

    public void GToDeliver(View v){

        // first we get the list of order he has to deliver
        String orders[] = {"Order011","Order052","Order034","Order078","Order94"};

        // open up a order pop up
        UpdateStatusDialog updateStatusDialog = new UpdateStatusDialog();
        updateStatusDialog.setOrderList(orders);
        updateStatusDialog.show(getFragmentManager(),"Going to deliver order list");
    }//GToDeliver

    public void PickedUpOrder(View v){
        // first we get the list of order he has to deliver
        String orders[] = {"Order051","Order062","Order074","Order088","Order14"}; //this is dummy data


        // open up a order pop up
        UpdateStatusDialog updateStatusDialog = new UpdateStatusDialog();
        updateStatusDialog.setOrderList(orders);
        updateStatusDialog.show(getFragmentManager(),"Going to deliver order list");

    }//PickedUpOrder

    public void deliveredOrder(View v){
        // first we get the list of order he has to deliver
        String orders[] = {"Order001","Order092","Order084","Order078","Order64"}; //this is dummy data


        // open up a order pop up
        UpdateStatusDialog updateStatusDialog = new UpdateStatusDialog();
        updateStatusDialog.setOrderList(orders);
        updateStatusDialog.show(getFragmentManager(),"Going to deliver order list");

    }//deliveredOrder

}
