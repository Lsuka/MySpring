package cn.unicorn.myspring.jdbc;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.Driver;

public class MySQLDatabaseConnectDemo{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/mldn";
	public static final String USENAME = "root";
	public static final String PASSWORD = "mysqladmin";

	public static void main(String[] args) throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USENAME);
		dataSource.setPassword(PASSWORD);
		System.out.println(dataSource.getConnection());
		dataSource.getConnection().close();
	}

}
