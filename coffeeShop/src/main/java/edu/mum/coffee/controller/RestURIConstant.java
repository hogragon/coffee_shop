/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

/**
 *
 * @author Son Vu
 */
public class RestURIConstant {
    public static final String ORDER_CREATE =  "/order/create";
    public static final String ORDER_LIST =  "/order/all";
    public static final String PERSON_CREATE =  "/person/create";
    public static final String PERSON_ALL =  "/person/public/all";
    public static final String PERSON_LIST =  "/person/private/list";
    public static final String PERSON_UPDATE =  "/person/private/update";
    public static final String PERSON_FIND =  "/person/public/{id}";
    public static final String PRODUCT_CREATE =  "/product/create";
    public static final String PRODUCT_LIST =  "/product/all";
    public static final String PRODUCT_UPDATE =  "/product/update/{id}";
    public static final String PRODUCT_DELETE =  "/product/delete/{id}";
}
