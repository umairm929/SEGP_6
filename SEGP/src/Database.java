import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public String path="jdbc:mysql://localhost/segp";
	public Connection c=null;
	public Statement st=null;
	public ResultSet rs=null;
	//private String query = "select * from student where name = 'm.ali';";
	
	public void connection(String quer){
		try {
			c=DriverManager.getConnection(path,"root","");
			st=c.createStatement();
			rs=st.executeQuery(quer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println("abc");
		}
	}
	
	public void read(String query1){
		try {
			c=DriverManager.getConnection(path,"root","");
			st=c.createStatement();
			rs=st.executeQuery(query1);
			System.out.println(rs.next());
			
//			while(rs.next()){
//				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));			
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//"insert into jutt values('"+"tyb"+"', '"+7+"','"+123456+"');"
	public void write(String squery){
		try {
			c=DriverManager.getConnection(path,"root","");
			st=c.createStatement();
			st.executeUpdate(squery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//Database obj = new Database();
			
		//obj.read(obj.query);
	}
}
