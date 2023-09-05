package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.ProductService;
import edu.training.model.*;
@WebServlet("/searchProduct")
public class SearchProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String search = req.getParameter("search");
		ProductService ps = new ProductService();
		List<Product> list = null;
		try {
			list = ps.searchProducts(search);
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("SearchDisplay.jsp");
			rd.forward(req, res);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}

