import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateDataFrame extends JFrame {

	private JPanel contentPane;
	private JTable tblUpdate;
	public static  JTextField txtFirstName;
	public static  JComboBox<Object> cboProgram;
	public static  JComboBox<Object> cboCollege;
	public static  JDateChooser dateChooser;
	public static  JTextField txtMiddleName;
	public static  JTextField txtLastName;

	String[] columns = {"ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "DATE OF BIRTH", "AGE", "COLLEGE", "PROGRAM"};
	String[] college = {"CEAS", "CBAA", "CCE", "CON"}; 
	String[] ceas = {"BSEED", "BSSED", "BSPSYC"};
	public static int id = 1;
	public boolean isNew = false, isUpdate = false, isDelete = false;
	public static DefaultTableModel updatedInfo = new DefaultTableModel();
	private JButton btnSave;
	private JLabel lblId;
	private JTextField txtSearchField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDataFrame frame = new UpdateDataFrame();
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
	public UpdateDataFrame() {
		setTitle("UPDATE RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblId = new JLabel("1");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(117, 101, 46, 14);
		contentPane.add(lblId);
		
		JLabel LabelId = new JLabel("ID:");
		LabelId.setForeground(Color.WHITE);
		LabelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelId.setBounds(81, 104, 24, 14);
		contentPane.add(LabelId);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(115, 166, 205, 29);
		contentPane.add(txtFirstName);
		
		JLabel lblFirstname = new JLabel("FIRSTNAME:");
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(30, 174, 75, 14);
		contentPane.add(lblFirstname);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(115, 126, 205, 29);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel = new JLabel("LASTNAME:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 134, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMiddleName.setBounds(17, 216, 82, 14);
		contentPane.add(lblMiddleName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(115, 210, 205, 29);
		contentPane.add(txtMiddleName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 250, 205, 29);
		contentPane.add(dateChooser);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 259, 104, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblCollege = new JLabel("COLLEGE:");
		lblCollege.setForeground(Color.WHITE);
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(44, 299, 61, 14);
		contentPane.add(lblCollege);
		
		cboCollege = new JComboBox<Object>(college);
		cboCollege.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				program();
			}
		});
		cboCollege.setBounds(115, 290, 205, 29);
		contentPane.add(cboCollege);
		
		cboProgram = new JComboBox<Object>(ceas);
		cboProgram.setBounds(115, 339, 205, 29);
		contentPane.add(cboProgram);
		
		JLabel lblProgram = new JLabel("PROGRAM:");
		lblProgram.setForeground(Color.WHITE);
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProgram.setBounds(44, 348, 61, 14);
		contentPane.add(lblProgram);
		
		JScrollPane updatescrollPane = new JScrollPane();
		updatescrollPane.setBounds(330, 114, 708, 260);
		contentPane.add(updatescrollPane);
		
		tblUpdate = new JTable(updatedInfo);
		tblUpdate.setEnabled(false);
		tblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(isUpdate == true) {
					
					int selectedRow = tblUpdate.getSelectedRow();
					
					//getting and setting the value to their specific fields 
					lblId.setText(updatedInfo.getValueAt(selectedRow, 0).toString());
					txtLastName.setText(updatedInfo.getValueAt(selectedRow, 1).toString());
					txtFirstName.setText(updatedInfo.getValueAt(selectedRow, 2).toString());
					txtMiddleName.setText(updatedInfo.getValueAt(selectedRow, 3).toString());
					
					//using try catch to to update the dateChooser 
					try {
						Date date = new SimpleDateFormat("MM/dd/yyyy").parse((String)updatedInfo.getValueAt(selectedRow, 4));
						dateChooser.setDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cboCollege.setSelectedItem(updatedInfo.getValueAt(selectedRow, 6).toString());
					cboProgram.setSelectedItem(updatedInfo.getValueAt(selectedRow, 7).toString());
					
				}
			}
		});
		updatescrollPane.setViewportView(tblUpdate);
		updatedInfo.setColumnIdentifiers(columns);
		
		btnSave = new JButton("SAVE");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveData();
				dispose();
			}
		});
		btnSave.setBounds(44, 408, 104, 29);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateData();

			}
		});
		btnUpdate.setBounds(168, 408, 104, 29);
		contentPane.add(btnUpdate);
		
		JButton btnMain = new JButton("MAIN");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					dispose();
					JOptionPane.showMessageDialog(contentPane, "Update operation failed!");
			}
		});
		btnMain.setBounds(295, 408, 104, 29);
		contentPane.add(btnMain);
		
		txtSearchField = new JTextField();
		txtSearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String search = txtSearchField.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(updatedInfo);
				tblUpdate.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtSearchField.setBounds(408, 82, 158, 20);
		contentPane.add(txtSearchField);
		
		JLabel lblSearch = new JLabel("SEARCH:");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(338, 84, 75, 14);
		contentPane.add(lblSearch);
		
		JLabel lblNewLabel_1 = new JLabel("UPDATE STUDENT RECORD");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Permanent Marker", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(372, 24, 327, 25);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
	}
	
	private void program() {
		

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
	
	private void updateData() {

				isUpdate = true;
				tblUpdate.setEnabled(true);
				
				
				int selectedRow = tblUpdate.getSelectedRow();	
				
				if(selectedRow >= 0) {
				
					int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure to update the selected row?");
				
					if(response == JOptionPane.YES_OPTION) {
						
						//setting and getting the value in their specific fields
						updatedInfo.setValueAt(txtLastName.getText().toUpperCase(), selectedRow, 1);
						updatedInfo.setValueAt(txtFirstName.getText().toUpperCase(), selectedRow, 2);
						updatedInfo.setValueAt(txtMiddleName.getText().toUpperCase(), selectedRow, 3);
						DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
						updatedInfo.setValueAt(format.format(dateChooser.getDate()), selectedRow, 4);
						Date dob = dateChooser.getDate();
						
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
						updatedInfo.setValueAt(age, selectedRow, 5);
						updatedInfo.setValueAt(cboCollege.getSelectedItem(), selectedRow, 6);
						updatedInfo.setValueAt(cboProgram.getSelectedItem(), selectedRow, 7);
						
						JOptionPane.showMessageDialog(contentPane, "Selected record successfully updated!");
						btnSave.setEnabled(true);
						tblUpdate.setEnabled(false);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Update operation failed!");
					}
				}
	}
	
	private void saveData() {
		
				int selectedRow = tblUpdate.getSelectedRow();
				
				MainFrame.studentInfo.setValueAt(txtLastName.getText().toUpperCase(), selectedRow, 1);
				MainFrame.studentInfo.setValueAt(txtFirstName.getText().toUpperCase(), selectedRow, 2);
				MainFrame.studentInfo.setValueAt(txtMiddleName.getText().toUpperCase(), selectedRow, 3);
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				MainFrame.studentInfo.setValueAt(format.format(dateChooser.getDate()), selectedRow, 4);
				Date dob = dateChooser.getDate();
				
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
				
				MainFrame.studentInfo.setValueAt(age, selectedRow, 5);
				MainFrame.studentInfo.setValueAt(cboCollege.getSelectedItem(), selectedRow, 6);
				MainFrame.studentInfo.setValueAt(cboProgram.getSelectedItem(), selectedRow, 7);
			
				
				
				
			}
	}
	

