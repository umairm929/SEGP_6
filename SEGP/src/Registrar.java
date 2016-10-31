import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import snippet.CreatePDF;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class Registrar extends JFrame{
	
	JTabbedPane tabbedPane=null;
	JPanel panel = null;
	JPanel panel_1 = null;
	
	JTable table = null;
	public Object[][] rows;
	public String[][] array;
	private JTextField name;
	private JTextField patc;
	private JTextField reason;
	ArrayList<String> list = new ArrayList<>();
	private JTextField status;
	String namep;
	String patp;
	String reasonp;
	
	
	
	public void guiHider(){
		setVisible(false);
	}
	
	public void request(){
		
		Database db = new Database();
		String getQuery="select * from request";
		db.connection(getQuery);
		try {
			while(db.rs.next()){
				for(int i=0;i<4;i++){
					list.add(db.rs.getString(i+1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.setText(list.get(0));
		patc.setText(list.get(1));
		System.out.println(list.get(1));
		reason.setText(list.get(2));
		
		String s = list.get(3);
		
		if(s==null){
			status.setText("Yet To Be Decided");
		}
		else
			status.setText(list.get(3));
		
	}
	
	
	public Registrar(){
		setTitle("Registrar");
		
		
		
		
		
		
		
		
		Object[] cols = {"Uob","Name","Year","Email","Address","Phone","Dep.","Pat"};
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel= new JPanel();
		tabbedPane.addTab("Inbox", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Uob");
		lblName.setBounds(25, 46, 46, 14);
		panel.add(lblName);
		
		JLabel lblNewPat = new JLabel("New Pat");
		lblNewPat.setBounds(25, 86, 61, 14);
		panel.add(lblNewPat);
		
		patc = new JTextField();
		patc.setBounds(96, 83, 119, 20);
		panel.add(patc);
		patc.setColumns(10);
		
		name = new JTextField();
		name.setBounds(96, 43, 119, 20);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(25, 129, 46, 14);
		panel.add(lblReason);
		
		reason = new JTextField();
		reason.setBounds(97, 129, 209, 80);
		panel.add(reason);
		reason.setColumns(10);
		
		JButton btnApprove = new JButton("Accept");
		btnApprove.setBounds(354, 233, 89, 23);
		panel.add(btnApprove);
		
		JButton btnCancel = new JButton("Reject");
		btnCancel.setBounds(248, 233, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel.add(btnCancel);
		
		JButton btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						guiHider();
						new Login();
				
			}
		});
		btnLogout_1.setBounds(380, 391, 89, 23);
		panel.add(btnLogout_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 217, 432, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 27, -10, 155);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 171, 61, -11);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(446, 46, 0, 2);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(27, 33, 430, 2);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 33, 5, 186);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(456, 46, 0, 2);
		panel.add(separator_6);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(354, 275, 89, 23);
		panel.add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(248, 275, 89, 23);
		panel.add(btnBack);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(260, 46, 46, 14);
		panel.add(lblStatus);
		
		status = new JTextField();
		status.setBounds(334, 43, 109, 20);
		panel.add(status);
		status.setColumns(10);
		

		
		JTable table_1 = new JTable(rows,cols);
		JScrollPane js = new JScrollPane(table_1);
		js.setBounds(13, 5, 452, 366);
		
		
		
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Student Information", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.add(js);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(385, 391, 80, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiHider();
				new Login();
			}
		});
		panel_1.add(btnLogout);
		
		JButton btnGetPdf = new JButton("Get PDF");
		btnGetPdf.setBounds(286, 391, 89, 23);
		btnGetPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreatePDF c = new CreatePDF();
				c.createPDF(array, "registrarPdf");
				JOptionPane.showMessageDialog(null, "Pdf has been generated");
			}
		});
		panel_1.add(btnGetPdf);
		//panel_1.setLayout(null);
		
		request();
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new Registrar();
	}
}
