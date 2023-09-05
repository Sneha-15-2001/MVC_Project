package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;
import edu.training.service.UserService;

@WebServlet("/purchaseProduct")
public class PurchaseProductController extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		UserService us= new UserService();
		Product p = null;
		try {
			int q=us.quantity(pid);
			if(q>0) {
			p=us.purchase(pid);
			req.setAttribute("product", p);
			RequestDispatcher rd = req.getRequestDispatcher("purchaseProduct.jsp");
			rd.forward(req, res);
			}
			else {
				res.setContentType("text/html");
				res.getWriter().println("Product is out of stock");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
