package model;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class BaseRepository {
final protected JdbcTemplate jdbc;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/timesheet?useUnicode=true&characterEncoding=utf-8", "root", "");
	public BaseRepository() {
	/*	DriverManagerDataSource dataSource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/timesheet?useUnicode=true&characterEncoding=utf-8", "root", ""
				);*/
		jdbc = new JdbcTemplate(dataSource);
	}
}
