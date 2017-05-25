/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Son Vu
 */
public class OrderSummary {
    
    public class Customer{
        private String email;
        private int id;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        
    }
    private int id;
    private Date orderDate;
    private Customer customer = new Customer();
    private List<OrderLineItem> orderlines = new ArrayList<>();
    private double totalAmount;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderLineItem> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLineItem> orderlines) {
        this.orderlines = orderlines;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}

