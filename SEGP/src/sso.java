import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

import snippet.CreatePDF;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class sso extends JFrame {
	private JTextField textField;
	private JButton btnAllocateStudents;
	public Object[][] rows;
	public String[][] array;
	
	public sso() {
		setTitle("SSO");
		setSize(500, 500);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 484, 21);
		getContentPane().add(menuBar);

		JButton btnEditInfo = new JButton("Edit Info");
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new searchEdit();
				//GuiHider();
			}
		});
		menuBar.add(btnEditInfo);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new deleteStudent();
				//GuiHider();
			}
		});
		menuBar.add(btnDeleteStudent);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new addStudent();
				//GuiHider();
			}
		});
		menuBar.add(btnAddStudent);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(388, 431, 86, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				GuiHider();
			}
		});	
		getContentPane().add(btnLogout);

		Object[] cols = {"Uob","Name","Year","Email","City","Phone","Pat","Dept."};
	 rows =new String[8][8];
		Database db = new Database();
		String queryStudent="select * from student";
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
					
					array= new String[8][8];
					for(int i=0;i<8;i++){
						for(int j=0;j<8;j++){
							array[i][j]=(String) rows[i][j];
						}
					}

				}
			} catch (SQLException e) {
				
				System.out.println("loop");
				
			}
		

		
			JTable table = new JTable(rows,cols);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(22, 89, 452, 319);
			getContentPane().add(scrollPane);
			
					JButton btnGeneratePdf = new JButton("Get PDF");
					btnGeneratePdf.setBounds(250, 431, 128, 21);
					
					btnGeneratePdf.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							CreatePDF c = new CreatePDF();
							c.createPDF(array, "ssoPdf");
							JOptionPane.showMessageDialog(null, "Pdf has been generated");
						}
					});
					getContentPane().add(btnGeneratePdf);
			
			setVisible(true);



		
	}



	public void GuiHider(){
		setVisible(false);
	}

	public static void main(String[] args) {
		new sso();
		// TODO Auto-generated method stub

	}
}

