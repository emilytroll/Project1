package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.DepartmentDAOImp;
import dev.troll.entities.Department;

public class DepartmentService
{
	private DepartmentDAOImp di = new DepartmentDAOImp();
	
	public Department getDepartmentById(int departmentId)
	{
		return di.getDepartmentById(departmentId);
	}
	
	public Department getDepartmentByName(String name)
	{
		return di.getDepartmentByName(name);
	}

	public ArrayList<Department> getAllDepartments()
	{
		return di.getAllDepartments();
	}
	
	public boolean updateDepartment(Department change)
	{
		return di.updateDepartment(change);
	}
 
	public boolean addDepartment(Department newDep)
	{
		return di.addDepartment(newDep);
	}
	
	public boolean deleteDepartment(Department delete)
	{
		return di.deleteDepartment(delete);
	}
	
	
}
