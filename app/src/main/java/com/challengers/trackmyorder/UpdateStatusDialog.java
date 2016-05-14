package com.challengers.trackmyorder;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

/**
 * Created by rajesh on 5/14/2016.
 */
public class UpdateStatusDialog extends DialogFragment {
String[] orderList;
    ArrayList<String> checkedItems ;

  public void setOrderList(String[] orderList){
      this.orderList = orderList;
  }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        new ArrayList<String>();
        AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());

        builder.setTitle("Order List").setMultiChoiceItems(orderList, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if(isChecked){
                    // If the user checked the item, add it to the selected items
                    checkedItems.add(orderList[which]);
                } else if(checkedItems.contains(which)){

                    checkedItems.remove(which);
                }




            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK, so save the mSelectedItems results somewhere
                // or return them to the component that opened the dialog
                // here we call do updation of data in database

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //user cancell the selection

            }
        });

        return builder.create();
    }
}//UpdateDtatusDialog
