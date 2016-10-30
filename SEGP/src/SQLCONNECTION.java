import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCONNECTION {
	private String s="jdbc:mysql://localhost/gill";
	private Connection c=null;
	private Statement st=null;
	private ResultSet rs=null;
	public void read(){
		try {
			c=DriverManager.getConnection(s,"root","");
			st=c.createStatement();
			rs=st.executeQuery("select umair from jutt;");
			while(rs.next()){
			System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void write(){
		try {
			c=DriverManager.getConnection(s,"root","");
			st=c.createStatement();
			st.executeUpdate("insert into jutt values('"+"tyb"+"', '"+7+"','"+123456+"');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SQLCONNECTION obj = new SQLCONNECTION();
		//obj.write();
		obj.read();
		// TODO Auto-generated method stub
	}
}
