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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--<script src="<c:url value='/resources/js/frontendController.js'/>"></script>-->
    <script>
        function cancelOrder(){
            $('#formPlaceOrder').attr('action', '/orderflow/cancel');
            $("#formPlaceOrder").submit();
        }
    </script>
</head>

<body>
        <h1>PLACE YOUR ORDER</h1>
	<form id="formPlaceOrder" action="/orderflow/placeOrder" method="POST">
		<table>
			<tr>
				<td>Date</td>
				<td>
                                    <c:if test="${order!=null}">
                                        <label>${order.orderDate}</label>
                                    </c:if>
                                    <c:if test="${order==null}">
                                        <input type="date" name="orderDate" value="${order!=null?order.orderDate:''}"/>        
                                    </c:if>

                                </td>
			</tr>
			<tr>
				<td>Customer:</td>
				<td>
                                    <label>${customer.email}</label>
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
                <input type="hidden" name="id" value="${order.id}"/>
                <c:if test="${order != null}">
                <h2>DETAIL</h2>
                
                <table>
                    <tr>
                        <td><b>Quantity</b></td>
                        <td><b>Name</b></td>
                        <td><b>Sub Total</b></td>
                    </tr>
                    <c:forEach var="line" items="${order.orderlines}">
                    <tr>
                            <td>${line.quantity}</td>
                            <td>${line.productName}</td>
                            <td>${line.subTotal}</td>
                    </tr>
                    </c:forEach>
                </table>
                <h3>Total: ${order.totalAmount}</h3>
                <a href="#" onClick="cancelOrder();"> Cancel Order </a><br>
                </c:if>
               
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<!--<input type="submit" />-->

	</form>
        
        <a href="<c:url value="/" />"> Check Out </a><br>
        
</body>
</html>
