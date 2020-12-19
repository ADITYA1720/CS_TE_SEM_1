package activity;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import attr.*;

public class ViewProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck, buttonAddProduct, buttonUpdate,buttonDelete, buttonAddtoCart,buttonViewCart;
	private JLabel title, header, keywordLabel,EnterPID,EnterQty;
	JTextField keywordTF,PID,Qty;
	
	
	public ViewProductActivity(JFrame prev, Customer customer) {
		super("View Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.customer = customer;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("View Product");
		title.setBounds(30, 40, 300,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		
		

		  EnterPID = new JLabel("Enter PID: ");
		  EnterPID.setBounds(60,500,140,30);
		  EnterPID.setFont(Theme.FONT_REGULAR);
		  panel.add(EnterPID);
		  
		  PID = new JTextField();
		  PID.setBounds(160, 500, 60, 30);
		  PID.setFont(Theme.FONT_INPUT);
		  panel.add(PID);
		  
		  EnterQty = new JLabel("Enter Quantity: ");
		  EnterQty.setBounds(250,500,140,30);
		  EnterQty.setFont(Theme.FONT_REGULAR);
		  panel.add(EnterQty);
		  
		  Qty = new JTextField();
		  Qty.setBounds(400, 500, 60, 30);
		  Qty.setFont(Theme.FONT_INPUT);
		  panel.add(Qty);
		  
		  buttonAddtoCart = new JButton("Add to Cart");
		  buttonAddtoCart.setBounds(500, 500, 150,30);
		  buttonAddtoCart.setFont(Theme.FONT_BUTTON);
		  buttonAddtoCart.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		  buttonAddtoCart.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		  buttonAddtoCart.addActionListener(this);
		  panel.add(buttonAddtoCart);
		  
		  buttonViewCart = new JButton("Cart");
		  buttonViewCart.setBounds(Theme.GUI_WIDTH-140, 120, Theme.BUTTON_PRIMARY_WIDTH,30);
		  buttonViewCart.setFont(Theme.FONT_BUTTON);
		  buttonViewCart.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		  buttonViewCart.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		  buttonViewCart.addActionListener(this);
		  panel.add(buttonViewCart);
		  
		  
		  
		/*
		 * table.addMouseListener(new MouseAdapter() { public void
		 * mouseClicked(MouseEvent evt) { try { clearFields(evt); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } } });
		 */
		 
		
		
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               try {
				jTable_ClickMouseClicked(evt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Product.searchProduct("", "By Name"));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public ViewProductActivity(JFrame prev, Employee employee) {
		super("View Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("View Product");
		title.setBounds(30, 40, 300,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonAddProduct = new JButton("Add");
		buttonAddProduct.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonAddProduct.setFont(Theme.FONT_BUTTON);
		buttonAddProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddProduct.addActionListener(this);
		panel.add(buttonAddProduct);
		
		buttonUpdate = new JButton("Update");
		buttonUpdate.setBounds(Theme.GUI_WIDTH-140, 150, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonUpdate.setFont(Theme.FONT_BUTTON);
		buttonUpdate.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonUpdate.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonUpdate.addActionListener(this);
		panel.add(buttonUpdate);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(Theme.GUI_WIDTH-140, 185, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               try {
				jTable_ClickMouseClicked(evt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Product.searchProduct("", "By Name"));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Landing().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Product.searchProduct(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else if (ae.getSource().equals(buttonAddtoCart)) {
			try {
				Order.fetch(PID.getText().trim(), Qty.getText().trim());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			table.setModel(Product.searchProduct(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else if (ae.getSource().equals(buttonViewCart)) {
			try {
		
				
				this.setVisible(false);
				new InvoiceActivity(this, customer).setVisible(true);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ae.getSource().equals(buttonAddProduct)) {
			this.setVisible(false);
			new AddProductActivity(this, employee).setVisible(true);
		}
		
		else if (ae.getSource().equals(buttonUpdate)) {
			this.setVisible(false);
			new UpdateProductActivity(this, employee).setVisible(true);
		}
		
		else if (ae.getSource().equals(buttonDelete)) {
			this.setVisible(false);
			new DeleteProductActivity(this, employee).setVisible(true);
		}
		
		else {}
	}
	
	
	
	private void clearFields(MouseEvent evt) {
	    //clears/Resets textfield
	    PID.setText("");
	    Qty.setText("");
	}
	
	
	 
	
	private void jTable_ClickMouseClicked(MouseEvent evt) throws Exception {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
       
      
       
		if (customer!=null) {}
		else if (employee!=null)
			new ManageProduct(value1, this).setVisible(true);
		else {}
    }
}