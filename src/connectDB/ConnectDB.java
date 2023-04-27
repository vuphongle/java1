package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance () {
		return instance;
	}
	
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QUANLYSV";
		String user = "sa";
		String pass = "sapassword";
		con = DriverManager.getConnection(url,user,pass);
	}
 
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static Connection getConnection () {
		return con;
	}
}
