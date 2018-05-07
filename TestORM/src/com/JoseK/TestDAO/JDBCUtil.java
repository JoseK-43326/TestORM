package com.JoseK.TestDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	private static Properties pro = null;	
	static{
		
		try {
			pro = new Properties();
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getMySQLConn(){
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(pro.getProperty("conDriver"));
			//建立连接
			conn = DriverManager.getConnection(pro.getProperty("conURL"),pro.getProperty("conUser"),pro.getProperty("conPassword"));			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	public static void close(ResultSet rs,Statement statement, Connection conn) {
		try {
			if(rs != null){
				rs.close();
			}
			if(statement != null){
				statement.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement, Connection conn) {
		try {		
			if(statement != null){
				statement.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
