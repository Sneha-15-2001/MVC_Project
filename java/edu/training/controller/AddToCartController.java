package edu.training.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;
import edu.training.service.UserService;
@WebServlet("/addCartList")
public class AddToCartController extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) {
	int pid=Integer.parseInt(req.getParameter("pid"));
	HttpSession session = req.getSession();
	String email = (String) session.getAttribute("userEmail");
	System.out.println(email);
	System.out.println(pid);
	List<Product> list = null;
	UserService us=new UserService();
	try {
		list = us.addtocart(pid);
		
		int a =us.addToDatabase(pid, email);
		if(a>0)
		{
			RequestDispatcher rd = req.getRequestDispatcher("UserHomePage.jsp");
			rd.include(req, res);
			res.getWriter().println("product added to cart");
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("UserHomePage.jsp");
			rd.include(req, res);
			res.getWriter().println("Already avaliable added to cart");
		}
	
		
}
	catch(Exception e) {
		
	}
}
public void doPost(HttpServletRequest req,HttpServletResponse res) {
doGet(req,res);
}
}
