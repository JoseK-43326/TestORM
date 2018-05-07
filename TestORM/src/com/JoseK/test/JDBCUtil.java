package com.JoseK.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	static Properties properties = null;
	static{
		 properties = new Properties();
		 try {
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	
	public static Connection getMySQLCon() {
		
		Connection con = null;
				
		try {
			//加载驱动
			Class.forName(properties.getProperty("classDriver"));
			//建立连接
			con = DriverManager.getConnection(properties.getProperty("conURL"),properties.getProperty("conUser"),properties.getProperty("conPassword"));						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}

	public static void close(ResultSet rs ,Statement statement, Connection con) {
		try {
			if(rs != null){
				rs.close();
			}
			if(statement != null){
				statement.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement, Connection con) {
		try {
			if(statement != null){
				statement.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
