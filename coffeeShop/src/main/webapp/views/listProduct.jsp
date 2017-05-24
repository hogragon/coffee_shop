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
    </head>
    <body>
        <h1>Coffee shop people</h1>
	<table>
	<c:forEach var="p" items="${products}">
	<tr>
		<td>${p.productName}</td>
		<td>${p.description}</td>
		<td>${p.price}</td>
		<td>${p.productType}</td>               
		<td><a href="/detailProduct/${p.id}">Edit</a></td>
                <td><a href="/detailProduct/${p.id}">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="/addProduct"> Add a new product</a> <br>
        <a href="/secure"> Home</a>
    </body>
</html>
