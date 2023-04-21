package com.example.transtest.order.resource;

import com.example.transtest.order.entity.CustomerOrder;
import jakarta.persistence.*;

public class OrderItemDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
