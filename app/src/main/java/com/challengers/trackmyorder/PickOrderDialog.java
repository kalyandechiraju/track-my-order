package com.challengers.trackmyorder;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by rajesh on 5/14/2016.
 */
public class PickOrderDialog extends DialogFragment{

String[] orders;

    public void setOrders(String[] orders){
        this.orders = orders;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please select your order")
                .setItems(orders, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     //perform action on click of list item
                        Log.e("orderid",""+which);
                    }
                });

        return builder.create();
    }//onCtreate
}//PickOrderDialog
