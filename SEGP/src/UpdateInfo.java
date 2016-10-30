import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateInfo extends JFrame {
	private JTextField tfAddress;
	private JTextField tfContact;
	public void guiHider(){
		setVisible(false);
	}
	public UpdateInfo(String address, String contact, String name) {
		
		setSize(250, 250);
		getContentPane().setLayout(null);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(111, 32, 86, 20);
		getContentPane().add(tfAddress);
		tfAddress.setText(address);
		tfAddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 35, 66, 14);
		getContentPane().add(lblAddress);
		
		tfContact = new JTextField();
		tfContact.setBounds(111, 63, 86, 20);
		getContentPane().add(tfContact);
		tfContact.setText(contact);
		tfContact.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(22, 66, 66, 14);
		getContentPane().add(lblContact);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = tfAddress.getText();
				String s2 = tfContact.getText();
				Database updateWrite = new Database();
				String queryupdate = "update student set address=\""+city+"\" , phone=\""+s2+"\" where name=\""+name+"\"";
				updateWrite.write(queryupdate);
				guiHider();
				
			}
		});
		btnSave.setBounds(131, 134, 66, 23);
		getContentPane().add(btnSave);
		setVisible(true);
	}

	public static void main(String[] args) {
		new UpdateInfo("Faisalabaad","0345123456","faisal");

	}

}
