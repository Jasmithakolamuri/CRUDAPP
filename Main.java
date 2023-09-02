//CRUD APPLICATION PROJECT
package controller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		int choice,option;
		login l=new login();
		LoginDAO  ldao= new LoginDAO();
		Product p=  new Product();
		ProductDAO pdao = new ProductDAO();
		do
		{
			System.out.println("1.ADMIN");
			System.out.println("2.AGENT");
			System.out.println("3.Exit");
			System.out.println("***********************************************************");
			System.out.println("Enter your Choice:");
			choice =sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Admin Login");
				System.out.println("Enter the Username");
				String username=sc.next();
				System.out.println("Enter the password");
				String pass=sc.next();
				l.setUsername(username);
				l.setPassword(pass);
				if(ldao.checkCredential(l))
				{
					System.out.println("Login Succesfull");
				do
				{
				    System.out.println("1.ADD PRODUCT \n 2.DISPLAY PRODUCT \n 3.Update Product \n 4.Delete Product \n 5.Logout");
				    option=sc.nextInt();
				    switch(option)
					{
					case 1:
						System.out.println("Add Product");
						System.out.println("Enter the productId");
						int  productId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the productName");
						String productName = sc.next();
						System.out.println("Enter the minimum sell quantity");
						 int minSellQuantity = sc.nextInt();
						System.out.println("Enter the price");
						 int price = sc.nextInt();
						System.out.println("Enter the quantity");
						int quantity = sc.nextInt();
						p.setProductId(productId);
						p.setProductName(productName);
						p.setMinSellQuantity(minSellQuantity);
						p.setPrice(price);
						p.setQuantity(quantity);
						pdao.addProduct(p);
						System.out.println("The products Added Successfully");
						break;
						case 2:
							System.out.println("These are the products");
							pdao.display();
						    break;
						case 3:
							System.out.println("The updated products are");
							System.out.println("Enter the productId");
							int  productId1 = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String productName1 = sc.next();
							System.out.println("Enter the minimum sell quantity");
							 int minSellQuantity1 = sc.nextInt();
							System.out.println("Enter the price");
							 int price1= sc.nextInt();
							System.out.println("Enter the quantity");
							int quantity1 = sc.nextInt();
							p.setProductId(productId1);
							p.setProductName(productName1);
							p.setMinSellQuantity(minSellQuantity1);
							p.setPrice(price1);
							p.setQuantity(quantity1);
							pdao.updateProduct(p);
							System.out.println("The  products Updated Successfully");
							break;
						case 4:
							System.out.println("The Deleted products are");
							System.out.println("Enter the  product Id");
							int  productId3 = sc.nextInt();
							p.setProductId(productId3);
							pdao.deleteProduct(p);
							System.out.println("The  products Deleted Successfully");
						case 5:
							System.out.println("Logout");
						break;
					}
				}while(option!=3);
				}
				else
					System.out.println("Incorrect Username/Password");
				break;
			case 2:
				System.out.println("Agent Login");
				System.out.println("Enter the Username");
				String username1=sc.next();
				System.out.println("Enter the password");
				String pass1=sc.next();
				l.setUsername(username1);
				l.setPassword(pass1);
				if(((LoginDAO) ldao).checkCredential(l))
					{
						System.out.println("Login Succesfull");
					int option2;
					 do {
			        		System.out.println("1.Display Product \n2.Logout");
			        		System.out.println("Enter your option");
			        		
			        		option2=sc.nextInt();
			        		switch(option2) {
			        		case 1: 
			        			System.out.println("Products are");
			        			pdao.display();
			        			break;
			        		case 2:
			        			System.out.println("Logout");
			        			break;
			        		}
			        	 }while(option2!=2);
			        	
				}
				else
					System.out.println("Incorrect Username/Password");
					break;
					
			}
		 }while(choice!=3);
            sc.close();
		}
}
