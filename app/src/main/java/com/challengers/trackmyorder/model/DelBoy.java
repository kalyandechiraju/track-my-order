package com.challengers.trackmyorder.model;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class DelBoy {
    private String id;
    private String name;
    private String currentLocation;
    private Order[] currentOrders;

    public DelBoy(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Order[] getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(Order[] currentOrders) {
        this.currentOrders = currentOrders;
    }
}
