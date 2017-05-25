<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	You can choose any presentation framework that could be integrated with
	Spring
	<p>
	<p>
		The only user is "<b>super</b>" and the password is "<b>pw</b>"
	<p>
		<a href="<c:url value="/secure" />"> Login Here </a><br>
                <a href="<c:url value="/registerUser" />"> New Customer? Register Here </a>
        <h3>MENU TODAY</h3>
        <table>
        <tr>
            <td><b>Name</b></td>
            <td><b>Description</b></td>
            <td><b>Price</b></td>
            <td><b>Type</b></td>
	</tr>
	<c:forEach var="p" items="${products}">
	<tr>
		<td>${p.productName}</td>
		<td>${p.description}</td>
		<td>${p.price}</td>
		<td>${p.productType}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>