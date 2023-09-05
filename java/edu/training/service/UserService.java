package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.training.model.Product;
import edu.training.model.User;

import edu.training.dao.DAOClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
	 public  String addUser(User user) throws SQLException, ClassNotFoundException {
	        Connection con = DAOClass.getConnection();
	        PreparedStatement ps=con.prepareStatement("insert into ecartuser value(?,?,?,?,?,?)");
	        
	        ps.setString(1,user.getName());
			
			  java.sql.Date d1=new java.sql.Date(user.getDob().getTime());
			  ps.setDate(2,d1);
		        ps.setString(3, user.getEmail());

	        ps.setString(4,user.getMob());
	        ps.setString(5, user.getPasswd());
	        ps.setString(6, "inactive");
	        int temp = ps.executeUpdate();
	        return "";

	    }
	 public List<Product> userviewProduct() throws ClassNotFoundException, SQLException
	    {
	        List<Product> list = new ArrayList<>();
	        Connection con = DAOClass.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from ecart");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
	        }
	        return list;
	    }
	public String userAddtoCart( Product product) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into cartlist value(?,?,?,?,?)");
        ps.setInt(1,product.getPid());
        ps.setString(2, product.getPname());
        ps.setString(3, product.getPdesc());
        ps.setDouble(4, product.getPrice());
        ps.setInt(5, product.getQuantity());
        int temp = ps.executeUpdate();
       

		return "ADDED TO CART";
	}
	public String checkStatus(String email) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		String status=null;
        PreparedStatement ps=con.prepareStatement("select status from ecartuser where email=?");
        ps.setString(1, email);
       ResultSet rs=ps.executeQuery();
       if(rs.next()) {
    	   status=rs.getString("status");
    	   
       }
       System.out.println(status);
		return status;
	}
	public boolean isUser(String email, String passwd) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
	
        PreparedStatement ps=con.prepareStatement("select count(*) from ecartuser where email=? and password=?");
        ps.setString(1, email);
        ps.setString(2, passwd);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
        	int count=rs.getInt(1);
        	return count>0;
        }
		return false;
	}
	public String getUserName(String email)  throws ClassNotFoundException, SQLException {
			Connection con = DAOClass.getConnection();
			String s=null;
	        PreparedStatement ps=con.prepareStatement("select name from ecartuser where email=?");
	        ps.setString(1, email);
	       ResultSet rs=ps.executeQuery();
	       if(rs.next()) {
	    	   s=rs.getString("name");
	    	   
	       }
	     
			return s;
	}
	public List<Product> addtocart(int id) throws ClassNotFoundException, SQLException {
		List<Product> list=new ArrayList<Product>();
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from ecart where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
		}
		return list;
	}
	public int addToDatabase(int id, String email) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from addtocart where id=? and email=?");
		ps.setInt(1, id);
		ps.setString(2,email);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return -1;
		}	
		else
		{
		System.out.println(id +" "+email);
			PreparedStatement ps1 = con.prepareStatement("insert into addtocart values (?,?)");
			System.out.println(id +" "+email);

			ps1.setInt(1,id);
			System.out.println(id +" "+email);

			ps1.setString(2, email);
			System.out.println(id +" "+email);

			int temp = ps1.executeUpdate();
			System.out.println(id +" "+email);

			return temp;
		}
	}

	/*
	 * public List<Integer> cartservice(String email) throws ClassNotFoundException,
	 * SQLException { List<Integer> list1 = new ArrayList<Integer>(); Connection con
	 * = DAOClass.getConnection(); PreparedStatement ps =
	 * con.prepareStatement("select Pid from addtocart where Email=?");
	 * ps.setString(1, email); ResultSet rs = ps.executeQuery(); while(rs.next()) {
	 * list1.add(rs.getInt("pid")); } return list1; }
	 */
	public List<Product> cartdisplay(List<Integer> list1) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		List<Product> list = new ArrayList<>();
		for(int i:list1)
		{
			PreparedStatement ps = con.prepareStatement("select * from ecart where id=?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
			}
		}
		return list;
	}

	
	public List<Integer> cartService(String email) throws ClassNotFoundException, SQLException {
		List<Integer> list1=new ArrayList<Integer>();
		Connection con = DAOClass.getConnection();
		PreparedStatement ps = con.prepareStatement("select id from addtocart where email=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			list1.add(rs.getInt(1));
		}
		return list1;
		
	}
	public Product purchase(int pid) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from ecart where id=?");
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6));
		
	}
	public int quantity(int pid) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select quantity from ecart where id=?");
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getInt("quantity");
	}

		
		
	
	}


