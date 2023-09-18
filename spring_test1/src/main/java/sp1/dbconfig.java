package sp1;
//database 환경설정

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://umj7-003.cafe24.com/wjswjdgh123";
		//String db_url = "jdbc:mysql://localhost:3306/wjswjdgh123";
		String db_user = "wjswjdgh123";
		String db_pass = "qkdrn123!";
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}
