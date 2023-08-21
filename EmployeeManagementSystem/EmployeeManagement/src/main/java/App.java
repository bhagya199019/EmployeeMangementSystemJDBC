import java.sql.SQLException;
import java.util.*;
import com.DAO.EmployeeDaoImpl;
import com.Entity.Employee;

public class App {

	public static void main(String args[]) throws SQLException {
		Scanner sc=new Scanner(System.in);
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		Employee emp=new Employee();
		System.out.println("Enter user role (admin or employee): ");
		   String role = sc.nextLine().toLowerCase();
		   if(role.equals("admin")||role.equals("employee")) {
			   System.out.println("enter the username");
			   String username=sc.next();
			   System.out.println("enter the password");
			   String password=sc.next();
			   boolean isValid = dao.isValidUser(username, password,role);
		      
	if(isValid) {		   
	    int option=0;
	
		do {
		System.out.println("Enter 1 for insert");
	    System.out.println("Enter 2 for delete");
		System.out.println("Enter 3 for viewall employee");
		System.out.println("Enter 4 to find the employee by id");
		System.out.println("Enter 5 to find the employee by name");
		System.out.println("Enter 6 to sort the employee");
		System.out.println("Enter 7 to find  the employee by age ranges");
		System.out.println("Enter 0 for Exit");
		System.out.println();
	     option=sc.nextInt();
	 	
	     if(option==1 ) {
	    	 System.out.println("admin only has permission");
	     if(option==1 && (role.equals("admin"))) {
	    	 dao.insert(emp);
	     }
	     }
	     else if(option==2) {
	    	 System.out.println("admin only has permission");
	      if(option==2 && (role.equals("admin"))) {
	    	 dao.delete();
	     }
	     }
	     else if(option==3) {
	    	 dao.viewAllEmployees();
	     }
	     else if(option==4 ) {
	    	 dao.findById();
	     }
	     else if(option==5) {
	    	 dao.findByName();
	     }
	     else if(option==6) {
	    	 dao.sortByName();
	     }
	     else if(option==7) {
	    	 dao.searchByAge();
	     }
		}while(option != 0);
		
	}
	else {
		System.out.println("invalid user");
	}
		   }

	}
	
	
		   }
	
	




































