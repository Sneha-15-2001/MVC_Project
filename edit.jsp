<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EDIT CART</h1>
<form action="editController" method="post">
<input type="hidden" name="pid" value="${param.pid }">
	<table>
	<tr><td><label>Product Name</label></td><td><input type="text" name="pname" disabled="disabled" value="${product.pname}" placeholder="Edit Product name"><br></td></tr>
		<tr><td><label>Description</label></td><td><input type="text" name="pdesc" disabled="disabled" value="${product.pdesc}" placeholder="Edit Description"><br></td></tr>
		<tr><td><label>Price</label></td><td><input type="text" name="price" value="${product.price}" placeholder="Edit Price"><br></td></tr>
		<tr><td><label>Quantity</label></td><td><input type="text" name="quantity" value="${product.quantity }" placeholder="Edit quantity"><br></td></tr>
		<tr><td ><input type="submit" value="Update"></td><td><input type="reset" value="Clear Data"></td></tr>
		</table>
</form>
</body>

</html>