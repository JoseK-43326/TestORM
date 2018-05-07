package com.JoseK.TestDAO;

import java.sql.Date;

public interface UserDAO {
	
	public void create(String name, double salary,Date hireDate);
	
	public User read(int id);
	
	public void delete(int id);
	
	public void update(String name, double salary,Date hireDate,int id);
}
