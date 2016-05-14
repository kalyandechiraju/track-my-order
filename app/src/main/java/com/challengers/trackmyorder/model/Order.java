package com.challengers.trackmyorder.model;

/**
 * Copyright (c) 2016 Kalyan Dechiraju
 * Created by kalyandechiraju on 14/05/16.
 */
public class Order {
    private String orderid;
    private String item;
    private String status;

    public Order(String orderid, String item) {
        this.orderid = orderid;
        this.item = item;
    }

    public String getOrderid() {
        return orderid;
    }

    public String getItem() {
        return item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
