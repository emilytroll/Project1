package dev.troll.entities;

public class GradeFormat 
{
	private int id;
	private String gradeValue;
	private int gradeFormat;
	private int passfailBool;
	
	public GradeFormat() {
		super();
	}

	public GradeFormat(String gradeValue, int gradeFormat, int passfailBool) {
		super();
		this.gradeValue = gradeValue;
		this.gradeFormat = gradeFormat;
		this.passfailBool = passfailBool;
	}

	public GradeFormat(int id, String gradeValue, int gradeFormat, int passfailBool) {
		super();
		this.id = id;
		this.gradeValue = gradeValue;
		this.gradeFormat = gradeFormat;
		this.passfailBool = passfailBool;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}

	public int getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(int gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public int getPassfailBool() {
		return passfailBool;
	}

	public void setPassfailBool(int passfailBool) {
		this.passfailBool = passfailBool;
	}

	@Override
	public String toString() {
		return "GradeFormat [id=" + id + ", gradeValue=" + gradeValue + ", gradeFormat=" + gradeFormat
				+ ", passfailBool=" + passfailBool + "]";
	}

	
}
