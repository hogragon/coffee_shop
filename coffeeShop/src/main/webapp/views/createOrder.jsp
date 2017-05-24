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
	<form id="formPlaceOrder" action="/placeOrder" method="POST">
		<table>
			<tr>
				<td>Date</td>
				<td><form:input type="date" name="orderDate" /></td>
			</tr>
			<tr>
				<td>Customer:</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>Customer</td>
				<td>
                                    <form:select name="productType" path="productType">
                                        <form:option value="NONE" label="Select"/>
                                        <form:options items="${productType}" />
                                     </form:select> 
                                </td>
			</tr>
		</table>
               
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" />

	</form>
        <a href="<c:url value="/allOrder" />"> List Order </a><br>
</body>
</html>
