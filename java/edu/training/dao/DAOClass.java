package edu.training.dao;




import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

 

public class DAOClass

{

    static Connection con=null;
    public static Connection getConnection()  throws SQLException,ClassNotFoundException{

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");

        } catch (ClassNotFoundException | SQLException e) {

            

            e.printStackTrace();

        }

        return con;

        

        

    }

 

}