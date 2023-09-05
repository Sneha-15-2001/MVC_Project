package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;
import edu.training.service.UserService;

@WebServlet("/displayDescriptionOpr")
public class UserDisplayOprController extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=req.getParameter("pname");
		String pdesc=(String)req.getParameter("pdesc");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		String category=(String)req.getParameter("category");
		String a=req.getParameter("descchoice");
		Product p=new Product(pid,pname,pdesc,price,quantity,category);
	
		UserService us=new UserService();
					if(a.equals("Add to Cart")) {
						req.setAttribute("id", req.getParameter("pid"));
						RequestDispatcher rd = req.getRequestDispatcher("addCartList");
						rd.forward(req, res);
					}
					
					else if(a.equals("buy"))
					{
						RequestDispatcher rd = req.getRequestDispatcher("purchaseProduct");

					     rd.forward(req, res);
					}
					else  if (a.equals("Move to Wishlist")) {
		            	RequestDispatcher rd = req.getRequestDispatcher("/userwishList");
		    			rd.forward(req, res);
		            }
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	}


