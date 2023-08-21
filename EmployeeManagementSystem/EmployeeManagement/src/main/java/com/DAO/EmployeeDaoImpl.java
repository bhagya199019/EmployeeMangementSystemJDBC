package com.DAO;

import java.sql.*;

import java.util.*;

import com.Entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	  
	public EmployeeDaoImpl(){
		
		//1.register driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		//2.Get connection
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhagya","root","root");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(con!=null) {
			System.out.println("connected successfully");
		}
	}
	
	public void insert(Employee emp) throws SQLException {
		//3.create the statement
				PreparedStatement pstmt=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?)");
				System.out.println("Enter id");
				emp.setEid(sc.nextInt());
				System.out.println("Enter employee name");
				 emp.setEname(sc.next());
				System.out.println("Enter employee age");
				 emp.setAge(sc.nextInt());
				System.out.println("Enter gender of employee"); 
				 emp.setGender(sc.next());
				 System.out.println("Enter phoneno of employee"); 
				 emp.setPhoneno(sc.nextLong());
				 System.out.println("Enter address of employee");
				 emp.setAddress(sc.next());
				 System.out.println("Enter date of joining of employee");
				 emp.setDate_of_joining(sc.next());
				 System.out.println("Enter role of employee");
				 emp.setRole(sc.next());
				 System.out.println("Enter username of employee");
				 emp.setUsername(sc.next());
				 System.out.println("Enter password of employee");
				 emp.setPassword(sc.next());
				 
				pstmt.setInt(1, emp.getEid());
				pstmt.setString(2, emp.getEname());
				pstmt.setInt(3,emp.getAge());
				pstmt.setString(4,emp.getGender());
				pstmt.setLong(5,emp.getPhoneno());
				pstmt.setString(6,emp.getAddress());
				pstmt.setString(7, emp.getDate_of_joining());
				pstmt.setString(8,emp.getRole());
				pstmt.setString(9,emp.getUsername());
				pstmt.setString(10,emp.getPassword());
				
				//4.execute query
				int i=pstmt.executeUpdate();
				
				if(i>=1) {
					System.out.println("data inserted  successfully");
				}
				
				
	}
	
	
	public void delete() throws SQLException {
    Statement st1=con.createStatement();
    System.out.println("Enter id to delete data of employee");
	int id=sc.nextInt();
		int i=st1.executeUpdate("delete from employee where eid='"+id+"'");
		if(i>=1) {
			System.out.println("data deleted  successfully");
		}
		
	}
	
public void viewAllEmployees() throws SQLException {
	
	Statement st2=con.createStatement();
			
			ResultSet rs=st2.executeQuery("select * from Employee");
			
			while(rs.next()) {
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)
);

}
  }
	



@Override
public void findById() throws SQLException {
	Statement st1=con.createStatement();
    System.out.println("Enter id to find the data of employee");
	int id=sc.nextInt();
	ResultSet rs=st1.executeQuery("select * from employee where eid='"+id+"'");
	while(rs.next()) {
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)
				);

}
}

@Override
public void findByName() throws SQLException {
	Statement st1=con.createStatement();
    System.out.println("Enter name to find the data of employee");
    String name=sc.next();
	ResultSet rs=st1.executeQuery("select * from employee where ename='"+name+"'");
	while(rs.next()) {
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)
				);


}
	
}

public void sortByName() throws SQLException {
	Statement st1=con.createStatement();
 ResultSet rs=st1.executeQuery("select * from employee order by ename");
	while(rs.next()) {

System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)
				);



	}
}

public void searchByAge() throws SQLException{
	Statement st1=con.createStatement();
	System.out.println("Enter the start age range");
	int start=sc.nextInt();
	System.out.println("enter the stop age range");
	int stop=sc.nextInt();
	 ResultSet rs=st1.executeQuery("select * from employee where age between '"+start+"' and '"+stop+"'" );
		while(rs.next()) {

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)
					);



		}
	
}




public  boolean isValidUser(String uname, String pasword,String role)throws SQLException {
	boolean isValid = false;

	 // Set the type and concurrency of the ResultSet to allow scrolling backward
    String selectQuery = "SELECT *  FROM employee WHERE username = '"+uname+"' AND password = '"+pasword+"' AND role=  '"+role+"'";
    PreparedStatement  stmt = con.prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    ResultSet  rs = stmt.executeQuery();


//Move the cursor to the last row
rs.last();

// Get the row count
int rowCount = rs.getRow();

// Move the cursor back to before the first row (optional but recommended)
//rs.beforeFirst();


    if(rowCount>0) {
            
    isValid =true;
        }

    return isValid;
    }

 


}















































