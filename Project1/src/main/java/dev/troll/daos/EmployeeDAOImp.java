package dev.troll.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.util.JDBCConnection;
import dev.troll.entities.Employee;

public class EmployeeDAOImp 
{
	public static Connection conn = JDBCConnection.getConnection();
	
	public Employee getEmployeeById(int employeeId)
	{
		try 
		{
			String sql = "SELECT * FROM Employees WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(employeeId);
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				return emp;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public Employee getEmployeeByFullName(String fullName)
	{
		String[] fullNameArr = fullName.split(" ");
		try 
		{
			String sql = "SELECT * FROM Employees WHERE first_name = ? AND last_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fullNameArr[0]);
			ps.setString(2, fullNameArr[1]);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(fullNameArr[0]);
				emp.setLastName(fullNameArr[1]);
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				return emp;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public Employee getEmployeeByEmail(String email)
	{
		try
		{
			String sql = "SELECT * FROM Employees WHERE email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(email);
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				return emp;
			}
		}
		catch (SQLException e)
		{
			System.err.println("Employee not found");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Employee> getAllEmployees()
	{
		try
		{
			ArrayList<Employee> allEmps = new ArrayList<Employee>();
			String sql = "SELECT * FROM Employees";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				allEmps.add(emp);
			}
			return allEmps;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeesByDirectSupervisor(int supervisorId)
	{
		try
		{
			ArrayList<Employee> supervisedEmps = new ArrayList<Employee>();
			String sql = "SELECT * FROM Employees WHERE supervisor_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(supervisorId);
				emp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				supervisedEmps.add(emp);
			}
			return supervisedEmps;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeesByDepartmentId(int departmentId)
	{
		try
		{
			ArrayList<Employee> depEmps = new ArrayList<Employee>();
			String sql = "SELECT * FROM Employees WHERE department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Employee emp = new Employee();

				emp.setId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPassword(rs.getString("PASSWORD"));
				emp.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				emp.setDepartmentId(departmentId);
				
				depEmps.add(emp);
			}
			return depEmps;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean login(String email, String password)
	{
		try
		{
			String sql = "SELECT * FROM Employees WHERE email = ? AND password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		}
		catch (SQLException e)
		{
			System.err.println("Login error");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateEmployee(Employee change)
	{
		try
		{
			String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, password = ?, supervisor_id = ?, department_id = ? WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getFirstName());
			ps.setString(2, change.getLastName());
			ps.setString(3, change.getEmail());
			ps.setString(4, change.getPassword());
			ps.setString(5, Integer.toString(change.getSupervisorId()));
			ps.setString(6, Integer.toString(change.getDepartmentId()));
			ps.setString(7, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;
		}
		
		catch (SQLException e)
		{
			System.err.println("Unable to update employee");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addEmployee(Employee newEmp)
	{
		try
		{
			String sql = "CALL add_employee(?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, newEmp.getFirstName());
			cs.setString(2, newEmp.getLastName());
			cs.setString(3, newEmp.getEmail());
			cs.setString(4, newEmp.getPassword());
			cs.setString(5, Integer.toString(newEmp.getSupervisorId()));
			cs.setString(6, Integer.toString(newEmp.getDepartmentId()));
			
			cs.execute();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Issue adding employee");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEmployee(Employee delete)
	{
		try
		{
			String sql = "DELETE employees WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(delete.getId()));
			
			ps.executeQuery();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Unable to delete employee");
			e.printStackTrace();
		}
		return false;
	}
}
