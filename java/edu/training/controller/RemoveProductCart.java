package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.service.AdminService;

@WebServlet("/removefromcart")
public class RemoveProductCart extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("pid"));
		HttpSession session=req.getSession();
		String s=(String) session.getAttribute("userEmail");
		AdminService as=new AdminService();
		try {
			as.removeCart(id,s);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("displayCart");
		rd.include(req, res);
		res.getWriter().println("Removed From My Cart");
	}
	
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}
}
