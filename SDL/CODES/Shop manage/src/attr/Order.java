package attr;

import java.lang.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import attr.*;
import activity.*;


public class Order extends Product {
	
	private String productId;
	private String productName;
	private double price;
	
	public Order() {}
	public Order(String productId) {
		if (!productId.isEmpty())
			this.productId = productId;
		else
			throw new IllegalArgumentException("Fill in the ID");
	}
	
	
	public static void fetch(String productId, String qty) throws Exception {
		String ProductId = productId;
		String Qty = qty;
		
		String query = "INSERT INTO Bill(Quantity,prodName,price) SELECT "+qty+", `productName`, `price` FROM `product` WHERE productId='"+ProductId+"';";     
        Connection con = null;
        Statement st = null;
//		ResultSet rs = null;
		System.out.println(query);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//getting result
			System.out.println("results received");
			
			
			
		}
		catch (Exception e) {
			  System.out.println(e);
			  }
		/*finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
		}*/
	}

}
