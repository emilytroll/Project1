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
		System.out.println(ei.getEmployeesByDirectSupervisor(1));
		return api.getApprovalProgressByEmployeeId(employeeId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorId(int supervisorId)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = ei.getEmployeesByDirectSupervisor(supervisorId);
		
		ArrayList<ApprovalProgress> supervisorsApprovals = new ArrayList<ApprovalProgress>();
		
		for (int i = 0; i < employees.size(); i++)
		{
			ArrayList<ApprovalProgress> employeesProgress = api.getApprovalProgressByEmployeeId(employees.get(i).getId());
			for (int j = 0; j < employeesProgress.size(); j++)
			{
				supervisorsApprovals.add(employeesProgress.get(j));
			}
		}
		
		if (supervisorsApprovals.isEmpty())
			return null;
	return supervisorsApprovals;
		
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorIdAndStatus(int supervisorId, int directSupervisorApprovalStatus)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = ei.getEmployeesByDirectSupervisor(supervisorId);
		
		ArrayList<ApprovalProgress> approvalProgressBySupervisor = new ArrayList<ApprovalProgress>();
		
		for (int i = 0; i < employees.size(); i++)
		{
			ArrayList<ApprovalProgress> employeeApprovalProgress = api.getApprovalProgressByEmployeeId(employees.get(i).getId());
			for (int j = 0; j < employeeApprovalProgress.size(); j++)
			{	
				if (employeeApprovalProgress.get(j).getDirectSupervisorApproval() == directSupervisorApprovalStatus)
					approvalProgressBySupervisor.add(employeeApprovalProgress.get(j));
				
			}
		}
		
		if (approvalProgressBySupervisor.isEmpty())
				return null;
		return approvalProgressBySupervisor;
		
		//return api.getApprovalProgressBySupervisorIdAndStatus(supervisorId, directSupervisorApprovalStatus);
	}
 
	public ArrayList<ApprovalProgress> getApprovalProgressByDepartmentId(int departmentId)	
	{
		return api.getApprovalProgressByDepartmentId(departmentId);
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByDepartmentHeadIdAndStatus(int departmentId, int departmentHeadApprovalStatus)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = ei.getEmployeesByDepartmentId(departmentId);
		
		ArrayList<ApprovalProgress> approvalProgressDepStat = new ArrayList<ApprovalProgress>();
		
		for (int i = 0; i < employees.size(); i++)
		{
			ArrayList<ApprovalProgress> employeeApprovalProgress = api.getApprovalProgressByEmployeeId(employees.get(i).getId());
			for (int j = 0; j < employeeApprovalProgress.size(); j++)
			{
				if (employeeApprovalProgress.get(i).getDepartmentHeadApproval() == departmentHeadApprovalStatus)
					approvalProgressDepStat.add(employeeApprovalProgress.get(j));
			}
		}
		
		if (approvalProgressDepStat.isEmpty())
			return null;
		return approvalProgressDepStat;
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
