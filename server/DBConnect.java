package server;

import java.sql.*;

public class DBConnect {
	private static Statement stat;
	public static void init() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/twitter";
		String name="root";
		String pw="123";
		Connection con=DriverManager.getConnection(url,name,pw);
		stat=con.createStatement();
	}
	public static Statement getStat() throws ClassNotFoundException, SQLException{
		if(stat==null)
			init();
		return stat;
	}
}
