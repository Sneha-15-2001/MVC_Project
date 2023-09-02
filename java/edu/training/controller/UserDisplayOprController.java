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
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=req.getParameter("pname");
		String pdesc=(String)req.getParameter("pdesc");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		String a=req.getParameter("descchoice");
		Product p=new Product(pid,pname,pdesc,price,quantity);
	
		UserService us=new UserService();
					try {
						if(a.equals("ADD TO CART")) {
							String st = us.userAddtoCart(p);
							res.setContentType("text/html");
							res.getWriter().println(st);
							RequestDispatcher rd = req.getRequestDispatcher("viewproductuser");
							rd.include(req, res);
						}
						else if(a.equals("PURCHASE"))
						{
							
						}
					}
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}


