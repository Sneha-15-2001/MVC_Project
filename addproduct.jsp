<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<center>
<h1>ADDING NEW PRODUCT</h1>
<form action="createProduct" method="post">
	<table>	
		<tr><td><label>Product Id</label></td><td><input type="text" name="pid" value="" placeholder="Enter product if"><br></td></tr>
		<tr><td><label>Product Name</label></td><td><input type="text" name="pname" value="" placeholder="Enter Product name"><br></td></tr>
		<tr><td><label>Description</label></td><td><input type="text" name="pdesc" value="" placeholder="Enter Description"><br></td></tr>
		<tr><td><label>Price</label></td><td><input type="text" name="price" value="" placeholder="Enter Price"><br></td></tr>
		<tr><td><label>Quantity</label></td><td><input type="text" name="quantity" value="" placeholder="Enter quantity"><br></td></tr>
		<tr><td ><input type="submit" value="Create Product"></td><td><input type="reset" value="Clear Data"></td></tr>
		</table>
</form>
</center>
</body>
</html>
