import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Button;

public class Student extends JFrame{
	private JTextField textField;
	
	public void GuiHider(){
		setVisible(false);
	}
	
	
	public Student(String name, String uob,String year, String department, String patname, String guiTiming, String contact, String Address) {
		setSize(500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Update Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				new UpdateInfo(Address,contact,name);
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change of PAT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ChangeOfPat(patname);
			}
		});
		menuBar.add(btnNewButton_1);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 70, 60, 14);
		getContentPane().add(lblName);
		
		JLabel lblUob = new JLabel("UoB");
		lblUob.setBounds(10, 95, 60, 14);
		getContentPane().add(lblUob);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 120, 60, 14);
		getContentPane().add(lblYear);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(10, 145, 86, 14);
		getContentPane().add(lblDepartment);
		
		textField = new JTextField();
		textField.setBounds(324, 68, 105, 127);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPatName = new JLabel("PAT Name");
		lblPatName.setBounds(10, 285, 105, 14);
		getContentPane().add(lblPatName);
		
		Button button = new Button("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				GuiHider();
			}
		});
		button.setBounds(404, 389, 70, 22);
		getContentPane().add(button);
		
		JLabel lblPatsAvailableTimings = new JLabel("PAT's Ava. Slot");
		lblPatsAvailableTimings.setBounds(10, 317, 105, 14);
		getContentPane().add(lblPatsAvailableTimings);
		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setBounds(116, 70, 161, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(uob);
		lblNewLabel_1.setBounds(116, 95, 80, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(year);
		lblNewLabel_2.setBounds(116, 120, 80, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(department);
		lblNewLabel_3.setBounds(116, 145, 80, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(patname);
		lblNewLabel_4.setBounds(125, 285, 139, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(guiTiming);
		lblNewLabel_5.setBounds(130, 317, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblContact = new JLabel("Contact #");
		lblContact.setBounds(10, 170, 60, 14);
		getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 195, 70, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblPatDetail = new JLabel("PAT Details");
		lblPatDetail.setBounds(188, 235, 139, 14);
		getContentPane().add(lblPatDetail);
		
		JLabel lblNewLabel_6 = new JLabel(contact);
		lblNewLabel_6.setBounds(116, 170, 97, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(Address);
		lblNewLabel_7.setBounds(116, 195, 97, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setBounds(188, 27, 105, 14);
		getContentPane().add(lblStudentDetails);
		
		
		setVisible(true);
		
		
		
	}
	

	public static void main(String[] args) {
		new Student("Merry","140","3","cs","Faisal","4","03004061323","Faisalabad");

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
