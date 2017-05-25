<%-- 
    Document   : bookList
    Created on : May 15, 2017, 5:59:47 PM
    Author     : Son Vu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order list</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="<c:url value='/resources/js/frontendController.js'/>"></script>
    </head>
    <body>
        <h1>ORDERS</h1>
	<table>
        <tr>
            <td><b>Customer</b></td>
            <td><b>Order Date</b></td>
            <td><b>Money</b></td>
            <td><b>Detail</b></td>
        </tr>
            
	<c:forEach var="p" items="${orders}">
	<tr>
		<td>${p.customer.email}</td>
		<td>${p.orderDate}</td>
		<td>${p.totalAmount}</td>
                <td>
                    <table>
                    <c:forEach var="l" items="${p.orderlines}">
                        <tr>
                            <td>${l.quantity}</td>
                            <td>${l.productName}</td>
                            <td> ${l.subTotal}</td>
                        </tr>
                    </c:forEach>    
                    </table>
                </td>
	</tr>
	</c:forEach>
	</table>
        <a href="/secure"> Home</a>
    </body>
</html>
