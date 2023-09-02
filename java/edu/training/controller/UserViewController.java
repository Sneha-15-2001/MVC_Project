package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.UserService;
@WebServlet("/viewproductuser")
public class UserViewController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us=new UserService();
        try {
            List<Product> list = us.userviewProduct();
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("UserViewProduct.jsp");
            rd.forward(request, response);
            for(Product i:list) {
            	System.out.println(i);
            }
        } 
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }

 

	       
	 

	

	
	}


