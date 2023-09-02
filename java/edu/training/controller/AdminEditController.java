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
@WebServlet("/editController")
public class AdminEditController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		
		String pname=(String)req.getParameter("pname");
		String pdesc=(String)req.getParameter("pdesc");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		ProductService ps=new ProductService();
		Product p=new Product(pid,pname,pdesc,price,quantity);
		try {
			String s=ps.editProduct(p);
			//System.out.println(s);
			res.setContentType("text/html");
			res.getWriter().println(s);
			RequestDispatcher rd = req.getRequestDispatcher("/viewController");
			rd.include(req, res);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
