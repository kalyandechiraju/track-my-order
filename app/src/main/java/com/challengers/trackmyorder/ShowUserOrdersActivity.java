package com.challengers.trackmyorder;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowUserOrdersActivity extends Activity {

    String orders[] = {"Order001","Order002","Order003","Order004","Order005","Order006","Order007"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_orders);
        setTitle("My Orders");

       l = (ListView) findViewById(R.id.listView);
        CustomUserOrderArrayAdapter customUserOrderArrayAdapter = new CustomUserOrderArrayAdapter(this,orders);
        l.setAdapter(customUserOrderArrayAdapter);

    }//oncretae


}//ShowUserOrdersActivity


class CustomUserOrderArrayAdapter extends  ArrayAdapter<String> {

    Context ctx;
    String orders[];
 public CustomUserOrderArrayAdapter(Context ctx,String[] ordersList) {

     super(ctx,R.layout.single_row_to_show_user_order,R.id.text1,ordersList);
     this.ctx = ctx;
     this.orders = ordersList;
    }//CustomUserOrderArrayAdapter

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if(row == null) {

            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.single_row_to_show_user_order, parent, false);
        }
        TextView textView = (TextView) row.findViewById(R.id.text1);
        textView.setText(orders[position]);
        return row;
    }
}//CustomUserOrderArrayAdapter