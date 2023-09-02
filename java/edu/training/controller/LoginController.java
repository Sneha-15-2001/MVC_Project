package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginserv")
public class LoginController extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	String email=req.getParameter("email");
	String passwd=req.getParameter("passwd");

	if(email.equals("Admin@gmail.com")&& passwd.equals("Reset123")) {
		RequestDispatcher rd=req.getRequestDispatcher("AdminChoice.jsp");
		rd.forward(req, res);
		
	}
	else {
		RequestDispatcher rd=req.getRequestDispatcher("UserChoice.jsp");
		rd.forward(req, res);
		
	}
}
}
