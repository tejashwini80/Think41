package com.example.Think41.controller;


import com.example.Think41.model.User;
import com.example.Think41.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // ✅ List all customers
    @GetMapping
    public ResponseEntity<List<User>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    // ✅ Get specific customer details with order count
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
        Map<String, Object> customerDetails = service.getCustomerDetails(id);
        if (customerDetails == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Customer not found"));
        }
        return ResponseEntity.ok(customerDetails);
    }
}