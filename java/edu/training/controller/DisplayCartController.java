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
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import edu.training.model.Product;
import edu.training.service.UserService;

@WebServlet("/displayCart")
public class DisplayCartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    UserService us = new UserService();
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("userEmail");
		System.out.println(email);
		
		
		try {
			
			List<Integer> l=us.cartService(email);
			
			List<Product> list = us.cartdisplay(l);
			req.setAttribute("list", list);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("displayaddcart.jsp");
			rd.forward(req, res);
			}
			
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}


public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	doGet(req,res);}
}
