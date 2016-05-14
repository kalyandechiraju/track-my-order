package com.challengers.trackmyorder;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by rajesh on 5/14/2016.
 */
public class PickOrderDialog extends DialogFragment{

    String orders[] = {"Order1001", "Order1002", "Order1003", "Order1004"};
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please select your order")
                .setItems(orders, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }//onCtreate
}//PickOrderDialog
