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
    public static final String ORDER_CREATE =  "/orderflow/create";
    public static final String ORDER_LIST =  "/order/public/all";
    public static final String ORDER_UPDATE =  "/orderflow/update";
    public static final String ORDER_FLOW_INIT =  "/orderflow/initOrder";
    public static final String ORDER_FLOW_NEXT_ORDERLINE =  "/orderflow/addNextOrderline";
    public static final String ORDER_FLOW_PLACE_ORDER =  "/orderflow/placeOrder";
    public static final String ORDER_FLOW_CANCEL =  "/orderflow/cancel";
    public static final String ORDER_FIND =  "/order/public/{id}";
    public static final String ORDER_DELETE =  "/order/delete";
    public static final String PERSON_CREATE =  "/person/create";
    public static final String PERSON_RIGISTER =  "/person/public/register";
    public static final String PERSON_ALL =  "/person/public/all";
    public static final String PERSON_LIST =  "/person/private/list";
    public static final String PERSON_UPDATE =  "/person/private/update";
    public static final String PERSON_FIND =  "/person/public/{id}";
    public static final String PERSON_FIND_BY_EMAIL =  "/person/public/email";
    public static final String PRODUCT_CREATE =  "/product/private/create";
    public static final String PRODUCT_LIST =  "/product/public/all";
    public static final String PRODUCT_UPDATE =  "/product/private/update";
    public static final String PRODUCT_DELETE =  "/product/private/delete";
    public static final String PRODUCT_FIND =  "/product/public/{id}";
    public static final String PRODUCT_FIND_BY_TYPE =  "/product/public/{type}";
}
