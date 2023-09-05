package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.service.UserService;

@WebServlet("/loginPagecontrol")
public class loginPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        

        String email = request.getParameter("email");
        UserService us=new UserService();
        String s=null;
        try {
			s=us.getUserName(email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        HttpSession session = request.getSession();


        session.setAttribute("username", s);

        session.setAttribute("userEmail", email);

System.out.println(email+" "+s);

        response.sendRedirect("UserHomePage.jsp");

    }

}

