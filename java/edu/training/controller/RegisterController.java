package edu.training.controller;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.User;
import edu.training.service.ProductService;
import edu.training.service.UserService;
@WebServlet("/registerserv")
public class RegisterController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String uname=(String)req.getParameter("name");
		
		 String dobStr=(String)req.getParameter("dob"); 
		 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		 Date pd = null;
		try {
			pd = dateFormat.parse(dobStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email=(String)req.getParameter("email");
		String phone=(String)req.getParameter("mob");
		String password=(String)req.getParameter("passwd");
		
		UserService us=new UserService();
		User u=new User(uname,pd,email,phone,password);
		try {
			us.addUser(u);
			res.setContentType("text/html");
	
			 HttpSession session=req.getSession();
			 session.setAttribute("successMessage","User Created");
			
			req.getRequestDispatcher("login.jsp").forward(req, res);
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		}

}
