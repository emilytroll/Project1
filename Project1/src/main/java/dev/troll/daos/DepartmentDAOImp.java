package dev.troll.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.util.JDBCConnection;
import dev.troll.entities.Department;
public class DepartmentDAOImp 
{
	public static Connection conn = JDBCConnection.getConnection();
	
	public Department getDepartmentById(int departmentId)
	{
		try 
		{
			String sql = "SELECT * FROM departments WHERE department_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(departmentId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Department dep = new Department();
				
				dep.setId(departmentId);
				dep.setName(rs.getString("NAME"));
				dep.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));
				
				return dep;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public Department getDepartmentByName(String name)
	{
		try 
		{
			String sql = "SELECT * FROM departments WHERE name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Department dep = new Department();
				
				dep.setId(rs.getInt("DEPARTMENT_ID"));
				dep.setName(name);
				dep.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD"));
				
				return dep;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	public ArrayList<Department> getAllDepartments()
	{
		try
		{
			ArrayList<Department> allDeps = new ArrayList<Department>();
			String sql = "SELECT * FROM Departments";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Department dep = new Department();
				
				dep.setId(rs.getInt("ID"));
				dep.setName(rs.getString("NAME"));
				dep.setDepartmentHead(rs.getInt("DEPARTMENT_HEAD")); 
				
				allDeps.add(dep);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateDepartment(Department change)
	{
		try
		{
			String sql = "UPDATE departments SET name = ?, department_head_employee_id = ? WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(change.getDepartmentHead()));
			ps.setString(2, change.getName());
			ps.setString(3, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;
		}
		
		catch (SQLException e)
		{
			System.err.println("Unable to update department");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addDepartment(Department newDep)
	{
		try
		{
			String sql = "CALL add_department(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, newDep.getName());
			cs.setString(2, Integer.toString(newDep.getDepartmentHead()));
			
			cs.execute();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Issue adding department");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteDepartment(Department delete)
	{
		try
		{
			String sql = "DELETE departments WHERE department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(delete.getId()));
			
			ps.executeQuery();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Unable to delete department");
			e.printStackTrace();
		}
		return false;
	}
	
}
