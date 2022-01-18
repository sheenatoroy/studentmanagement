import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeleteDataFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTable tblDelete;
	private JDateChooser dateChooser;
	private JComboBox<Object> cboCollege;
	private JComboBox<Object> cboProgram;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnMain;

	
	
	String[] columns = {"ID", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "DATE OF BIRTH", "AGE", "COLLEGE", "PROGRAM"};
	String[] college = {"CEAS", "CBAA", "CCE", "CON"}; 
	String[] ceas = {"BSEED", "BSSED", "BSPSYC"};
	public static int id = 1;
	public boolean isNew = false, isUpdate = false, isDelete = false;
	public static DefaultTableModel deletedInfo = new DefaultTableModel();
	private JTextField txtSearchField;
	private JLabel lblSearch;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDataFrame frame = new DeleteDataFrame();
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
	public DeleteDataFrame() {
		setTitle("DELETE RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		
		JLabel lblId = new JLabel("1");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(117, 103, 46, 14);
		contentPane.add(lblId);
		
		JLabel LabelId = new JLabel("ID:");
		LabelId.setForeground(Color.WHITE);
		LabelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelId.setBounds(81, 106, 24, 14);
		contentPane.add(LabelId);
		
		JLabel lblNewLabel = new JLabel("LASTNAME:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 136, 75, 14);
		contentPane.add(lblNewLabel);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(115, 128, 205, 29);
		contentPane.add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(115, 168, 205, 29);
		contentPane.add(txtFirstName);
		
		JLabel lblFirstname = new JLabel("FIRSTNAME:");
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(30, 176, 75, 14);
		contentPane.add(lblFirstname);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMiddleName.setBounds(17, 218, 82, 14);
		contentPane.add(lblMiddleName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(115, 212, 205, 29);
		contentPane.add(txtMiddleName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 252, 205, 29);
		contentPane.add(dateChooser);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 261, 104, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblCollege = new JLabel("COLLEGE:");
		lblCollege.setForeground(Color.WHITE);
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(44, 301, 61, 14);
		contentPane.add(lblCollege);
		
		cboCollege = new JComboBox<Object>(college);
		cboCollege.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				program();
			}
		});
		cboCollege.setBounds(115, 292, 205, 29);
		contentPane.add(cboCollege);
		
		cboProgram = new JComboBox<Object>(ceas);
		cboProgram.setBounds(115, 341, 205, 29);
		contentPane.add(cboProgram);
		
		JLabel lblProgram = new JLabel("PROGRAM:");
		lblProgram.setForeground(Color.WHITE);
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProgram.setBounds(44, 350, 61, 14);
		contentPane.add(lblProgram);
		
		btnSave = new JButton("SAVE");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				saveData();
				dispose();
			}
		});
		btnSave.setBounds(44, 410, 104, 29);
		contentPane.add(btnSave);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if(deletedInfo.getRowCount() > 0){
					isDelete = true;
					tblDelete.setEnabled(true);
				}
				
				deleteData();
			}
		});
		btnDelete.setBounds(168, 410, 104, 29);
		contentPane.add(btnDelete);
		
		btnMain = new JButton("MAIN");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JOptionPane.showMessageDialog(contentPane, "Delete operation failed!");
			}
		});
		btnMain.setBounds(295, 410, 104, 29);
		contentPane.add(btnMain);
		
		JScrollPane deletescrollPane = new JScrollPane();
		deletescrollPane.setBounds(346, 110, 723, 260);
		contentPane.add(deletescrollPane);
		
		tblDelete = new JTable(deletedInfo);
		tblDelete.setEnabled(false);
		tblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(isDelete == true) {
					
					int selectedRow = tblDelete.getSelectedRow();	
					
					
					lblId.setText(deletedInfo.getValueAt(selectedRow, 0).toString());
					txtLastName.setText(deletedInfo.getValueAt(selectedRow, 1).toString());
					txtFirstName.setText(deletedInfo.getValueAt(selectedRow, 2).toString());
					txtMiddleName.setText(deletedInfo.getValueAt(selectedRow, 3).toString());
					
					try {
						Date date = new SimpleDateFormat("MM/dd/yyyy").parse((String)deletedInfo.getValueAt(selectedRow, 4));
						dateChooser.setDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cboCollege.setSelectedItem(deletedInfo.getValueAt(selectedRow, 6).toString());
					cboProgram.setSelectedItem(deletedInfo.getValueAt(selectedRow, 7).toString());
					
					
				}
			}
		});
		deletescrollPane.setViewportView(tblDelete);
		
		txtSearchField = new JTextField();
		txtSearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String search = txtSearchField.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(deletedInfo);
				tblDelete.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		txtSearchField.setBounds(419, 79, 158, 20);
		contentPane.add(txtSearchField);
		
		lblSearch = new JLabel("SEARCH:");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(349, 81, 75, 14);
		contentPane.add(lblSearch);
		
		lblNewLabel_1 = new JLabel("DELETE STUDENT RECORD");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Permanent Marker", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(392, 21, 327, 25);
		contentPane.add(lblNewLabel_1);
		deletedInfo.setColumnIdentifiers(columns);
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
	private void deleteData() {
		
		
		int selectedRow = tblDelete.getSelectedRow();
		
		if(selectedRow >= 0) {
			
			int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete the selected record?");
			
			if(response == JOptionPane.YES_OPTION) {
				
				deletedInfo.removeRow(selectedRow);
				id--;
				UpdateDataFrame.updatedInfo.removeRow(selectedRow);
				MainFrame.studentInfo.removeRow(selectedRow);
				
				JOptionPane.showMessageDialog(contentPane, "Selected record successfully deleted!");
				btnSave.setEnabled(true);
				
			}else {
				
				JOptionPane.showMessageDialog(contentPane, "Deleted operation cancelled!");
			}
		}
	}
	
	private void saveData() {
		
				
				int selectedRow = tblDelete.getSelectedRow();
				
				if(selectedRow >= 0) {
					
					int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete the selected record?");
					
					if(response == JOptionPane.YES_OPTION) {
						
						deletedInfo.removeRow(selectedRow);
						UpdateDataFrame.updatedInfo.removeRow(selectedRow);
						MainFrame.studentInfo.removeRow(selectedRow);
						
						JOptionPane.showMessageDialog(contentPane, "Selected record successfully deleted!");
						
					}else {
						
						JOptionPane.showMessageDialog(contentPane, "Deleted operation cancelled!");
					}
				}
			}

}
