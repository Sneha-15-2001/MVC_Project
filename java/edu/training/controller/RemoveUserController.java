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
@WebServlet("/removeuserdetails")
public class RemoveUserController extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		AdminService as=new AdminService();
        List<User> list3 = new ArrayList<User>();
        
        
        try {
            list3= as.userlist();
            for(User i:list3) {
            	System.out.println(i);
            }
            req.setAttribute("list3", list3);
    		RequestDispatcher rd = req.getRequestDispatcher("DeleteUser.jsp");
            rd.forward(req, res);
            }
         catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();
        }
      
    }

}
