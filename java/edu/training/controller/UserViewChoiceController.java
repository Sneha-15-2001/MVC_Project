package edu.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import edu.training.service.ProductService;
@WebServlet("/userviewchoice")
public class UserViewChoiceController extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String str=(String)req.getParameter("userChoice");
		
		  
	        int id = Integer.parseInt(req.getParameter("pid"));
	        
	        ProductService ps = new ProductService();
	        String msg=null;
	        try {
if(str!=null) {
	            if (str.equals("Move to Wishlist")) {
	            	RequestDispatcher rd = req.getRequestDispatcher("/userwishList");
	    			rd.forward(req, res);
	            }
	            else if(str.equals("Add to Cart")) {

	            	req.setAttribute("id", req.getParameter("pid"));
	    			RequestDispatcher rd = req.getRequestDispatcher("addCartList");
	    			rd.forward(req, res);
	            }
	            else if(str.equals("buy")) {
	            

	                 RequestDispatcher rd = req.getRequestDispatcher("purchaseProduct");

	                 rd.forward(req, res);
	               
	            }
	            else if(str.equals("Remove from Wishlist")) {
		            

	            	RequestDispatcher rd = req.getRequestDispatcher("removefromwishlist");
	    			rd.forward(req, res);
	               
	            }
	            else if(str.equals("Remove from Cart")) {
	            	RequestDispatcher rd = req.getRequestDispatcher("removefromcart");
	    			rd.forward(req, res);
	            }
	            else{
	            	 Product p = ps.getProduct(id);

	                 req.setAttribute("product", p);

	                 RequestDispatcher rd = req.getRequestDispatcher("DisplayDescription.jsp");

	                 rd.forward(req, res);
	            }
	        } 
	        }catch (ClassNotFoundException | SQLException e) {

	            e.printStackTrace();

	           

	        }


	
	}
	}
