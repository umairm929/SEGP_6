import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editInfoPat extends JFrame{
	private JTextField load;
	private JTextField slot;
	
	
	public void guiHider(){
		setVisible(false);
		
	}
	public editInfoPat(String name,String address, String contact ) {
		
		
		
		setSize(250,250);
		getContentPane().setLayout(null);
		
		JLabel lblLoad = new JLabel("Load");
		lblLoad.setBounds(21, 34, 46, 14);
		getContentPane().add(lblLoad);
		
		load = new JTextField();
		load.setBounds(104, 31, 86, 20);
		getContentPane().add(load);
		load.setColumns(10);
		load.setText(address);
		
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
				String load1 = load.getText();
				String slot1 = slot.getText();
				Database updateWrite = new Database();
				String queryupdate = "update teacher set busy=\""+load1+"\" , slot=\""+slot1+"\" where name=\""+name+"\"";
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
