<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Person</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value='/resources/js/frontendController.js'/>"></script>
</head>

<body>
	<form id="formAddPerson" onSubmit="addPerson();" method="POST">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city" /></td>
			</tr>
                        <tr>
				<td>State:</td>
				<td><input type="text" name="address.state" /></td>
			</tr>
                        <tr>
				<td>Country:</td>
				<td><input type="text" name="address.country" /></td>
			</tr>
                        <tr>
				<td>Zipcode:</td>
				<td><input type="text" name="address.zipcode" /></td>
			</tr>
                        <tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" /></td>
			</tr>
		</table>
                <input type="hidden" name="enable" value="true"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" />

	</form>
</body>
</html>
