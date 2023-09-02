<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Product List</title>

    <style>

        body {

            font-family: Arial, sans-serif;

            background-color: #f0f0f0;

            margin: 0;

            padding: 0;

        }

 

        h1 {

            background-color: #333;

            color: #fff;

            padding: 10px;

        }

 

        h3 {

            margin-top: 20px;

        }

 

        table {

            width: 100%;

            border-collapse: collapse;

            margin-top: 10px;

        }

 

        th, td {

            padding: 10px;

            text-align: center;

        }

 

        th {

            background-color: #333;

            color: #fff;

        }

 

        tr:nth-child(even) {

            background-color: #f2f2f2;

        }

 

        tr:hover {

            background-color: #ddd;

        }

 

        input[type="submit"] {

            background-color: #007BFF;

            color: #fff;

            border: none;

            padding: 8px 16px;

            cursor: pointer;

        }

 

        input[type="submit"].product-button {

            background-color: transparent; /* Remove background color for product names */

            color: #000; /* Set the text color for product names to black */

        }

 

        input[type="submit"]:hover {

            background-color: #0056b3;

        }

    </style>

</head>

<body>

    <h1>View Product</h1>

    <h3>Product List</h3>

    <table border="1">

        <thead>

            <tr>

                <th>Product Name</th>

                <th>Move to Wishlist</th>

                <th>Move to Cart</th>

                <th>Purchase</th>

            </tr>

        </thead>

        <tbody>

            <c:forEach var="product" items="${list}">

                <form action="userviewchoice?pid=${product.pid}" method="post">

                    <tr>

                        <td><input type="submit" name="userChoice" value="${product.pname}" class="product-button"></td>

                        <td><input type="submit" name="userChoice" value="Move to Wishlist" class="action-button"></td>

                        <td><input type="submit" name="userChoice" value="Add to Cart" class="action-button"></td>

                        <td><input type="submit" name="userChoice" value="Purchase" class="action-button"></td>

                    </tr>

                </form>

            </c:forEach>

        </tbody>

    </table>

</body>

</html>