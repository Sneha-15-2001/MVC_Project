<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Insert title here</title>

    <style>

        table {

            width: 100%;

            border-collapse: collapse;

            background-color: purple;

            border-radius: 8px;

            box-shadow: 0 0 25px rgb(64, 0, 128,0.5);

        }

        th, td {

            padding: 10px;

            text-align: left;

        }

        th {

            background-color: rgb(46, 46, 56); 
            color:white;/* Purple color for table header */

        }

        tr:nth-child(even) {

            background-color: #e0ccff; /* Lighter purple color for even rows */

        }

        tr:nth-child(odd) {

            background-color:#b380ff; /* Darker purple color for odd rows */

        }

        form {

            display: flex;

            justify-content: space-between;

        }

        input[type="submit"] {

            background-color: #6600CC; /* Purple button background color */

            color: white;

			border-radius:5px;
            border: none;

            padding: 5px 7px;

            cursor: pointer;

        }
        input[type="submit"]:hover {

            background-color: #3b3b3b; /* Purple button background color */
			box-shadow: 0 0 25px rgb(64, 0, 128,0.5);
            color: white;

        }

    </style>

</head>

<body>

    <h1>View Product</h1>

    <h3>Product List</h3>

    <table border="1">

        <thead>

            <tr>

                <th>Product ID</th>

                <th>Product Name</th>

                <th>Product Desc</th>

                <th>Product Price</th>

                <th>Product Qty</th>

                <th>Choice</th>

            </tr>

        </thead>

        <tbody>

            <c:forEach var="product" items="${pList}">

                <tr>

                    <td><c:out value="${product.pid}"></c:out></td>

                    <td><c:out value="${product.pname}"></c:out></td>

                    <td><c:out value="${product.pdesc}"></c:out></td>

                    <td><c:out value="${product.price}"></c:out></td>

                    <td><c:out value="${product.quantity}"></c:out></td>

                    <td>

                        <form action="viewdata?pid=${product.pid}" method="post">

                            <input type="submit" name="adminChoice" value="EDIT">

                            <input type="submit" name="adminChoice" value="DELETE">

                        </form>

                    </td>

                </tr>

            </c:forEach>

        </tbody>

    </table>

</body>

</html>