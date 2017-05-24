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
        <title>Product list</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="<c:url value='/resources/js/frontendController.js'/>"></script>
    </head>
    <body>
        <h1>Coffee shop people</h1>
        <form id="formRemoveProduct" action="/removeProduct" method="POST">
            <input type="hidden" id="productId" name="id"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
	<table>
	<c:forEach var="p" items="${products}">
	<tr>
		<td>${p.productName}</td>
		<td>${p.description}</td>
		<td>${p.price}</td>
		<td>${p.productType}</td>               
		<td><a href="/detailProduct/${p.id}">Edit</a></td>
                <td><a href="#" onclick="removeProduct(${p.id});">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="/addProduct"> Add a new product</a> <br>
        <a href="/secure"> Home</a>
    </body>
</html>
