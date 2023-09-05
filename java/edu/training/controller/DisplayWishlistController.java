package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;
import edu.training.service.ProductService;

@WebServlet("/displaywishlist")
public class DisplayWishlistController extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	HttpSession session = req.getSession();
    ProductService ps=new ProductService();
	List<Integer> wishlist = (List<Integer>) session.getAttribute("wishlist");
	if(wishlist!=null) {
		try {
			List<Product> list4=ps.viewProductById(wishlist);
			req.setAttribute("list4", list4);
			for(Product i:list4) {
				System.out.println(i);
			}
			RequestDispatcher rd = req.getRequestDispatcher("WishlistList.jsp");
			rd.forward(req, res);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	else {
		RequestDispatcher rd = req.getRequestDispatcher("WishlistList.jsp");
		rd.forward(req, res);
	}
	
}
}