package com.example.transtest.order.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ShippingDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
