package com.example.transtest.order.repository;

import com.example.transtest.order.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

    CustomerOrder getByOrderId(long orderId);

}
