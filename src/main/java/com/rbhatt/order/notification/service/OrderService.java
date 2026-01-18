package com.rbhatt.order.notification.service;

import org.springframework.stereotype.Service;
import com.rbhatt.order.notification.entity.Order;
import com.rbhatt.order.notification.repository.OrderRepository;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
    
}
