/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.coffee.config.CommonConstant;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Son Vu
 */
@Controller
public class OrderController {
    @RequestMapping(RestURIConstant.ORDER_FLOW_INIT)
    public String initOrder(Model model){
//        if(model.containsAttribute("order")){
//            System.out.println("======>CONTAIN NEW ORDER");
//            
//        }
        return "createOrder";
    }
    
    @PostMapping(RestURIConstant.ORDER_FLOW_PLACE_ORDER)
    public String placeOrder(@RequestParam("customerId") int customerId, HttpEntity<String> requestEntity,Model model){
        RestTemplate restTemplate = new RestTemplate();
        int orderId = restTemplate.postForObject(CommonConstant.WEB_SERVICE_URL+RestURIConstant.ORDER_CREATE,requestEntity, Integer.class);
//        model.addAttribute("orderId", orderId);
        return "redirect:/orderflow/getNewOrder/"+orderId;
    }
    
    @RequestMapping("/orderflow/getNewOrder/{id}")
    public String getNewOrder(@PathVariable String id,Model model) throws IOException
    {
        String orderId = id;//model.asMap().get("orderId").toString();
//        System.out.println("GET NEW ORDER = "+orderId);
        RestTemplate restTemplate = new RestTemplate();
        OrderSummary order = restTemplate.getForObject(CommonConstant.WEB_SERVICE_URL+"/order/public/"+orderId, OrderSummary.class);
//        ObjectMapper mapper = new ObjectMapper();
//        OrderSummary order = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, OrderSummary.class));
//        System.out.println(order);
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
