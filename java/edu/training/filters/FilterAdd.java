package edu.training.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;

@WebFilter("/createProduct")
public class FilterAdd extends HttpFilter{
	public void doFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws IOException, ServletException{
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=(String)req.getParameter("pname");
		String pdesc=(String)req.getParameter("pdesc");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		if(pname.length()>4 && pdesc!=null && price>1 && quantity>=0){
			chain.doFilter(req, res);
		}
		else {
			res.setContentType("text/html");
			res.getWriter().println("<p style='color:red'>Invalid Product Details</p>");
			req.getRequestDispatcher("addproduct.jsp").include(req, res);
		}
		
			
	}
	

}
