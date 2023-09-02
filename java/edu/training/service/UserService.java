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
			 
	        ps.setString(3,user.getMob());
	        ps.setString(4, user.getEmail());
	        ps.setString(5, user.getPasswd());
	        ps.setString(6, "invalid");
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
	            list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
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
	}

