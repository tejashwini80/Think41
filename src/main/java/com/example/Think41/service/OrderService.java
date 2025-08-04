package com.example.Think41.service;

import com.example.Think41.model.Order;
import com.example.Think41.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    // ✅ Get all orders for a specific customer
    public Map<String, Object> getOrdersByCustomer(Integer userId) {
        Map<String, Object> response = new HashMap<>();
        List<Order> orders = orderRepo.findByUserId(userId);

        if (orders.isEmpty()) {
            response.put("status", "error");
            response.put("message", "No orders found for customer ID " + userId);
        } else {
            response.put("status", "success");
            response.put("orders", orders);
        }
        return response;
    }

    // ✅ Get specific order details
    public Map<String, Object> getOrderById(Integer orderId) {
        Map<String, Object> response = new HashMap<>();
        Optional<Order> order = orderRepo.findById(orderId);

        if (order.isPresent()) {
            response.put("status", "success");
            response.put("order", order.get());
        } else {
            response.put("status", "error");
            response.put("message", "Order ID " + orderId + " not found");
        }
        return response;
    }
}