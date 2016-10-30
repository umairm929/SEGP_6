import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.Scrollbar;

public class Registrar extends JFrame{
	
	JTabbedPane tabbedPane=null;
	JPanel panel = null;
	JPanel panel_1 = null;
	JButton btnMerry = null;
	JTable table = null;
	
	
	
	
	public Registrar(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		String colData[] = {"Uob","Name","Year","Dept.","Address","PAT"};
		String rowData[][] ={{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"},
				{"14031200","Faisal","2014","CS","73 JB JHAPAL","ASHRAF"}};
		table = new JTable(rowData,colData);
		table.setBounds(100, 100, 200, 50);
		JScrollPane js = new JScrollPane(table);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel= new JPanel();
		tabbedPane.addTab("Inbox", null, panel, null);
		panel.add(js);
		
		
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Other Information", null, panel_1, null);
		panel_1.setLayout(null);
		
		 btnMerry = new JButton("Merry");
		btnMerry.setBounds(21, 30, 89, 23);
		panel_1.add(btnMerry);
		
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new Registrar();
	}
}
