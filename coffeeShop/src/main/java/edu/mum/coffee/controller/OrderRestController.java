/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;


import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.OrderlineService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Son Vu
 */
@RestController
public class OrderRestController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderlineService orderLineService;
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private ProductService productService;
    
    @PostMapping(RestURIConstant.ORDER_CREATE)
    public int createOrder(
            @RequestParam("orderDate") String orderDate,
            @RequestParam("customerId")long customerId,
            @RequestParam("productId") int productId,
            @RequestParam("quantity") int quantity) 
            throws ParseException
    {
        Person person = personService.findById(customerId);
        
        Order order = new Order();
        order.setOrderDate(java.sql.Date.valueOf(orderDate));
        order.setPerson(person);
            
        Product product = productService.getProduct(productId);
        Orderline line = new Orderline();
        line.setProduct(product);
        line.setQuantity(quantity);
        order.addOrderLine(line);
            
        orderService.save(order);
        
        return order.getId();
    }
    
    @RequestMapping(RestURIConstant.ORDER_FIND)
    public ResponseEntity findOrder(@PathVariable int id){
        Order order = orderService.findById(id);
        
        OrderSummary os = new OrderSummary();
        os.setId(order.getId());
        os.setOrderDate(order.getOrderDate());
        os.getCustomer().setEmail(order.getPerson().getEmail());
        os.getCustomer().setId((int) order.getPerson().getId());
        
        
        for(Orderline l:order.getOrderLines()){
            OrderLineItem line = new OrderLineItem();
            line.setProductName(l.getProduct().getProductName());
            line.setQuantity(l.getQuantity());
            line.setSubTotal(l.getSubtotal());
            os.getOrderlines().add(line);
        }
        
        
        return new ResponseEntity(os,HttpStatus.OK);
    }
    
    
}
