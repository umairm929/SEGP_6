import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangeOfPat extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public ChangeOfPat(String patname) {
		
		
		setSize(250, 250);
		getContentPane().setLayout(null);
		
		JLabel lblYourPatsIs = new JLabel("Your Pat is "+patname+"");
		lblYourPatsIs.setBounds(41, 11, 167, 29);
		getContentPane().add(lblYourPatsIs);
		
		JLabel lblNewPatName = new JLabel("New Pat Name");
		lblNewPatName.setBounds(10, 64, 89, 14);
		getContentPane().add(lblNewPatName);
		
		textField = new JTextField();
		textField.setBounds(109, 64, 99, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.setBounds(119, 181, 93, 23);
		getContentPane().add(btnRequest);
		
		JLabel lblReason = new JLabel("Reason ");
		lblReason.setBounds(20, 95, 46, 14);
		getContentPane().add(lblReason);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 95, 103, 75);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeOfPat("Sarmad Ali");

	}
}
