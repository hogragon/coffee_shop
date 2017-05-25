/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.coffee.config.CommonConstant;

import edu.mum.coffee.domain.Product;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Son Vu
 */
@Controller
public class OrderController {
    @RequestMapping(RestURIConstant.ORDER_FLOW_INIT)
    public String initOrder(Model model){
        return "createOrder";
    }
    
    @PostMapping(RestURIConstant.ORDER_FLOW_PLACE_ORDER)
    public String placeOrder(@RequestParam("id") String tempOrderId, HttpEntity<String> requestEntity,Model model){
        
        RestTemplate restTemplate = new RestTemplate();
        int orderId;
        if(tempOrderId.equals(""))
        {
            orderId = restTemplate.postForObject(CommonConstant.WEB_SERVICE_URL+RestURIConstant.ORDER_CREATE,requestEntity, Integer.class);            
        }
        else
        {
            orderId = restTemplate.postForObject(CommonConstant.WEB_SERVICE_URL+RestURIConstant.ORDER_UPDATE,requestEntity, Integer.class);            
        }
        
        return "redirect:/orderflow/getNewOrder/"+orderId;
    }
    
    @PostMapping(RestURIConstant.ORDER_FLOW_CANCEL)
    public String cancelOrder(@RequestParam("id") String id, HttpEntity<String> requestEntity,Model model){
        System.out.println("deleted___ORDER="+id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(CommonConstant.WEB_SERVICE_URL+RestURIConstant.ORDER_DELETE,requestEntity, Integer.class);
        
        return "redirect:/home";
    }
    
    @RequestMapping("/orderflow/getNewOrder/{id}")
    public String getNewOrder(@PathVariable String id,Model model) throws IOException
    {
        String orderId = id;
        RestTemplate restTemplate = new RestTemplate();
        OrderSummary order = restTemplate.getForObject(CommonConstant.WEB_SERVICE_URL+"/order/public/"+orderId, OrderSummary.class);
        model.addAttribute("order", order);
        model.addAttribute("customer",order.getCustomer());
        
        return "createOrder";
    }
    
    @ModelAttribute("productList")
    public Map<Integer,String> productList() throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(CommonConstant.WEB_SERVICE_URL+RestURIConstant.PRODUCT_LIST, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));

        Map<Integer,String> mapType = new HashMap<>();

        products.forEach((Product t) -> {
            mapType.put(t.getId(), t.getProductName());
        });            
        return mapType;
    }
}
