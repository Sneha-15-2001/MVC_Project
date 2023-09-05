package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminChoiceController")
public class AdminChoiceController extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String adminOf=req.getParameter("adminOf");
		
		if(adminOf.equals("Add Products")) {
			
			RequestDispatcher rd=req.getRequestDispatcher("addproduct.jsp");
			rd.forward(req, res);
			
		}
		else if(adminOf.equals("Logout")) {
			RequestDispatcher rd=req.getRequestDispatcher("/logout");
			rd.forward(req, res);
		}
		else if(adminOf.equals("User Requests")) {
			RequestDispatcher rd=req.getRequestDispatcher("UserRequests.jsp");
			rd.forward(req, res);
		}
		
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/viewController");
			rd.forward(req, res);
			
		}
	

}
}
