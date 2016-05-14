package com.challengers.trackmyorder;

import android.app.Application;

import com.challengers.trackmyorder.model.DelBoy;
import com.challengers.trackmyorder.model.Order;
import com.challengers.trackmyorder.model.User;
import com.challengers.trackmyorder.util.Constants;
import com.challengers.trackmyorder.util.Prefs;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class AppClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("trackmyorder.realm")
                .build();
        Realm.setDefaultConfiguration(config);
        populateDummyData();

        if(Prefs.contains(Constants.FIRST_RUN_KEY)) {
            if(Prefs.getBoolean(Constants.FIRST_RUN_KEY, true)) {
                populateDummyData();
            }
        } else {
            populateDummyData();
        }
    }

    private void populateDummyData() {
        Realm realm = Realm.getDefaultInstance();

        DelBoy delBoy = new DelBoy();
        delBoy.setId("delboy1");
        delBoy.setName("Kalyan");

        Order order = new Order();
        order.setOrderId("order1001");
        order.setItem("Groceries");
        order.setStatus(Constants.STATUS_UNKNOWN);

        Order order1 = new Order();
        order1.setOrderId("order1002");
        order1.setItem("Food");
        order1.setStatus(Constants.STATUS_UNKNOWN);

        Order order2 = new Order();
        order2.setOrderId("order1003");
        order2.setItem("Food");
        order2.setStatus(Constants.STATUS_UNKNOWN);

        Order order3 = new Order();
        order3.setOrderId("order1004");
        order3.setItem("Pharma");
        order3.setStatus(Constants.STATUS_UNKNOWN);

        List<Order> orderList = new ArrayList<>(4);
        orderList.add(order);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        List<String> orderIdList = new ArrayList<>(orderList.size());
        for (Order orders : orderList) {
            orderIdList.add(orders.getOrderId());
        }
        delBoy.setCurrentOrderIds(orderIdList);

        User user = new User();
        user.setUserId("user101");
        user.setUsername("Kalyan");
        user.setCurrentOrderId(order1.getOrderId());

        User user1 = new User();
        user1.setUserId("user102");
        user1.setUsername("Chandan");
        user1.setCurrentOrderId(order.getOrderId());

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(delBoy);
        realm.copyToRealmOrUpdate(orderList);
        realm.copyToRealmOrUpdate(user);
        realm.copyToRealmOrUpdate(user1);
        realm.commitTransaction();

        Prefs.putBoolean(Constants.FIRST_RUN_KEY, false);
    }
}
