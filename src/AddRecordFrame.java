import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddRecordFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame mainframe;
	public static UpdateDataFrame updatedata;
	private JComboBox cboCollege;
	private JDateChooser dateChooser;
	private JComboBox cboProgram;
	private JTextField txtMiddleName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JLabel lblId;
	
	
	String[] college = {"CEAS", "CBAA", "CCE", "CON"}; 
	String[] ceas = {"BSEED", "BSSED", "BSPSYC"};
	public static int id = 1;
	public boolean isNew = false, isUpdate = false, isDelete = false;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecordFrame frame = new AddRecordFrame();
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
	public AddRecordFrame() {
		setTitle("ADD RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(115, 105, 205, 29);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LASTNAME:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 113, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel LabelId = new JLabel("ID:");
		LabelId.setForeground(new Color(255, 255, 255));
		LabelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelId.setBounds(81, 83, 24, 14);
		contentPane.add(LabelId);
	
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(115, 145, 205, 29);
		contentPane.add(txtFirstName);
		
		JLabel lblFirstname = new JLabel("FIRSTNAME:");
		lblFirstname.setForeground(new Color(255, 255, 255));
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(30, 153, 75, 14);
		contentPane.add(lblFirstname);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(115, 189, 205, 29);
		contentPane.add(txtMiddleName);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setForeground(new Color(255, 255, 255));
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMiddleName.setBounds(17, 195, 82, 14);
		contentPane.add(lblMiddleName);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setForeground(new Color(255, 255, 255));
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 238, 104, 14);
		contentPane.add(lblDateOfBirth);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 229, 205, 29);
		contentPane.add(dateChooser);
		
		JLabel lblCollege = new JLabel("COLLEGE:");
		lblCollege.setForeground(new Color(255, 255, 255));
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(44, 278, 61, 14);
		contentPane.add(lblCollege);
		
		cboCollege = new JComboBox<Object>(college);
		cboCollege.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				program();
			}
		});
		cboCollege.setBounds(115, 269, 205, 29);
		contentPane.add(cboCollege);
		
		cboProgram = new JComboBox<Object>(ceas);
		cboProgram.setBounds(115, 318, 205, 29);
		contentPane.add(cboProgram);
		
		JLabel lblProgram = new JLabel("PROGRAM:");
		lblProgram.setForeground(new Color(255, 255, 255));
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProgram.setBounds(44, 327, 61, 14);
		contentPane.add(lblProgram);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addData();
			}
		});
		btnAdd.setBounds(64, 376, 89, 29);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to cancel?", "Message", JOptionPane.YES_NO_OPTION);
				
				if(response == JOptionPane.YES_OPTION) {
					
					dispose();
			}}
		});
		btnCancel.setBounds(200, 376, 89, 29);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENT RECORD");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Permanent Marker", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(63, 26, 239, 46);
		contentPane.add(lblNewLabel_1);
		
		lblId = new JLabel("");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setText(String.valueOf(id));
		lblId.setBounds(117, 80, 46, 14);
		contentPane.add(lblId);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
}
		
	
	private void program() {
		
		if(cboCollege.getSelectedIndex() == 0) {
			cboProgram.removeAllItems();
			cboProgram.setSelectedItem(null);
			cboProgram.addItem("BSEED");
			cboProgram.addItem("BSSED");
			cboProgram.addItem("BSPSYC");
		}
		if(cboCollege.getSelectedIndex() == 1) {
			cboProgram.removeAllItems();
			cboProgram.setSelectedItem(null);
			cboProgram.addItem("BSA");
			cboProgram.addItem("BSBA");
		}
		if(cboCollege.getSelectedIndex() == 2) {
			cboProgram.removeAllItems();
			cboProgram.setSelectedItem(null);
			cboProgram.addItem("BSCS");
			cboProgram.addItem("BSCPE");
			cboProgram.addItem("BSECE");
			cboProgram.addItem("BSIE");
			cboProgram.addItem("BSIT");
		}
		if(cboCollege.getSelectedIndex() == 3) {
			cboProgram.removeAllItems();
			cboProgram.setSelectedItem(null);
			cboProgram.addItem("BSN");
		}
		
	}
	
	
	private void addData() {
		
				if(txtLastName.getText().isEmpty() == true || txtFirstName.getText().isEmpty() == true) {
					
					JOptionPane.showMessageDialog(contentPane, "Fill out the all fields!");
				}
				
				else if(txtMiddleName.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(contentPane, "Type N/A if No Middle Name!");
				} 
				
				else if(dateChooser.getDate() == null) {
					
					JOptionPane.showMessageDialog(contentPane, "Input your Date of Birth!");
					
				}
		
				else {
					
					MainFrame mainframe = new MainFrame();
					UpdateDataFrame updatedata = new UpdateDataFrame();
					DeleteDataFrame deletedate = new DeleteDataFrame();
					
					Object[] data = new Object[8];
					
					data[0] = lblId.getText();
					data[1] = txtLastName.getText().toUpperCase();
					data[2] = txtFirstName.getText().toUpperCase();
					data[3] = txtMiddleName.getText().toUpperCase();
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date dob = dateChooser.getDate();
					data[4] = df.format(dob);
					
					//convert the date dob (date of birth) to local date dob (date of birth)
					LocalDate localDob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					int dobYr = localDob.getYear();
					int dobMonth = localDob.getMonthValue();
					int dobDay = localDob.getDayOfMonth();

					//current time
					LocalDate today = LocalDate.now();

					int age = Period.between(today, localDob).getYears();

					if (age < 0) {
						age = age * -1;
						
					}

					data[5] = age;
					data[6] = cboCollege.getSelectedItem();
					data[7] = cboProgram.getSelectedItem();
					
					UpdateDataFrame.updatedInfo.addRow(data);
					DeleteDataFrame.deletedInfo.addRow(data);
					MainFrame.studentInfo.addRow(data);
					
					id++;
					dispose();
					
		
				}
	}
}
