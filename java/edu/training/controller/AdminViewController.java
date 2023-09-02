package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;

@WebServlet("/viewController")
public class AdminViewController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		ProductService ps=new ProductService();
		
		try {
			List<Product> prdtList=ps.viewProduct();
			
			
			req.setAttribute("pList", prdtList);
			req.getRequestDispatcher("viewproduct.jsp").include(req,res);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
