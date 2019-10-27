package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class baseRepository {
	protected static java.sql.Date to(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}

	protected static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void open() {
		try {
			connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/timesheet?useUnicode=true&characterEncoding-utf8", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
