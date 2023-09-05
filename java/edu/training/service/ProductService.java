package edu.training.service;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 

import edu.training.dao.DAOClass;
import edu.training.model.Product;

 

public class ProductService {



 

    public  String addproduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = DAOClass.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into ecart value(?,?,?,?,?,?)");
        ps.setInt(1,product.getPid());
        ps.setString(2, product.getPname());
        ps.setString(3, product.getPdesc());
        ps.setDouble(4, product.getPrice());
        ps.setInt(5, product.getQuantity());
        ps.setString(6, product.getCategory());
        int temp = ps.executeUpdate();
        return "";

    }
    public String deleteProduct(int pid) throws ClassNotFoundException, SQLException {
    	Connection con = DAOClass.getConnection();
        PreparedStatement ps=con.prepareStatement("delete from ecart where id=?");
        ps.setInt(1, pid);
        int temp=ps.executeUpdate();
		return "DELETED SUCCESSFULLY";
    }
    public List<Product> viewProduct() throws SQLException, ClassNotFoundException
    {
                List<Product> pList = new ArrayList<Product>();
                Connection con=DAOClass.getConnection();
                PreparedStatement ps=con.prepareStatement("select * from ecart");
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                	
                	pList.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
                
                }
				return pList;

    }
	public String editProduct(Product product)throws SQLException, ClassNotFoundException {
		
		Connection con = DAOClass.getConnection();
        PreparedStatement ps=con.prepareStatement("update ecart set Price=?,Quantity=? where Id=?");
        ps.setDouble(1, product.getPrice());
        ps.setInt(2, product.getQuantity());
        ps.setInt(3,product.getPid());
        int temp = ps.executeUpdate();
        return "EDITED SUCCESSFULLY";
	}
	public Product getProduct(int id) throws ClassNotFoundException, SQLException{
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from ecart where id=?;");
		ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6));
	}
	public String getProductname(int id) throws ClassNotFoundException, SQLException {
		Connection con = DAOClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select name from ecart where id=?");
		ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        rs.next();
		return rs.getString("name");
	}
	public List<Product> viewProductById(List<Integer> wishlist) throws ClassNotFoundException, SQLException {

        List<Product> pList = new ArrayList<Product>();
        Connection con=DAOClass.getConnection();
        for(Integer i:wishlist) {
        PreparedStatement ps=con.prepareStatement("select * from ecart where id=?");
        ps.setInt(1,i);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	
        	pList.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
        
        }
        }
		return pList;
		
	}
	public List<Product> searchProducts(String search) throws ClassNotFoundException, SQLException {
		List<Product> pList = new ArrayList<Product>();
        Connection con=DAOClass.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from ecart where category=?");
        ps.setString(1,search);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	pList.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6)));
        
        }
        return pList;
		
	}
	
	
}