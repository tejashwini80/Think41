package com.example.Think41.service;

import com.example.Think41.model.Order;
import com.example.Think41.model.User;
import com.example.Think41.repository.OrderRepository;
import com.example.Think41.repository.OrderRepository;
import com.example.Think41.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private final UserRepository userRepo;
    private final OrderRepository orderRepo;

    public CustomerService(UserRepository userRepo, OrderRepository orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    public List<User> getAllCustomers() {
        return userRepo.findAll();
    }

    public Map<String, Object> getCustomerDetails(Integer id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) return null;

        int orderCount = orderRepo.findByUserId(id).size();

        Map<String, Object> response = new HashMap<>();
        response.put("customer", user);
        response.put("orderCount", orderCount);
        return response;
    }
}
