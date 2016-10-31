import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangeOfPat extends JFrame {
	private JTextField patName;
	private JTextField reason;
	public void guiHider(){
		setVisible(false);
	}
	public ChangeOfPat(String patname, String uob) {
		
		
		setSize(250, 250);
		getContentPane().setLayout(null);
		
		JLabel lblYourPatsIs = new JLabel("Your Pat is "+patname+"");
		lblYourPatsIs.setBounds(41, 11, 167, 29);
		getContentPane().add(lblYourPatsIs);
		
		JLabel lblNewPatName = new JLabel("New Pat Name");
		lblNewPatName.setBounds(10, 64, 89, 14);
		getContentPane().add(lblNewPatName);
		
		patName= new JTextField();
		patName.setBounds(109, 64, 99, 20);
		getContentPane().add(patName);
		patName.setColumns(10);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.setBounds(119, 181, 93, 23);
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pname=patName.getText();
				String reason1=reason.getText();
				int uobQ=Integer.parseInt(uob);
				
				String query="insert into request values("+uobQ+",\""+pname+"\",\""+reason1+"\",NULL)";
				Database db = new Database();
				db.write(query);
				guiHider();
				
				
			}
		});
		getContentPane().add(btnRequest);
		
		JLabel lblReason = new JLabel("Reason ");
		lblReason.setBounds(20, 95, 46, 14);
		getContentPane().add(lblReason);
		
		reason = new JTextField();
		reason.setBounds(109, 95, 103, 75);
		getContentPane().add(reason);
		reason.setColumns(10);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeOfPat("Sarmad Ali","1234");

	}
}
