package com.challengers.trackmyorder.util;

import com.firebase.client.Firebase;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class Constants {
    public static Firebase rootRef = new Firebase("https://track-my-order.firebaseio.com/");
    public static Firebase delboyRef = rootRef.child("/delboy/");
    public static Firebase orderRef = rootRef.child("/order/");
    public static Firebase userRef = rootRef.child("/user/");
}
