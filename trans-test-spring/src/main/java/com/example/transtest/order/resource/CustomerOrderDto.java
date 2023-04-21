package com.example.transtest.order.resource;

import com.example.transtest.order.entity.OrderItem;
import com.example.transtest.order.entity.OrderStatus;
import com.example.transtest.order.entity.ShippingDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;

public class CustomerOrderDto {


    private long totalAmount;
    private long customerId;
    private String customerEmail;
    private long orderId;
    private ShippingDetail shippingDetail;
    private List<OrderItemDto> items = Collections.EMPTY_LIST;

    private OrderStatus status;

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
