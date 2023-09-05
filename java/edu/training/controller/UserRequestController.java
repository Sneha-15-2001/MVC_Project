package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewCustomerRequestController")
public class UserRequestController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String b=(String)req.getParameter("user");
		RequestDispatcher rd;
		if(b.equals("VIEW ACTIVE CUSTOMER")) {
			rd=req.getRequestDispatcher("/activateuserdetails");
					rd.forward(req, res);
		}
		
		else if(b.equals("VIEW INACTIVE CUSTOMER")) { 
			rd=req.getRequestDispatcher("/inactivateuserdetails");
			rd.forward(req,res);
			}
		else if(b.equals("REMOVE CUSTOMER")) {
			rd=req.getRequestDispatcher("/removeuserdetails");
					rd.forward(req,res);
		}
	}

}
