package com.challengers.trackmyorder.util;

import com.firebase.client.Firebase;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class Constants {
    public static final String FIRST_RUN_KEY = "first_run";
    public static final String CURRENT_DELBOY = "current_delboy";
    public static final String ORDER_ID = "order_id";
    public static final String MAPS_TYPE = "maps_type";
    public static final String CURRENT_USER = "current_user";
    public static final String LOGINTYPE = "login_type";
    public static Firebase rootRef = new Firebase("https://track-my-order.firebaseio.com/");
    public static Firebase delboyRef = rootRef.child("/delboy/");
    public static Firebase orderRef = rootRef.child("/order/");
    public static Firebase userRef = rootRef.child("/user/");
    public static String LOCATION_DELIMITER = ",";
    public static String STATUS_UNKNOWN = "U";
    public static String STATUS_GOING_TO_PICKUP = "G";
    public static String STATUS_PICKEDUP = "P";
    public static String STATUS_DELIVERED = "D";
    public static int LOCATION_UPDATE_INTERVAL = 5000;
    public static int LOCATION_FAST_UPDATE_INTERVAL = 1000;
}
