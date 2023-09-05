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

import edu.training.model.User;
import edu.training.service.AdminService;

@WebServlet("/inactivateuserdetails")
public class DeActivateUserController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		AdminService as=new AdminService();
        List<User> list2 = new ArrayList<User>();
        
        
        try {
            list2 = as.deactiveuser();
            for(User i:list2) {
            	System.out.println(i);
            }
            req.setAttribute("list2", list2);
    		RequestDispatcher rd = req.getRequestDispatcher("DeactivateUser.jsp");
            rd.forward(req, res);
            }
         catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }
	

}


