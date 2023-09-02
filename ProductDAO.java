package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Product;

public class ProductDAO 
{
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con= cm.establishConnection();
		// take the input from the user
		String  que= "insert into Product1(Product_Id ,Product_Name,Minimum_Sell_Quantity  ,price,Quantity) values(?,?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(que); // runtime
		ps.setInt(1, p.getProductId());
		ps.setString(2, p.getProductName());
		ps.setInt(3,p.getsSellMinQuantity());
		ps.setInt(4, p.getPrice());
		ps.setInt(5, p.getQuantity());
		ps.executeUpdate();
		cm.connectionclose();
	}
	public void updateProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con= cm.establishConnection();
		// take the input from the user
		String  que="update product1 set  Product_Name=?,Minimum_Sell_Quantity=? ,price=?,Quantity=?  where Product_Id=?" ;
		PreparedStatement ps= con.prepareStatement(que); // runtime
		ps.setString(1, p.getProductName());
		ps.setInt(2, p.getsSellMinQuantity());
		ps.setInt(3,p.getPrice());
		ps.setInt(4, p.getQuantity());
		ps.setInt(5, p.getProductId());
		ps.executeUpdate();
		cm.connectionclose();
	
	}
	public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con= cm.establishConnection();
		// take the input from the user
		String  que= " delete from Product1 where Product_Id=?";
		PreparedStatement ps= con.prepareStatement(que); // runtime
		ps.setInt(1, p.getProductId());
		ps.executeUpdate();
		cm.connectionclose();
	
	}
	public void display() throws SQLException, ClassNotFoundException 
	{

		//1.to get details from login table
		// 1.jdbc connection
		ConnectionManager cm=new ConnectionManager();
		 Connection con=cm.establishConnection();
		 
		 //2. where we are writing queries
		    //  a) statement class
		    // b)create query or create statement
		    //c)execute ur created query 
		   Statement st= con.createStatement();
		 //3. write and execute the query
		   ResultSet rt=st.executeQuery("select * from product1");
		  //ResultSet means which will have a predefined list implementation
		   
		 //4.print 
		   while(rt.next())
		   {
			 
			System.out.println(rt.getInt("product_Id")+" |" +rt.getString("Product_Name")+ "|" +rt.getInt("Minimum_sell_Quantity") +"|"  + rt.getInt("price")+"|" +rt.getInt("Quantity"));
		   }
		cm.connectionclose();

	}

}
