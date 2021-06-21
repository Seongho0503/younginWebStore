package util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionUtil {

	public static Connection getConnection() {
			Connection con=null;	
			try {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  
			      String url = "jdbc:mysql://localhost:3306/younginwebstore";
			      String user = "younginwebstore";
			      String password = "132353";
			      con = DriverManager.getConnection(url, user, password);
			     
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return con;
	}
	public static void main(String args[]){
		getConnection();
	}
}
