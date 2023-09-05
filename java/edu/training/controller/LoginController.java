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

import edu.training.model.User;
import edu.training.service.UserService;
@WebServlet("/loginserv")
public class LoginController extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	String email=req.getParameter("email");
	String passwd=req.getParameter("passwd");
	String str=req.getParameter("status");
	System.out.println(str);
 UserService n=new UserService();
 String status=null;
	if(email.equals("Admin@gmail.com")&& passwd.equals("Reset123")) {
		RequestDispatcher rd=req.getRequestDispatcher("AdminChoice.jsp");
		rd.forward(req, res);
		
	}
	else  {
		UserService us=new UserService();
		try {
			boolean userExists=us.isUser(email,passwd);
			if(userExists) {
				
			
			status=us.checkStatus(email);
			System.out.println(status);
			HttpSession session=req.getSession();
			req.setAttribute("userEmail", email);
			String s=us.getUserName(email);
			req.setAttribute("username", s);
			session.setAttribute("userStatus", status);
		if("active".equals(status)) {
		
			RequestDispatcher rd=req.getRequestDispatcher("loginPagecontrol");
			 rd.forward(req, res);
				
		}
			else {
			req.setAttribute("status","inactive");
			RequestDispatcher rd = req.getRequestDispatcher("wait.jsp");
            rd.forward(req, res);
		
	}
			}
		
			else {
				res.setContentType("text/html");
				res.getWriter().print("PROVIDE CORRECT CREDENTIALS");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	            rd.include(req, res);
				
			}
			}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
}
}


