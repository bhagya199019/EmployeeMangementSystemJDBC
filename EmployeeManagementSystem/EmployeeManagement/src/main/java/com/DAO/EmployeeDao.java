package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.Entity.Employee;

public interface EmployeeDao {

	public void insert(Employee emp) throws SQLException;
	public void delete() throws SQLException  ;
	public void viewAllEmployees() throws SQLException;
    public void findById() throws SQLException;
	public void findByName() throws SQLException;
	public void sortByName() throws  SQLException;
	public void searchByAge() throws SQLException;
	public  boolean isValidUser(String uname, String pasword,String rle)throws SQLException;
}
