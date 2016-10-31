import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.jdbc.DatabaseMetaData;

public class deleteStudent extends JFrame {
	private JTextField nametf;
	private JTextField uobtf;
	public void guiHider(){
		setVisible(false);
	}
	
	public deleteStudent(){

		setTitle("Delete Student");
		setSize(250,250);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 43, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("UoB");
		lblNewLabel.setBounds(23, 93, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=nametf.getText();
				String uob=uobtf.getText();
				int uobs =Integer.parseInt(uob);
				String namet=null;
				Database obj = new Database();
				String teacherquery="select * from student where name=\""+name+"\"";
				obj.connection(teacherquery);
				try {
					if(obj.rs.next()){
						namet=obj.rs.getString(7);		
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String delStudent="delete from student where uob="+uobs+"";
				obj.write(delStudent);

				String delLogin ="delete from login where uob="+uob+"";
				obj.write(delLogin);
				
				String querycol="select * from teacher where name=\""+namet+"\"";
				obj.connection(querycol);
				try {
					String arr[] = new String[13];
					if(obj.rs.next()){
						for(int i=0;i<arr.length;i++){
							arr[i]=obj.rs.getString((i+1));
						}
						
						for(int j=5;j<arr.length;j++){
							if(arr[j].equals(name)){
								String index=Integer.toString((j-4));
								String delFT="update teacher set student"+index+"=null where name=\""+namet+"\"";
								obj.write(delFT);
								break;
							}
						}
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				guiHider();
	
			}
		});
		btnDelete.setBounds(146, 146, 78, 23);
		getContentPane().add(btnDelete);
		
		nametf = new JTextField();
		nametf.setBounds(98, 40, 111, 20);
		getContentPane().add(nametf);
		nametf.setColumns(10);
		
		uobtf= new JTextField();
		uobtf.setBounds(98, 90, 111, 20);
		getContentPane().add(uobtf);
		uobtf.setColumns(10);
		setVisible(true);
	}

	public static void main(String[] args) {
		//new  deleteStudent();

	}

}
