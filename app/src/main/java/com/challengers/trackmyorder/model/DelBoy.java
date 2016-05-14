package com.challengers.trackmyorder.model;

import java.util.List;

import io.realm.RealmObject;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class DelBoy extends RealmObject{
    private String id;
    private String name;
    private List<String> currentOrderIds;

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

    public List<String> getCurrentOrderIds() {
        return currentOrderIds;
    }

    public void setCurrentOrderIds(List<String> currentOrderIds) {
        this.currentOrderIds = currentOrderIds;
    }
}
