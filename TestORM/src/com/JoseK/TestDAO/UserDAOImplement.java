package com.JoseK.TestDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImplement implements UserDAO{

	@Override
	public void create(String name, double salary, Date hireDate) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			String sql = "insert into emp (Name,Salary,HireDate) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, name);
			ps.setObject(2, salary);
			ps.setObject(3,hireDate);
			ps.executeUpdate();			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
	}

	@Override
	public User read(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = null;
		double salary = 0;
		Date hireDate = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			String sql = "select * from emp where id = " + id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	
			while (rs.next()) {
				name = rs.getString("Name");
				salary = rs.getDouble("Salary");
				hireDate = rs.getDate("HireDate");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return new User(name, salary, hireDate);
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			String sql = "delete from emp where id = " + id;
			ps  = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, conn);
		}
		
	}

	@Override
	public void update(String name, double salary,Date hireDate,int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getMySQLConn();
			String sql = "update emp set Name = ?,Salary = ?, HireDate = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, name);
			ps.setObject(2, salary);
			ps.setObject(3, hireDate);
			ps.setObject(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, conn);
		}
		
	}

	
	
}
