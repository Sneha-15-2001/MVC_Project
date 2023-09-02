<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>

    
    <style>

        body {

            background-color: rgb(255, 255, 255);

            color: rgb(175, 96, 255);

            font-family: Arial, sans-serif;

            margin: 0;

            padding: 0;

            display: flex;

            justify-content: center;

            align-items: center;

            height: 100vh;

        }

 

        .dashboard {

            background-color: #333;

            border-radius: 8px;

            box-shadow: 0 0 25px rgb(64, 0, 128,0.5);

            padding: 20px;

            text-align: center;

            width: 300px;

        }

 

        .dashboard input {

            display: block;

            margin: 10px auto;

            padding: 10px;

            text-decoration: none;

            color: #fff;

            background-color: #444;

            border-radius: 7.5px;

            transition: background-color 0.3s, box-shadow 0.3s;
            text-align: center;
            width:100%;
            height: 45px;
            font-weight: bold;
        }

 

        .dashboard input:hover {

            background-color: rgb(182, 108, 255);

            box-shadow: 0 0 10px rgb(128, 128, 128);

        }

 

       
  

      
    </style>

</head>
<body>
<div class="dashboard">
 <h2>Admin Dashboard</h2>
<form  action="AdminChoiceController" method="post">
<input type=submit name="adminOf" value="Home"> 
<input type=submit name="adminOf" value="Add Products">
<input type=submit name="adminOf" value="View Products">
<input type=submit name="adminOf" value="User Requests"> 
<input type=submit name="adminOf" value="Logout"> 


</form>
</div>
</body>
</html>