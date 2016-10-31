import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pat extends JFrame {
	
	 private JMenuBar menuBar=null;
	private JButton btnUpdateInfo=null;
	private JLabel lblNewLabel=null;
	private JTable table;
	private JTextField textField;
	
	public void guiHider (){
		setVisible(false);
	}
	
	public Pat(String name, String load, String Slot) {
		
		
		setTitle("Pat");
		Object[] cols = {"Uob","Name","Year","Email","Address","Phone","Dep.","Pat"};
		Object[][] rows =new String[10][8];
		Database db = new Database();
		String queryStudent="select * from student where pat=\""+name+"\"";
		db.connection(queryStudent);
		
			int databaseCount=0;
			try {
				while(db.rs.next()){
					
					
					String[] data = new String[8];

					for(int i=0;i<8;i++){
						data[i]=db.rs.getString((i+1));
						
					}
					databaseCount++;
					for(int i=databaseCount;i<8;i++){
						
						for(int j=0;j<8;j++){
							rows[i][j]=data[j];
							//System.out.print(rows[i][j] + " :");
							
						}
						break;
					}

				}
			} catch (SQLException e) {
				
				System.out.println("loop");
				
			}
		

		
			JTable table = new JTable(rows,cols);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(227, 89, 247, 227);
			getContentPane().add(scrollPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		getContentPane().setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 504, 21);
		getContentPane().add(menuBar_1);
		
		JButton btnEditInfo = new JButton("Edit Info");
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new editInfoPat(name,load,Slot);
			}
		});
		menuBar_1.add(btnEditInfo);
		
		table = new JTable();
		table.setBounds(300, 299, 121, -234);
		getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(40, 32, 102, 126);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(40, 190, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblLoad = new JLabel("Load");
		lblLoad.setBounds(40, 220, 46, 14);
		getContentPane().add(lblLoad);
		
		JLabel lblTiming = new JLabel("Free Slot");
		lblTiming.setBounds(40, 252, 56, 14);
		getContentPane().add(lblTiming);
		
		JLabel lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setBounds(108, 190, 102, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(load);
		lblNewLabel_2.setBounds(106, 220, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Slot);
		lblNewLabel_3.setBounds(106, 252, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				guiHider();
			}
		});
		btnLogout.setBounds(395, 418, 79, 23);
		getContentPane().add(btnLogout);
		
		
		
	
		
		
				

		
		setSize(500,500);
		setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		//Pat a = new Pat("abirah ahmad","Partial","4");
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
