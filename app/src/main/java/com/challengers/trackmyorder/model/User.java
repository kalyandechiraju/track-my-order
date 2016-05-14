package com.challengers.trackmyorder.model;

import io.realm.RealmObject;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class User extends RealmObject{
    private String userId;
    private String username;
    private String currentOrderId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(String currentOrderId) {
        this.currentOrderId = currentOrderId;
    }
}
