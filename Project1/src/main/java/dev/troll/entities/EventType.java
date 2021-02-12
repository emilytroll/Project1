package dev.troll.entities;

public class EventType
{
	private int id;
	private String name;
	private int reimbursementPercentage;
	
	
	public EventType() {
		super();
	}
	public EventType(String name, int reimbursementPercentage) {
		super();
		this.name = name;
		this.reimbursementPercentage = reimbursementPercentage;
	}
	public EventType(int id, String name, int reimbursementPercentage) {
		super();
		this.id = id;
		this.name = name;
		this.reimbursementPercentage = reimbursementPercentage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReimbursementPercentage() {
		return reimbursementPercentage;
	}
	public void setReimbursementPercentage(int reimbursementPercentage) {
		this.reimbursementPercentage = reimbursementPercentage;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventType other = (EventType) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reimbursementPercentage != other.reimbursementPercentage)
			return false;
		return true;
	}
	
	
}
