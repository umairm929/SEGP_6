import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class addStudent extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public int returnIndex(String email){
		for(int i=0;i<email.length();i++){
			if(email.charAt(i)=='@'){
				return i;
			}
		}
		return 0;
	}
	public String userName(String user){
		int a = returnIndex(user);
		return (user.substring(0,a));
	}
	public void guiHider(){
		setVisible(false);
	}
	

	public addStudent(){



         setTitle("add Student");
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
		lblAddress.setBounds(22, 186, 61, 14);
		getContentPane().add(lblAddress);

		JLabel lblNewLabel = new JLabel("Pat Name");
		lblNewLabel.setBounds(22, 118, 61, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setBounds(22, 151, 46, 14);
		getContentPane().add(lblPhone);

		textField = new JTextField();
		textField.setBounds(93, 41, 110, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(93, 84, 110, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(93, 115, 142, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(93, 148, 142, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(92, 183, 172, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(347, 41, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(347, 84, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(397, 231, 77, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				int year=Integer.parseInt(textField_1.getText());
				String pat=textField_2.getText();
				String phone=textField_3.getText();
				String address=textField_4.getText();
				int uob=Integer.parseInt(textField_5.getText());
				String dep=textField_6.getText();
				String email=textField_7.getText();

				Database db = new Database();
				String query ="insert into student values ("+uob+",\""+name+"\","+year+",\""+email+"\",\""+address+"\",\""+phone+"\",\""+pat+"\",\""+dep+"\")";
				db.write(query);
				String userName= userName(email);
				System.out.println(userName);
				String pass="123";
				String person="student";
				String query1 ="insert into login values ("+uob+",NULL,\""+userName+"\",\""+pass+"\",\""+person+"\")";
				db.write(query1);
				addSToT(name, pat,userName);
				guiHider();
	
			}
		});
		getContentPane().add(btnAdd);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 211, 46, 14);
		getContentPane().add(lblEmail);

		textField_7 = new JTextField();
		textField_7.setBounds(93, 214, 171, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		//getContentPane().setBackground(Color.white);
		setTitle("Add Student");
		setSize(500	, 300);
		setVisible(true);
	}
	
	
	public void addSToT(String sname, String tname, String username){
		Database obj=new Database();
		obj.connection("Select * from teacher where name=\""+tname+"\";");
		
		
		try {
			while(obj.rs.next()){
				String arr[]=new String[8];
				for(int i=0;i<arr.length;i++){
					arr[i]=obj.rs.getString((i+6));
					
				}
				String load= obj.rs.getString(4);
				int count=0;
				int countStudent=0;
				for(int y=0;y<arr.length;y++){
					if(arr[y]==null){
						count++;
					}
					else
						countStudent++;
					
				}
				
				
				if(count>0 && load.equals("full")){
					int  a=0;
					for(int j=0;j<arr.length;j++){
						if(arr[j]==null){
							arr[j]=sname;
							 a = j+1;
							String index=Integer.toString(a);
							String querya="update teacher set student"+index+"=\""+sname+"\"";
							obj.write(querya);
							break;
						}
					}
				}
				else if(countStudent<3 && load.equals("partial")){
					int  a=0;
					for(int j=0;j<arr.length;j++){
						if(arr[j]==null){
							arr[j]=sname;
							 a = j+1;
							String index=Integer.toString(a);
							String querya="update teacher set student"+index+"=\""+sname+"\"";
							obj.write(querya);
							break;
						}
					}
					
				}
				else{
					obj.write("delete from student where name=\""+sname+"\";");
					obj.write("delete from login where name=\""+username+"\";");
					JOptionPane.showMessageDialog(null, "No More Student Can Be Assign To This PAT");
				}
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		addStudent s1=new addStudent();
		
		// TODO Auto-generated method stub

	}
}
