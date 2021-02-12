package dev.troll.entities;

public class Department {

	private int id;
	private String name;
	private int departmentHead;
	
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department(int id, String name, int departmentHead) {
		super();
		this.id = id;
		this.name = name;
		this.departmentHead = departmentHead;
	}

	public Department() {
		super();
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

	public int getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentHead != other.departmentHead)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
