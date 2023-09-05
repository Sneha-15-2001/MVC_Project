package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import edu.training.dao.DAOClass;
import edu.training.model.Product;
import edu.training.model.User;

public class AdminService extends HttpServlet{
	public void approveuser(String email) throws ClassNotFoundException, SQLException
    {
        Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("update ecartuser set status=? where email=?");
        ps.setString(1, "active");
        ps.setString(2, email);
        ps.executeUpdate();
    }

    public void deactivateuser(String email) throws ClassNotFoundException, SQLException
    {
        Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("update ecartuser set status=? where email=?");
        ps.setString(1, "inactive");
        ps.setString(2, email);
        ps.executeUpdate();
    }

    public void removeuser(String email) throws ClassNotFoundException, SQLException
    {
        Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from ecartuser where email=?");
        ps.setString(1, email);
        ps.executeUpdate();
    }

	public List<User> activeuser() throws SQLException, ClassNotFoundException {
		List<User> list=new ArrayList<User>();
		Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from ecartuser where status=?");
        ps.setString(1, "active");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	
        	list.add(new User(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        
        }
		return list;
        
		
	}

	public List<User> deactiveuser() throws SQLException, ClassNotFoundException {
		List<User> list=new ArrayList<User>();
		Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from ecartuser where status=?");
        ps.setString(1, "inactive");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	
        	list.add(new User(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        
        }
		return list;
	}

	public List<User> userlist() throws ClassNotFoundException, SQLException {
		List<User> list=new ArrayList<User>();
		Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from ecartuser order by status");
      
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	String s=rs.getString(6);
        	User user=new User(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5));
        	user.setStatus(s);
        	list.add(user);
        }
		return list;
		
	
	}

	public void UpdateQuantity(int id, int quantity) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("update ecart set quantity=quantity-? where id=?");
        ps.setInt(1, quantity);
        ps.setInt(2, id);
        ps.executeUpdate();
		
	}

	public void removeCart(int id, String s) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from addtocart where id=? and email=?");
        ps.setInt(1, id);
        ps.setString(2, s);
        ps.executeUpdate();
		
		
	}
}
