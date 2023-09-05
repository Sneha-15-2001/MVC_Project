package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.AdminService;
import edu.training.model.*;
@WebServlet("/activateuserdetails")
public class ActivateUserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		AdminService as=new AdminService();
        List<User> list1 = new ArrayList<User>();
        
        
        try {
            list1 = as.activeuser();
            for(User i:list1) {
            	System.out.println(i);
            }
            req.setAttribute("list1", list1);
    		RequestDispatcher rd = req.getRequestDispatcher("ActivateUser.jsp");
            rd.forward(req, res);
            }
         catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }
	}


