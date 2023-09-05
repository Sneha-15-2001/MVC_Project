package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.AdminService;
@WebServlet("/adminrequestcontrol")
public class AdminRequestController extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
	String email=req.getParameter("email");
	
	String s1=req.getParameter("approvaloption");
	AdminService as=new AdminService();
	if(s1.equals("APPROVE")){
		try {
			as.approveuser(email);
			System.out.println(email);
			res.setContentType("text/html");
			res.getWriter().println("Activated: "+email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(s1.equals("DISAPPROVE")) {
		try {
			as.deactivateuser(email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		try {
			as.removeuser(email);
			res.setContentType("text/html");
			res.getWriter().println("Deleted: "+email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
