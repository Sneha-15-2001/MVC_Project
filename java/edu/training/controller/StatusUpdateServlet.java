package edu.training.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/checkstatusupdate")
public class StatusUpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session=req.getSession();
		String us=(String)session.getAttribute("userStatus");
		res.setContentType("text/plain");
		res.getWriter().write(us);
		System.out.println(us);
	}

}
