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

@WebServlet("/viewdata")

public class AdminViewOprController extends HttpServlet {

 

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String ch = req.getParameter("adminChoice");

        ProductService ps = new ProductService();

        int id = Integer.parseInt(req.getParameter("pid"));

 

        try {

            if (ch.equals("EDIT")) {

                Product p = ps.getProduct(id);

                req.setAttribute("product", p);

                RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");

                rd.forward(req, res);

            } else if(ch.equals("DELETE")) {

                String s = ps.deleteProduct(id);

                res.setContentType("text/html");

                PrintWriter out = res.getWriter();

                out.println(s);

                req.getRequestDispatcher("viewController").include(req, res);

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

           

        }

    }

}