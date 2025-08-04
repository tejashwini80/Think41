package com.example.Think41.model;


import jakarta.persistence.*;


import java.time.OffsetDateTime;

    @Entity
    @Table(name = "orders")
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer orderId;

        private Integer userId;
        private String status;
        private String gender;

        @Column(name = "created_at")
        private OffsetDateTime createdAt;

        private Integer numOfItem;

        // getters & setters

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public OffsetDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getNumOfItem() {
            return numOfItem;
        }

        public void setNumOfItem(Integer numOfItem) {
            this.numOfItem = numOfItem;
        }
    }



