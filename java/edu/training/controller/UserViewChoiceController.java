package edu.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;
@WebServlet("/userviewchoice")
public class UserViewChoiceController extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String str=(String)req.getParameter("userChoice");
		
		  
	        int id = Integer.parseInt(req.getParameter("pid"));
	        System.out.println(str);
	        ProductService ps = new ProductService();
	        try {
if(str!=null) {
	            if (str.equals("Move to Wishlist")) {

	                Product p = ps.getProduct(id);

	                req.setAttribute("product", p);

	                RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");

	                rd.forward(req, res);

	            } else if(str.equals("Add to Cart")) {

	                String s = ps.deleteProduct(id);

	                res.setContentType("text/html");

	                PrintWriter out = res.getWriter();

	                out.println(s);

	                req.getRequestDispatcher("viewController").include(req, res);

	            }
	            else if(str.equals("Purchase")) {

	                String s = ps.deleteProduct(id);

	                res.setContentType("text/html");

	                PrintWriter out = res.getWriter();

	                out.println(s);

	                req.getRequestDispatcher("viewController").include(req, res);
	            }
	            else{
	            	 Product p = ps.getProduct(id);

	                 req.setAttribute("product", p);

	                 RequestDispatcher rd = req.getRequestDispatcher("DisplayDescription.jsp");

	                 rd.forward(req, res);
	            }
}
	        } catch (ClassNotFoundException | SQLException e) {

	            e.printStackTrace();

	           

	        }


	}

}
