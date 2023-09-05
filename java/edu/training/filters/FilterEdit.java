package edu.training.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/editController")

public class FilterEdit extends HttpFilter {
 public void doFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws IOException, ServletException {

     double price = Double.parseDouble(req.getParameter("price"));

     int quantity = Integer.parseInt(req.getParameter("quantity"));



     if (price < 1 || quantity <= 1) {

         String pid = req.getParameter("pid");

         res.sendRedirect("/editController");

     } else {

         chain.doFilter(req, res);

     }
 }
}

	 
 

