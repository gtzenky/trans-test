package com.example.transtest.order.repository;

import com.example.transtest.order.entity.CustomerOrder;
import com.example.transtest.order.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
