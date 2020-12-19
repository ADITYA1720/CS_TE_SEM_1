package attr;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Invoice extends Order{
	
	private int Quantity;
	private String productName;
	private double price;
	public static String[] columnNames = {"Quantity", "productName", "Price"};
	
	
	
	
	public static DefaultTableModel fetch(String qty) throws Exception {
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		
		String query = "SELECT * from Bill;";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			/*
			 * while(rs.next()) { this.productName = rs.getString("productName"); this.price
			 * = rs.getDouble("price"); this.Quantity = rs.getInt("quantity"); }
			 */
			
			
			
			
			double tot;
			while(rs.next()) {
				model.addRow(new Object[]{rs.getInt("Quantity"), rs.getString("prodName"), rs.getDouble("price")});
				
			}
			
		
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        
		return model;
	}	
	
	
	
	
	
	public static double TotalBill() {
		String query = "SELECT sum(Quantity*price) as total_price from Bill;";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
		
		double Pr;
		 int Qt;
		 double Total=0;
		 double sum=0.0;
		
		
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
			Total = Double.parseDouble(rs.getString("total_price"));
			}
			
        }
			/*
			 * int size =0; if (rs != null) { rs.last(); // moves cursor to the last row
			 * size = rs.getRow(); // get row id }
			 */
			
			
			/*
			 * for(int i=0;i<size;i++) { while(rs.next()) { Qt = rs.getInt("Quantity"); Pr =
			 * rs.getDouble("price"); sum = Pr * Qt;
			 * 
			 * 
			 * for(int j=0;i<size;i++) {
			 * 
			 * Total = Total+sum; } System.out.println("sum : "+sum); } }
			 */
	
			
			/*
			 * while(rs.next()) { // model.addRow(new Object[]{rs.getInt("Quantity"),
			 * rs.getString("prodName"), rs.getDouble("price")});
			 * 
			 * double sum=0.0; Qt = rs.getInt("Quantity"); Pr = rs.getDouble("price");
			 * while(rs.next()){ sum = Pr * Qt; } Total = Total+sum; }
			 */
			 
			
			
		
        
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
        
        System.out.println("Total : "+Total);
        
        return Total;
        

	
	
	
}





public static void DeleteBill() {
	String query = "DELETE from Bill;";     
    Connection con = null;
    Statement st = null;
	ResultSet rs = null;
	System.out.println(query);
	
	double Pr;
	 int Qt;
	 double Total=0;
	 double sum=0.0;
	
	
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
		// TODO: handle exception
    	e.printStackTrace();
	}
    
    System.out.println("Bill deleted");
   
    

}


}





