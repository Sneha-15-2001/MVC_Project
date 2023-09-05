package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;
@WebServlet("/createProduct")
public class ProductController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=(String)req.getParameter("pname");
		String pdesc=(String)req.getParameter("pdesc");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		String category=(String)req.getParameter("category");
		ProductService ps=new ProductService();
		Product p=new Product(pid,pname,pdesc,price,quantity,category);
		try {
			ps.addproduct(p);
			res.setContentType("text/html");
			res.getWriter().println("<p style='color:green'>Product Created</p>");
			req.getRequestDispatcher("AdminChoice.jsp").include(req, res);
		} catch (SQLException |ClassNotFoundException e) {
			res.setContentType("text/html");
			res.getWriter().println("<p style='color:red'>Enter Correct Details </p>");
			req.getRequestDispatcher("addproduct.jsp").include(req, res);
			e.printStackTrace();
		}
		
		}

}
