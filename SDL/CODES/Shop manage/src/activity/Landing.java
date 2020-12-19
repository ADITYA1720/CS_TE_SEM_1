
package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

public class Landing extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonExit, adminButton, customerButton, buttonSignup;
	private JLabel title, header, AdminLabel, CustomerLabel;
//	private JTextField usernameTF;
//	private JPasswordField passwordF;
	
	Icon icon1 = new ImageIcon("C:\\Users\\ritzm\\eclipse-workspace\\Shop manage\\src\\activity\\admin_img.jpg");
	Icon icon2 = new ImageIcon("C:\\Users\\ritzm\\eclipse-workspace\\Shop manage\\src\\activity\\customer_img.jpg");
	
//  JButton button7 = new JButton(icon);
	
	public Landing() {
		super("Login");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Shop Management System");
		title.setBounds(30, 40, 555, 75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonExit.setFont(Theme.FONT_BUTTON);
		buttonExit.setBackground(Color.WHITE);
		buttonExit.setForeground(Theme.COLOR_TITLE);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
		
		buttonSignup = new JButton("Sign up");
		buttonSignup.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSignup.setFont(Theme.FONT_BUTTON);
		buttonSignup.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSignup.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSignup.addActionListener(this);
		panel.add(buttonSignup);
		
		AdminLabel = new JLabel("Adminstrator");
		AdminLabel.setBounds(250, 360, 120, 30);
		AdminLabel.setFont(Theme.FONT_REGULAR);
		panel.add(AdminLabel);
		
		/*
		 * usernameTF = new JTextField(); usernameTF.setBounds(330, 220, 220, 30);
		 * usernameTF.setFont(Theme.FONT_INPUT); panel.add(usernameTF);
		 */
		
		CustomerLabel = new JLabel("Customer");
		CustomerLabel.setBounds(450, 360, 120, 30);
		CustomerLabel.setFont(Theme.FONT_REGULAR);
		panel.add(CustomerLabel);
		
		/*
		 * passwordF = new JPasswordField(); passwordF.setBounds(330, 280, 220, 30);
		 * passwordF.setFont(Theme.FONT_INPUT); panel.add(passwordF);
		 */
		
		adminButton = new JButton(icon1);
		adminButton.setBounds(250, 220, 100, 136);
//		adminButton.setFont(Theme.FONT_BUTTON);
//		adminButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
//		adminButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		adminButton.addActionListener(this);
		panel.add(adminButton);
		
		customerButton = new JButton(icon2);
		customerButton.setBounds(450, 220, 100, 140);
//		customerButton.setFont(Theme.FONT_BUTTON);
//		customerButton.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
//		customerButton.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		customerButton.addActionListener(this);
		panel.add(customerButton);
		
		
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonExit))
			System.exit(0);
		else if (ae.getSource().equals(buttonSignup)) {
			this.setVisible(false);
			new SignupActivity().setVisible(true);
		}
		
		else if(ae.getSource().equals(adminButton)) {
//			LoginActivity la = new LoginActivity();
//			la.setVisible(true);
			
			this.setVisible(false);
			new LoginActivity(1).setVisible(true);
		}
		
		else if(ae.getSource().equals(customerButton)) {
			this.setVisible(false);
			new LoginActivity(2).setVisible(true);			
		}
		
		
		/*else if (ae.getSource().equals(adminButton)) {
			int status = User.checkStatus(usernameTF.getText(), passwordF.getText());
			if (status == 0) {
				EmployeeActivity ea = new EmployeeActivity(usernameTF.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}
			else if (status == 1) {
				CustomerActivity ca = new CustomerActivity(usernameTF.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}*/
			
			
			
			else {
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
//		else {}
//	}
}