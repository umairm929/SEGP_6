import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class editInfoStudent extends JFrame{
	
	
	private JTextField name;
	private JTextField uobtf;
	private JTextField year;
	private JTextField email;
	private JTextField address;
	private JTextField phone;
	private JTextField dep;
	
	public void hideGui(){
		setVisible(false);
	}
	
	
	public editInfoStudent(int uob){
		
		String uob1 = null;
		String name1 = null;
		String year1=null;
		String email1=null;
		String address1=null;
		String phone1=null;
		String dep1=null;

		String queryStudent="select * from student where uob="+uob+"";
		Database db = new Database();
		db.connection(queryStudent);
		try {
			if(db.rs.next()){
				uob1=db.rs.getString(1);
				name1=db.rs.getString(2);
				year1=db.rs.getString(3);
				email1=db.rs.getString(4);
				address1=db.rs.getString(5);
				phone1=db.rs.getString(6);
				dep1=db.rs.getString(8);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 44, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblUob = new JLabel("UoB");
		lblUob.setBounds(262, 44, 46, 14);
		getContentPane().add(lblUob);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(22, 87, 46, 14);
		getContentPane().add(lblYear);
		
		JLabel lblDep = new JLabel("Dep");
		lblDep.setBounds(262, 87, 46, 14);
		getContentPane().add(lblDep);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 163, 61, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setBounds(22, 123, 46, 14);
		getContentPane().add(lblPhone);
		
		name = new JTextField();
		name.setBounds(93, 41, 115, 20);
		getContentPane().add(name);
		name.setColumns(10);
		name.setText(name1);
		
		year = new JTextField();
		year.setBounds(93, 84, 115, 20);
		getContentPane().add(year);
		year.setColumns(10);
		year.setText(year1);
		
		phone = new JTextField();
		phone.setBounds(93, 120, 171, 20);
		getContentPane().add(phone);
		phone.setColumns(10);
		phone.setText(phone1);
		
		address = new JTextField();
		address.setBounds(93, 160, 172, 20);
		getContentPane().add(address);
		address.setColumns(10);
		address.setText(address1);
		
		uobtf = new JTextField();
		uobtf.setBounds(347, 41, 86, 20);
		getContentPane().add(uobtf);
		uobtf.setColumns(10);
		uobtf.setText(uob1);
		
		dep = new JTextField();
		dep.setBounds(347, 84, 86, 20);
		getContentPane().add(dep);
		dep.setColumns(10);
		dep.setText(dep1);
		
		JButton btnAdd = new JButton("Update");
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int upuob=Integer.parseInt(uobtf.getText());
				int upyear=Integer.parseInt(year.getText());
				String upname=name.getText();
				String upemail=email.getText();
				String upaddress=address.getText();
				String upphone=phone.getText();
				String updep=dep.getText();
				
				
				
				
				String update = "update student set uob="+upuob+" , name=\""+upname+"\", year="+upyear+" , email=\""+upemail+"\",address=\""+upaddress+"\", phone=\""+upphone+"\", department=\""+updep+"\" where uob="+uob+"";
				db.write(update);
				
				hideGui();
				
				
			}
		});
		btnAdd.setBounds(397, 231, 77, 23);
		
		   getContentPane().add(btnAdd);
		   
		   JLabel lblEmail = new JLabel("E-mail");
		   lblEmail.setBounds(22, 203, 46, 14);
		   getContentPane().add(lblEmail);
		   
		   email = new JTextField();
		   email.setBounds(93, 194, 171, 20);
		   getContentPane().add(email);
		   email.setColumns(10);
		   email.setText(email1);
		
		
		
		setTitle("Update Info");
		setSize(500	, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new editInfoStudent(14031200);

	}

}
