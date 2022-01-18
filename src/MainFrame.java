import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static LoginFrame loginframe;
	public static AddRecordFrame addrecordframe;
	public static UpdateDataFrame updateframe;
	public static DeleteDataFrame deletedata;
	public static JTable tblStudentRecord;
	public static JButton btnLogin;
	public static JButton btnAddRecord;
	public static JButton btnUpdate;
	public static JButton btnDelete;
	public static JButton btnLogout;
	private JLabel lblNewLabel;

	String[] columns = {"ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "DATE OF BIRTH", "AGE", "COLLEGE", "PROGRAM"};
	public static DefaultTableModel studentInfo = new DefaultTableModel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					MainFrame frame = new MainFrame();
					//this code will maximized the frame
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
	public MainFrame() {
		setTitle("STUDENT RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instantiate the LoginFrame as an Object to call it by using btnLogin
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				
		
				
				
			}
		});
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(202, 208, 139, 34);
		contentPane.add(btnLogin);
		
		btnAddRecord = new JButton("ADD RECORD");
		btnAddRecord.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddRecord.setForeground(new Color(0, 0, 0));
		btnAddRecord.setEnabled(false);
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRecordFrame addrecord = new AddRecordFrame();
				addrecord.setVisible(true);
			}
		});
		btnAddRecord.setBackground(Color.CYAN);
		btnAddRecord.setBounds(202, 253, 139, 34);
		contentPane.add(btnAddRecord);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(studentInfo.getRowCount() > 0 ) {
					UpdateDataFrame updateframe = new UpdateDataFrame();
					updateframe.setVisible(true);
					
				}else {
				
					JOptionPane.showMessageDialog(contentPane, "No existing data!");
				}
			}
		});
		btnUpdate.setBackground(Color.ORANGE);
		btnUpdate.setBounds(202, 298, 139, 34);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(studentInfo.getRowCount() > 0 ) {
					DeleteDataFrame deletedata = new DeleteDataFrame();
					deletedata.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "No existing data!");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setEnabled(false);
		btnDelete.setBackground(Color.YELLOW);
		btnDelete.setBounds(202, 343, 139, 34);
		contentPane.add(btnDelete);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to logout?", "Message", JOptionPane.YES_NO_OPTION);
				
				if(response == JOptionPane.YES_OPTION) {

					dispose();
					
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(202, 481, 139, 34);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 190, 812, 331);
		contentPane.add(scrollPane);
		
		tblStudentRecord = new JTable(studentInfo);
		tblStudentRecord.setEnabled(false);
		tblStudentRecord.setBackground(Color.WHITE);
		scrollPane.setViewportView(tblStudentRecord);
		studentInfo.setColumnIdentifiers(columns);
		
		lblNewLabel = new JLabel("STUDENT RECORD");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Permanent Marker", Font.PLAIN, 50));
		lblNewLabel.setBounds(468, 36, 511, 54);
		contentPane.add(lblNewLabel);
		
	}
}
