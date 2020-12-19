package activity;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import attr.*;

public class InvoiceActivity extends JFrame implements ActionListener{
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JTable table;
	private JButton buttonDone,buttonBack;
	private JLabel title,header, Total,Amount;
	String userId;
	
	public String TOT = Double.toString(Invoice.TotalBill());
	
	
	
	public InvoiceActivity(JFrame prev, Customer customer) throws Exception {
		super("Invoice");
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.customer = customer;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Invoice");
		title.setBounds(30, 40, 300,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		
		Total = new JLabel("Total Amount : ");
		Total.setBounds(30, 480, 450,80);
		Total.setFont(Theme.FONT_TITLE);
		Total.setForeground(Theme.COLOR_TITLE);
		panel.add(Total);
		
		Amount = new JLabel();
		Amount.setText(TOT);
		Amount.setBounds(355, 480, 450,80);
		Amount.setFont(Theme.FONT_TITLE);
		Amount.setForeground(Theme.COLOR_TITLE);
		panel.add(Amount);
		
		buttonDone = new JButton("Done");
		buttonDone.setBounds(Theme.GUI_WIDTH-140, 510, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDone.setFont(Theme.FONT_BUTTON);
		buttonDone.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDone.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDone.addActionListener(this);
		panel.add(buttonDone);
		
		
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		

		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Invoice.columnNames);
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
		
		String qty = null;
		table.setModel(Invoice.fetch(qty));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
		
		Invoice.TotalBill();
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonDone)) {
				this.setVisible(false);
				//activity.setVisible(true);
				new CustomerActivity("c001").setVisible(true);
				Invoice.DeleteBill();
		}
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
