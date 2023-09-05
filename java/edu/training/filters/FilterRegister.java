package edu.training.filters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;

@WebFilter("/registerserv")
public class FilterRegister extends HttpFilter implements Filter {


	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	    {
	    	
	    String uname=(String)request.getParameter("name");
	    String dobStr=(String)request.getParameter("dob"); 
		String email=(String)request.getParameter("email");
		String phone=(String)request.getParameter("mob");
		String password=(String)request.getParameter("passwd");

	    List<String> list=new ArrayList<>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy");
        
        Date user_date=null;
        Date check_date=null;
       
	            try 
	            {

	 

	                user_date = df.parse(dobStr);
	                check_date = df.parse("2000");
	            } catch (ParseException e) 
	            {
	                response.setContentType("text/html");
	                response.getWriter().println("<html><h1><center>Invalid Date of Birth (Enter in dd-mm-yyyy format)</center></html>");
	                request.getRequestDispatcher("register.jsp").include(request, response);
	                return; // Return after sending the response
	            }

	            if (uname.length() > 2 && user_date.before(check_date)&& phone.length() == 10 && Pattern.matches("[a-z][A-Za-z0-9]+@[a-z]+.[com,org,in]{2,6}", email)&& Pattern.matches("[A-za-z][a-zA-Z0-9_$*!@#^&]{8,15}", password))
	            {
	                chain.doFilter(request, response);

	            } 
	            if (uname.length() < 3) 
	            {
	                list.add("First Name (Minimum 3 characters required)");

	 

	               

	 

	            } 
	            if ((phone.length() != 10) &&((phone.charAt(0)!='9'||phone.charAt(0)!='8'||phone.charAt(0)!='7'|| (phone.charAt(0)!='6'))) )
	            {

	               list.add("Invalid Mobile Number (10 digits required) and should starts with 9/8/7/6");

	            } 
	           if (user_date.after(check_date)) 
	            {

	 

	                list.add("Date of Birth (Year must be before 2000)");

	 

	            } 
	            if (!Pattern.matches("[a-z][A-Za-z0-9]+@[a-z]+.[com,org,in]{2,6}", email)) 
	            {

	 

	               list.add("Email ID (Valid format: abc@example.com)");

	 

	 

	            } 
	            if (!Pattern.matches("[A-za-z][a-zA-Z0-9_$*!@#^&]{8,15}", password)) 
	            {

	 

	               list.add("Password (Minimum 8 characters, alphanumeric and special characters allowed)");

	            } 

	            response.setContentType("text/html");
	            response.getWriter().println("<html><h1><center>"+list+"</center></html>");
	            request.getRequestDispatcher("register.jsp").include(request, response);

	 

	    }    

	 

	    

	 

	}

