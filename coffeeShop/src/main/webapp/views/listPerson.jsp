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
        <title>Book shop</title>
    </head>
    <body>
        <h1>Coffee shop people</h1>
	<table>
	<c:forEach var="p" items="${people}">
	<tr>
		<td>${p.firstName}</td>
		<td>${p.lastName}</td>
		<td>${p.email}</td>
		<td>${p.phone}</td>
                <td>${p.address.city},${p.address.state},${p.address.country},${p.address.zipcode}</td>
		<td><a href="/detailPerson/${p.id}">Edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="/createPerson"> Add a new person</a>
    </body>
</html>
