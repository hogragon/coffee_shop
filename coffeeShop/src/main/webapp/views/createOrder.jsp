<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>Place Order</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
<!--<script src="<c:url value='/resources/js/frontendController.js'/>"></script>-->
</head>

<body>
        <h1>PLACE YOUR ORDER</h1>
	<form id="formPlaceOrder" action="/orderflow/placeOrder" method="POST">
		<table>
			<tr>
				<td>Date</td>
				<td><input type="date" name="orderDate"/></td>
			</tr>
			<tr>
				<td>Customer:</td>
				<td>
                                    <input type="text" name="email" value="${customer.email}"/>
                                    <input type="hidden" name="customerId" value="${customer.id}"/>
                                </td>
			</tr>
			<tr>
				<td>Product:</td>
				<td>
                                    <form:select name="productId" path="productList">
                                        <form:option value="NONE" label="Select"/>
                                        <form:options items="${productList}" />
                                    </form:select> 
                                    <input type="text" name="quantity"/>
                                    <input type="submit" value="Add"/>                    
                                </td>
			</tr>
		</table>
                
                <c:if test="${order != null}">
                <h2>DETAIL</h2>
                <input type="hidden" name="id" value="${order.id}"/>
                <table>
                    <c:forEach var="line" items="${order.orderlines}">
                    <tr>
                            <td>${line.productName}</td>
                            <td>${line.quantity}</td>
                            <td>${line.subTotal}</td>
                                           
                            <!--<td><a href="/detailProduct/${p.id}">Edit</a></td>-->
                            <!--<td><a href="#" onclick="removeProduct(${p.id});">Delete</a></td>-->
                    </tr>
                    </c:forEach>
                </table>
                </c:if>
               
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<!--<input type="submit" />-->

	</form>
        <a href="<c:url value="/allOrder" />"> List Order </a><br>
</body>
</html>
