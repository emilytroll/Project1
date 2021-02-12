package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.ApprovalProgressDAOImp;
import dev.troll.daos.EmployeeDAOImp;
import dev.troll.entities.ApprovalProgress;
import dev.troll.entities.Employee;

public class ApprovalProgressService 
{
	private ApprovalProgressDAOImp api = new ApprovalProgressDAOImp();
	private EmployeeDAOImp ei = new EmployeeDAOImp();
	
	public ApprovalProgress getApprovalProgressById(int approvalProgressId)
	{
		return api.getApprovalProgressById(approvalProgressId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByEvent(int eventId)
	{
		return api.getApprovalProgressByEvent(eventId);
	}
	
	public ArrayList<ApprovalProgress> getAllApprovalProgress()
	{
		return api.getAllApprovalProgress();
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByEmployeeId(int employeeId)
	{
		return api.getApprovalProgressByEmployeeId(employeeId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorId(int supervisorId)
	{
		return api.getApprovalProgressBySupervisorId(supervisorId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorIdAndStatus(int supervisorId, int directSupervisorApprovalStatus)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = ei.getEmployeesByDirectSupervisor(supervisorId);
		
		ArrayList<ApprovalProgress> approvalProgressBySupervisor = new ArrayList<ApprovalProgress>();
		
		for (int i = 0; i < employees.size(); i++)
		{
			ArrayList<ApprovalProgress> employeeApprovalProgress = api.getApprovalProgressByEmployeeId(i);
			for (int j = 0; j < employeeApprovalProgress.size(); j++)
			{	
				
			}
		}
		
		//return api.getApprovalProgressBySupervisorIdAndStatus(supervisorId, directSupervisorApprovalStatus);
	}
 
	public ArrayList<ApprovalProgress> getApprovalProgressByDepartmentId(int departmentId)	
	{
		return api.getApprovalProgressByDepartmentId(departmentId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByDepartmentHeadIdAndStatus(int departmentId, int departmentHeadApprovalStatus)
	{
		return api.getApprovalProgressByDepartmentHeadIdAndStatus(departmentId, departmentHeadApprovalStatus);
	}
	 
	public ArrayList<ApprovalProgress> getApprovalProgressByBenCoStatus(int benCoApprovalStatus)
	{
		return api.getApprovalProgressByBenCoStatus(benCoApprovalStatus);
	}
	
	public boolean updateApprovalProgress(ApprovalProgress change)
	{
		return api.updateApprovalProgress(change);
	}
	
	public boolean addApprovalProgress(ApprovalProgress newApp)
	{
		return api.addApprovalProgress(newApp);
	}
 
	public boolean deleteApprovalProgress(ApprovalProgress delete)
	{
		return api.deleteApprovalProgress(delete);
	}
	
}
