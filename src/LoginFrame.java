import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JButton btnLogin;
	private JButton btnCancel;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("LOGIN FORM");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(131, 30, 265, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(47, 38, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(47, 98, 74, 14);
		contentPane.add(lblPassword);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//declaring variable for the user name and password
				//to call them easy 
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
			//if the user name entered is admin and the password entered is equals to admin
			//the message dialog will be login successfully
			if(username.equals("admin") && password.equals("admin")) {
			
				JOptionPane.showMessageDialog(contentPane, "Login Successfully!");
				
				//after the user login it will dispose
				dispose();
				MainFrame.btnAddRecord.setEnabled(true);
				MainFrame.btnUpdate.setEnabled(true);
				MainFrame.btnDelete.setEnabled(true);
				MainFrame.btnLogin.setEnabled(false);
			}
			
			//if not then the dialog will be failed
			else {
				
				JOptionPane.showMessageDialog(contentPane, "Login Failed!");
			}
			}
		});
		btnLogin.setBounds(146, 161, 102, 38);
		contentPane.add(btnLogin);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to cancel?", "Message", JOptionPane.YES_NO_OPTION);
				
				if(response == JOptionPane.YES_OPTION) {
					
					txtUsername.setText(null);
					txtPassword.setText(null);
					
					dispose();
					
				}
			}
		});
		btnCancel.setBounds(275, 161, 102, 38);
		contentPane.add(btnCancel);
		
		JCheckBox chckboxShowPass = new JCheckBox("SHOW PASSWORD");
		chckboxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckboxShowPass.isSelected() == true) {
					txtPassword.setEchoChar((char)0);
				}
				else {
					txtPassword.setEchoChar('*');
				}}
		});
		chckboxShowPass.setBounds(201, 131, 137, 23);
		contentPane.add(chckboxShowPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(131, 92, 265, 32);
		contentPane.add(txtPassword);
	}
}
