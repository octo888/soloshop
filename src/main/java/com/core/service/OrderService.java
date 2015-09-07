package com.core.service;

import com.core.beans.Cart;
import com.core.entity.Order;
import com.core.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order findOneById(Long id) {
        return orderRepository.findOne(id);
    }
}
