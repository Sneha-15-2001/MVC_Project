<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EDIT CART</h1>
<form action="displayDescriptionOpr" method="post">
<input type="hidden" name="pid" value="${param.pid }">
	<table>
	<tr><td><label>Product Name :</label></td><td>${product.pname}</td></tr>
		<tr><td><label>Description :</label></td><td>${product.pdesc}</td></tr>
		<tr><td><label>Price :</label></td><td>${product.price}</td></tr>
				<tr><td><label>Quantity :</label></td><td>${product.quantity}</td></tr>
				
		
		<tr><td ><input type="submit" name="descchoice" value="ADD TO CART"></td><td><input type="reset" name="descchoice" value="PURCHASE"></td></tr>
		</table>
</form>
</body>
</html>