package edu.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;

@WebServlet("/userwishList")
public class UserWishlistController  extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		Product product = null;
		int id = Integer.parseInt(req.getParameter("pid"));
		System.out.println(id);
		HttpSession session = req.getSession();
		List<Integer> wishlist=(List<Integer>)req.getSession().getAttribute("wishlist");
	
		if(wishlist!=null) {
			
			if(wishlist.contains(id))
			{
				RequestDispatcher rd = req.getRequestDispatcher("UserHomePage.jsp");
				rd.include(req, res);
				res.getWriter().println("<br><br><br><h4><center>ALREADY AVAILABLE IN WISH LIST</center></h4>");
			}
			else
			{
				wishlist.add(id);
			
				RequestDispatcher rd = req.getRequestDispatcher("UserHomePage.jsp");
				rd.include(req, res);
				res.getWriter().println("<br><br><br><h4><center>ADD TO WISH LIST</center></h4>");
			}
			
		}
		else if(wishlist==null) {
			System.out.println(1);
			wishlist=new ArrayList<>(); 
			wishlist.add(id);
			session.setAttribute("wishlist", wishlist);
			RequestDispatcher rd = req.getRequestDispatcher("UserHomePage.jsp");
			rd.include(req, res);
			res.getWriter().println("ADD TO WISH LIST");
		}
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			doGet(req, res);
		}

		}
		
		
	


