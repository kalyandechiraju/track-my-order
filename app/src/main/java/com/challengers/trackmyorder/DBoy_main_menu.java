package com.challengers.trackmyorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class DBoy_main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dboy_main_menu);
    }

  private void orderListPopUpMenu(View v){

      PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);
      int group_id=1;
      String orders[] = {"A1","A2","A3","A4","A5","A6","A7","A8","A9"};

      for(int i=0;i<10;i++) {
          popupMenu.getMenu().add(group_id, i, i,orders[i] );

      }//for
     popupMenu.show();


  }//orderListPopUpMenu



}
