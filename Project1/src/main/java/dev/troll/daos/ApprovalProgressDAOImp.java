package dev.troll.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.util.JDBCConnection;
import dev.troll.entities.ApprovalProgress;
 
public class ApprovalProgressDAOImp 
{
	public static Connection conn = JDBCConnection.getConnection();
	
	public ApprovalProgress getApprovalProgressById(int approvalProgressId)
	{
		try 
		{
			String sql = "SELECT * FROM Approval_Progress WHERE approval_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(approvalProgressId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(approvalProgressId);
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				return ap;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByEvent(int eventId)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE event_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(eventId));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(eventId);
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	public ArrayList<ApprovalProgress> getAllApprovalProgress()
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByEmployeeId(int employeeId)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorId(int supervisorId)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE employee_id = (SELECT employees.employee_id FROM Employees WHERE supervisor_id = ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(supervisorId));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressBySupervisorIdAndStatus(int supervisorId, int directSupervisorApprovalStatus)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE employee_id = (SELECT employees.employee_id  FROM Employees WHERE supervisor_id = ?) AND direct_supervisor_approval = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(supervisorId));
			ps.setString(2, Integer.toString(directSupervisorApprovalStatus));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public ArrayList<ApprovalProgress> getApprovalProgressByDepartmentId(int departmentId)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE employee_id = (SELECT employees.employee_id FROM Employees WHERE department_id = ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(departmentId));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	

	
	public ArrayList<ApprovalProgress> getApprovalProgressByBenCoStatus(int benCoApprovalStatus)
	{
		try 
		{
			ArrayList<ApprovalProgress> apList = new ArrayList<ApprovalProgress>();
			
			String sql = "SELECT * FROM Approval_Progress WHERE ben_co_approval = ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(benCoApprovalStatus));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				ApprovalProgress ap = new ApprovalProgress();

				ap.setId(rs.getInt("APPROVAL_ID"));
				ap.setEventId(rs.getInt("EVENT_ID"));
				ap.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ap.setDate(rs.getDate("APPROVAL_DATE"));
				ap.setDirectSupervisorApproval(rs.getInt("DIRECT_SUPERVISOR_APPROVAL"));
				ap.setDepartmentHeadApproval(rs.getInt("DEPARTMENT_HEAD_APPROVAL"));
				ap.setBenCoApproval(rs.getInt("BEN_CO_APPROVAL"));
				ap.setDenialMessage(rs.getString("DENIAL_MESSAGE"));
				ap.setGradePresentationUpload(rs.getInt("GRADE_PRESENTATION_UPLOAD"));
				ap.setGradeInfo(rs.getInt("GRADE_INFO"));
				
				apList.add(ap);
			}
			
			return apList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	
	public boolean updateApprovalProgress(ApprovalProgress change)
	{
		try
		{
			String sql = "UPDATE ApprovalProgress SET event_id = ?, employee_id = ?, approval_date = ?, direct_supervisor_approval = ?, department_head_approval = ?, ben_co_approval = ?, denial_message = ?, grade_presentation_upload = ?, grade_info = ? WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(change.getEventId()));
			ps.setString(2, Integer.toString(change.getEmployeeId()));
			ps.setDate(3, change.getDate());
			ps.setString(4, Integer.toString(change.getDirectSupervisorApproval()));
			ps.setString(5, Integer.toString(change.getDepartmentHeadApproval()));
			ps.setString(6, Integer.toString(change.getBenCoApproval()));
			ps.setString(7, change.getDenialMessage());
			ps.setString(8, Integer.toString(change.getGradePresentationUpload()));
			ps.setString(9, Integer.toString(change.getGradeInfo()));
			ps.setString(10, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;
		}
		
		catch (SQLException e)
		{
			System.err.println("Unable to update approval progress");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addApprovalProgress(ApprovalProgress newApp)
	{
		try
		{
			String sql = "CALL add_approval_progress(?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(newApp.getEventId()));
			cs.setString(2, Integer.toString(newApp.getEmployeeId()));
			cs.setDate(3, newApp.getDate());
			cs.setString(4, Integer.toString(newApp.getDirectSupervisorApproval()));
			cs.setString(5, Integer.toString(newApp.getDepartmentHeadApproval()));
			cs.setString(6, Integer.toString(newApp.getBenCoApproval()));
			cs.setString(7, newApp.getDenialMessage());
			cs.setString(8, Integer.toString(newApp.getGradePresentationUpload()));
			cs.setString(9, Integer.toString(newApp.getGradeInfo()));
			
			cs.execute();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Issue adding approval progress");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteApprovalProgress(ApprovalProgress delete)
	{
		try
		{
			String sql = "DELETE approval_progress WHERE approval_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(delete.getId()));
			
			ps.executeQuery();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Unable to delete approval progress");
			e.printStackTrace();
		}
		return false;
	}
	
}