/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Son Vu
 */
@RestController
public class ProductRestController {
    @Autowired
    private ProductService productServices;
    
    @GetMapping(RestURIConstant.PRODUCT_LIST)
    public ResponseEntity getProductAll(){
        return new ResponseEntity(productServices.getAllProduct(),HttpStatus.OK);
    }
    
    @PostMapping(RestURIConstant.PRODUCT_CREATE)
    public ResponseEntity createProduct(@ModelAttribute Product p){
        productServices.save(p);
        return new ResponseEntity(p,HttpStatus.OK);
    }
    
    @PostMapping(RestURIConstant.PRODUCT_UPDATE)
    public ResponseEntity updateProduct(@RequestParam("id") int id,@ModelAttribute Product p){
        
        Product updated  = productServices.getProduct(id);
        updated.setDescription(p.getDescription());
        updated.setPrice(p.getPrice());
        updated.setProductName(p.getProductName());
        updated.setProductType(p.getProductType());
        
        productServices.save(updated);
        
        return new ResponseEntity(p,HttpStatus.OK);
    }
    
    @GetMapping(RestURIConstant.PRODUCT_DELETE)
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        Product deleted  = productServices.getProduct(id);
        productServices.delete(deleted);
        return new ResponseEntity(deleted,HttpStatus.OK);
    }
    
//    @GetMapping(RestURIConstant.PRODUCT_FIND_BY_TYPE)
//    public ResponseEntity findProductByType(@PathVariable int type){
//        ProductType t = ProductType.values()[type];
//        return new ResponseEntity(productServices.findByProductType(t),HttpStatus.OK);
//    }
    
    @GetMapping(RestURIConstant.PRODUCT_FIND)
    public ResponseEntity findProduct(@PathVariable int id){
        return new ResponseEntity(productServices.getProduct(id),HttpStatus.OK);
    }
}
