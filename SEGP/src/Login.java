import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.Font;

import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {
	public String UserName;
	public String Password;

	private JTextField jt1 = null;
	private JLabel labelname = null;
	private JLabel labelpassword = null;
	private JButton button = null;
	private JPasswordField passwordField;

	public Login(){
		setTitle("Login");

		jt1 = new JTextField(8);
		jt1.setBounds(183, 115, 134, 20);
		button = new JButton("Login");
		button.setBounds(240, 218, 72, 23);
		labelname = new JLabel("User Name");
		labelname.setBounds(78, 118, 72, 14);
		labelpassword = new JLabel("Password");
		labelpassword.setBounds(78, 172, 72, 14);
		button.addActionListener(this);
		getContentPane().setLayout(null);

		getContentPane().add(labelname);
		getContentPane().add(jt1);
		getContentPane().add(labelpassword);
		getContentPane().add(button);

		passwordField = new JPasswordField();
		passwordField.setBounds(183, 169, 134, 20);
		getContentPane().add(passwordField);
		
		JLabel soft = new JLabel("Personal Academic Tutoring System");
	    soft.setForeground(Color.BLUE);
		
		soft.setBounds(140, 39, 252, 14);
		getContentPane().add(soft);
		setSize(500, 500);
		setVisible(true);
	}

	public  void HideGui(){
		setVisible(false);
	}
	




	public static void main(String[] args) {
		Login l =new Login();

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = jt1.getText();
		String pass = passwordField.getText();
		//System.out.println(pass);
		String queryVerify = "select * from login where username=\""+name+"\" and password=\""+pass+"\"";
		Database verify = new Database();
		verify.connection(queryVerify);
		try {
			if(verify.rs.next())
			{
				System.out.println("Enter In Next");
				String personName = verify.rs.getString(5);
				System.out.println(personName);

				if(personName.equals("student")){
					System.out.println("student ha");
					String uob = verify.rs.getString(1);
					System.out.println(uob);
					String student= "select * from student where uob=\""+uob+"\"";
					verify.connection(student);
					if(verify.rs.next()){
						System.out.println("population");
						String name1 = verify.rs.getString(2);
						String uob1 = verify.rs.getString(1);
						String year = verify.rs.getString(3);
						String department = verify.rs.getString(8);
						String pat = verify.rs.getString(7);
						String contact = verify.rs.getString(6);
						String address = verify.rs.getString(5);

						String timing="select * from teacher where student1=\""+name1+"\" or student2=\""+name1+"\" or student3=\""+name1+"\" or student4=\""+name1+"\" or student5=\""+name1+"\" or student6=\""+name1+"\" or student7=\""+name1+"\" or student8=\""+name1+"\"";
						verify.connection(timing);
						if(verify.rs.next()){
							System.out.println("gui");
							String guiTiming = verify.rs.getString(5);
							Student s =  new Student(name1,uob1,year,department,pat,guiTiming,contact,address);
							HideGui();

						}
					}

				}


				if(personName.equals("teacher")){
					String no = verify.rs.getString(2);
					String pat= "select * from teacher where no=\""+no+"\"";
					verify.connection(pat);
					if(verify.rs.next()){
						String name1 = verify.rs.getString(2);
						String load = verify.rs.getString(4);
						String slot = verify.rs.getString(5);
						Pat p =  new Pat(name1,load,slot);
						HideGui();


					}

				}
				if(personName.equals("sso")){
					new sso();
					HideGui();
				}
				if(personName.equals("registrar")){
					new Registrar();
					HideGui();
				}
				








			}
			else
				JOptionPane.showMessageDialog(null, "Username/Password Wrong");
			//System.out.println(verify.rs.getString(9));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
}
