package dao;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.login;

public class LoginDAO 
{
    public boolean checkCredential(login l) throws ClassNotFoundException, SQLException
    {
		//1.get the details fromnlogin.java file
		String username=l.getUsername();
		String password=l.getPassword();
		//2.to get details from login table
		// 2.jdbc connection
		ConnectionManager cm=new ConnectionManager();
		 Connection con=cm.establishConnection();
		 
		 //3. where we are writing queries
		    //  a) statement class
		    // b)create query or create statement
		    //c)execute ur created query 
		   Statement st= con.createStatement();
		 //4. write and execute the query
		   ResultSet rt=st.executeQuery("select * from login1");
		  //ResultSet means which will have a predefined list implementation
		   
		 //5.check the username and password
		   while(rt.next())
		   {
			 if(username.equals(rt.getString("username")) && password.equals(rt.getString("password"))) 
			 {
				 cm.connectionclose();
				 return true;
				
				 
			 }
		   }
		   cm.connectionclose();
		   return false;
		   
    }

}
