import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editInfoPat extends JFrame{
	private JTextField slot;
	
	
	public void guiHider(){
		setVisible(false);
		
	}
	public editInfoPat(String name,String address, String contact ) {
		
		
		setTitle("edit info pat");
		setSize(250,250);
		getContentPane().setLayout(null);
		
		JLabel lblTiming = new JLabel("Free Slot");
		lblTiming.setBounds(21, 69, 46, 14);
		getContentPane().add(lblTiming);
		
		slot = new JTextField();
		slot.setBounds(104, 66, 86, 20);
		getContentPane().add(slot);
		slot.setText(contact);
		slot.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String slot1 = slot.getText();
				Database updateWrite = new Database();
				String queryupdate = "update teacher set slot=\""+slot1+"\" where name=\""+name+"\"";
				updateWrite.write(queryupdate);
				guiHider();
				
				
				
			}
		});
		btnNewButton.setBounds(115, 129, 75, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}

	public static void main(String[] args) {
		new editInfoPat("abirah ahmad","Karachi","0214536578");

	}
}
