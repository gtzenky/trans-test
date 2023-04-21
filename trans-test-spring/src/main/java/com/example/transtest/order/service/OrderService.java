package com.example.transtest.order.service;

import com.example.transtest.order.entity.CustomerOrder;
import com.example.transtest.order.entity.OrderItem;
import com.example.transtest.order.entity.OrderStatus;
import com.example.transtest.order.repository.OrderItemRepository;
import com.example.transtest.order.repository.OrderRepository;
import com.example.transtest.order.resource.CustomerOrderDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private EmailService emailService;

    public CustomerOrder createOrder(CustomerOrderDto customerOrder) throws Exception {
        CustomerOrder checked = getByOrderId(customerOrder.getOrderId());
        if (checked != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order existed");
        }

        CustomerOrder order = new CustomerOrder();
        order.setOrderId(customerOrder.getOrderId());
        order.setCustomerEmail(customerOrder.getCustomerEmail());
        order.setTotalAmount(customerOrder.getTotalAmount());
        order.setShippingDetail(customerOrder.getShippingDetail());

        customerOrder.getItems().forEach(item -> {
            OrderItem oItem = new OrderItem();
            oItem.setName(item.getName());
            oItem.setOrder(order);
            orderItemRepository.save(oItem);
            order.getItems().add(oItem);
        });


        return orderRepository.save(order);
    }

    public CustomerOrder getByOrderId(long orderId) {
        CustomerOrder order = orderRepository.getByOrderId(orderId);
        return order;
    }

    public void updateOrderStatus(long orderId, OrderStatus status) throws Exception {
        CustomerOrder order = getByOrderId(orderId);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found");
        }

        order.setStatus(status);
        orderRepository.save(order);

        String title = "Your Order " + order.getOrderId() + " update";
        String content = "Order " + order.getOrderId() + " status change to " + order.getStatus().name();
        emailService.sendMailNotification(order.getCustomerEmail(), title, content);
    }

}
