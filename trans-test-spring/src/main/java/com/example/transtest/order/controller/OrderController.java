package com.example.transtest.order.controller;

import com.example.transtest.order.entity.CustomerOrder;
import com.example.transtest.order.resource.CustomerOrderDto;
import com.example.transtest.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public CustomerOrder createOrder(@Valid @RequestBody CustomerOrderDto customerOrder) throws Exception {
        CustomerOrder order = orderService.createOrder(customerOrder);
        return order;
    }

    @GetMapping("/orders/{id}")
    public CustomerOrder getById(@PathVariable("id") long orderId) {
        return orderService.getByOrderId(orderId);
    }

    @PutMapping("/orders/{id}/status")
    public void updateOrderStatus(@PathVariable("id") long orderId, @RequestBody CustomerOrder customerOrder) throws Exception {
        orderService.updateOrderStatus(orderId, customerOrder.getStatus());
    }
}
