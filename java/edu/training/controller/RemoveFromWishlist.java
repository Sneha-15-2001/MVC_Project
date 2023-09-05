package edu.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/removefromwishlist")
public class RemoveFromWishlist extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("pid"));
		  HttpSession session=req.getSession(); 
		  List<Integer> wishlist=(List<Integer>)session.getAttribute("wishlist");
		  wishlist.remove(wishlist.indexOf(id));
		  res.setContentType("text/html");
		  	res.getWriter().println("REMOVE FROM WISHLIST");
		  RequestDispatcher rd=req.getRequestDispatcher("/displaywishlist");
		  rd.include(req, res);
		  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
