package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.EmployeeDAOImp;
import dev.troll.entities.Employee;

public class EmployeeService 
{
	private EmployeeDAOImp empi = new EmployeeDAOImp();
	
	
	public Employee getEmployeeById(int employeeId)
	{
		return empi.getEmployeeById(employeeId);
	}
	
	public Employee getEmployeeByFullName(String fullName)
	{
		return empi.getEmployeeByFullName(fullName);
	}
	
	public Employee getEmployeeByEmail(String email)
	{
		return empi.getEmployeeByEmail(email);
	}
 
	public ArrayList<Employee> getAllEmployees()
	{
		return empi.getAllEmployees();
	}
	 
	public ArrayList<Employee> getEmployeesByDirectSupervisor(int supervisorId)
	{
		return empi.getEmployeesByDirectSupervisor(supervisorId);
	}
	
	public ArrayList<Employee> getEmployeesByDepartmentId(int departmentId)
	{
		return empi.getEmployeesByDepartmentId(departmentId);
	}
	 
	public boolean login(String email, String password)
	{
		return empi.login(email, password);
	}
	 
	public boolean updateEmployee(Employee change)
	{
		return empi.updateEmployee(change);
	}
	 
	public boolean addEmployee(Employee newEmp)
	{
		return empi.addEmployee(newEmp);
	}
	
	public boolean deleteEmployee(Employee delete)
	{
		return empi.deleteEmployee(delete);
	}
	
}
