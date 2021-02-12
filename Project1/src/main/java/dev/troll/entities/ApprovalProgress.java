package dev.troll.entities;

import java.sql.Date;

public class ApprovalProgress
{
	private int id;
	private int eventId;
	private int employeeId;
	private Date date;
	private int directSupervisorApproval;
	private int departmentHeadApproval;
	private int benCoApproval;
	private String denialMessage;
	private int gradePresentationUpload;
	private int gradeInfo;
	
	
	
	public ApprovalProgress() {
		super();
	}

	public ApprovalProgress(int id, int eventId, int employeeId, Date date, int directSupervisorApproval,
			int departmentHeadApproval, int benCoApproval, String denialMessage, int gradePresentationUpload,
			int gradeInfo) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.date = date;
		this.directSupervisorApproval = directSupervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
		this.denialMessage = denialMessage;
		this.gradePresentationUpload = gradePresentationUpload;
		this.gradeInfo = gradeInfo;
	}




	public ApprovalProgress(int eventId, int employeeId, Date date, int directSupervisorApproval,
			int departmentHeadApproval, int benCoApproval, String denialMessage, int gradePresentationUpload,
			int gradeInfo) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.date = date;
		this.directSupervisorApproval = directSupervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
		this.denialMessage = denialMessage;
		this.gradePresentationUpload = gradePresentationUpload;
		this.gradeInfo = gradeInfo;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getDirectSupervisorApproval() {
		return directSupervisorApproval;
	}


	public void setDirectSupervisorApproval(int directSupervisorApproval) {
		this.directSupervisorApproval = directSupervisorApproval;
	}


	public int getDepartmentHeadApproval() {
		return departmentHeadApproval;
	}


	public void setDepartmentHeadApproval(int departmentHeadApproval) {
		this.departmentHeadApproval = departmentHeadApproval;
	}


	public int getGradePresentationUpload() {
		return gradePresentationUpload;
	}


	public void setGradePresentationUpload(int gradePresentationUpload) {
		this.gradePresentationUpload = gradePresentationUpload;
	}


	public int getBenCoApproval() {
		return benCoApproval;
	}


	public void setBenCoApproval(int benCoApproval) {
		this.benCoApproval = benCoApproval;
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getDenialMessage() {
		return denialMessage;
	}



	public void setDenialMessage(String denialMessage) {
		this.denialMessage = denialMessage;
	}



	public int getGradeInfo() {
		return gradeInfo;
	}


	public void setGradeInfo(int gradeInfo) {
		this.gradeInfo = gradeInfo;
	}
		
}