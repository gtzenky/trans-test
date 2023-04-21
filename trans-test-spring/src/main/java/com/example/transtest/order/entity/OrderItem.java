package com.example.transtest.order.entity;

import jakarta.persistence.*;

@Entity
@Table
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name="order_id")
    private CustomerOrder order;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }
}
