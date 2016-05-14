package com.challengers.trackmyorder.model;

import io.realm.RealmObject;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class DelBoy extends RealmObject{
    private String id;
    private String name;
    private String currentOrderIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentOrderIds() {
        return currentOrderIds;
    }

    public void setCurrentOrderIds(String currentOrderIds) {
        this.currentOrderIds = currentOrderIds;
    }
}
