package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchDisplay")
public class SearchDisplayController extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	String userChoice=(String)req.getParameter("userChoice");
	int id = Integer.parseInt(req.getParameter("pid"));
	req.setAttribute("id",id);
	if(userChoice.equals("Move To Wishlist")) {
		RequestDispatcher rd = req.getRequestDispatcher("userwishList");
		rd.forward(req, res);
	}else if(userChoice.equals("Add to Cart")) {
		
	}
	else {
		
	}
}
}
