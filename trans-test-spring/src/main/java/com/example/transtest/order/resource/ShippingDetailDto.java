package com.example.transtest.order.resource;

import jakarta.persistence.*;

public class ShippingDetailDto {


    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
