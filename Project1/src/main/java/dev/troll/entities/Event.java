package dev.troll.entities;

public class Event {
	private int id;
	private int type; //fk
	private String name;
	private String date;
	private String description;
	private double cost;
	
	public Event() {
		super();
	}
	
	public Event(int id, int type, String name, String date, String description, double cost) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.date = date;
		this.description = description;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
