package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.AdminService;

@WebServlet("/paymentHandler")
public class PaymentHandlerController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int quantity=Integer.parseInt(req.getParameter("selectquantity"));
		double price=Double.parseDouble(req.getParameter("pq"));
		System.out.println(price);
				int id=Integer.parseInt(req.getParameter("pid"));
		AdminService as=new AdminService();
		try {
			as.UpdateQuantity(id,quantity);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String paymentChoice=req.getParameter("paymentChoice");
		
		if("Pay on COD".equals(paymentChoice)) {
			RequestDispatcher rd=req.getRequestDispatcher("ThankYou.jsp");
			rd.include(req, res);
			res.getWriter().println("Order is taken place by Cash On Delivery Mode.\n Amount to pay:"+(quantity*price));

		}
		else if("Pay with UPI".equals(paymentChoice))
		{RequestDispatcher rd=req.getRequestDispatcher("ThankYou.jsp");
		rd.include(req, res);
			//res.setContentType("text/html");
		 res.getWriter().println("Order is taken place by UPI.\n Amount paid:"+(quantity*price));

		}
		else if("Pay with Card".equals(paymentChoice)) {
			RequestDispatcher rd=req.getRequestDispatcher("ThankYou.jsp");
			rd.include(req, res);//res.setContentType("text/html");

			res.getWriter().println("Order is taken place by Card.\n Amount paid:"+(quantity*price));
		}

	}}
