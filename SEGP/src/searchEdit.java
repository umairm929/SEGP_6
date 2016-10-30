import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class searchEdit extends JFrame {
	private JTextField uob;
   public searchEdit(){
	   setTitle("edit");
	   setSize(300, 80);
	   getContentPane().setLayout(null);
	   
	   JLabel lblEnterUob = new JLabel("Enter Uob");
	   lblEnterUob.setBounds(10, 11, 74, 14);
	   getContentPane().add(lblEnterUob);
	   
	   uob = new JTextField();
	   uob.setBounds(94, 8, 86, 20);
	   getContentPane().add(uob);
	   uob.setColumns(10);
	   
	   JButton btnNext = new JButton("Search");
	   btnNext.setBounds(190, 7, 84, 23);
	   btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uob1 =uob.getText();
				int passUob=Integer.parseInt(uob1);
				String queryStudent="select * from student where uob="+uob1+"";
				Database db = new Database();
				db.connection(queryStudent);
				try {
					if(db.rs.next()){
						new editInfoStudent(passUob);
						guiHider();
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Student Doesn't Exist");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
	   getContentPane().add(btnNext);
	   
	   setVisible(true);
   }
   
   
   public void guiHider(){
	   setVisible(false);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new searchEdit();
	}
}
