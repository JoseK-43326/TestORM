package com.JoseK.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDemo01 {

	public static void main(String[] args) {	
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> lists = new ArrayList<Object[]>();
		try {
			connection = JDBCUtil.getMySQLCon();
			String sql = "select * from emp where id > 0";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Object[] objs = new Object[3];
				objs[0] = rs.getString("Name");
				objs[1] = rs.getDouble("Salary");
				objs[2] = rs.getDate("HireDate");
				lists.add(objs);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCUtil.close(rs, ps, connection);
		}
		
		for(Object[] temp:lists){
			System.out.println("Name:"+temp[0]+"--"+"Salary:"+temp[1]+"--"+"HireDate:"+temp[2]+"--");
		}
	}

}
