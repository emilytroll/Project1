package dev.troll.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.entities.Event;
import dev.troll.util.JDBCConnection;

public class EventDAOImp
{
	/*
	 * 	private int id;
	private int type; //fk
	private String name;
	private Date date;
	private String description;
	private double cost;
	 */
public static Connection conn = JDBCConnection.getConnection();
	
	public Event getEventById(int eventId)
	{
		try 
		{
			String sql = "SELECT * FROM Eventss WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(eventId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Event e = new Event();
				
				e.setId(eventId);
				e.setType(rs.getInt("EVENT_TYPE"));
				e.setName(rs.getString("NAME"));
				e.setDate(rs.getString("DATTE"));
				e.setDescription(rs.getString("DESCRIPTION"));
				e.setCost(rs.getDouble("COST"));
				
				return e;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public Event getEventByName(String name)
	{
		try 
		{
			String sql = "SELECT * FROM Eventss WHERE name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				Event e = new Event();
				
				e.setId(rs.getInt("EVENT_ID"));
				e.setType(rs.getInt("EVENT_TYPE"));
				e.setName(name);
				e.setDate(rs.getString("DATTE"));
				e.setDescription(rs.getString("DESCRIPTION"));
				e.setCost(rs.getDouble("COST"));
				
				return e;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	public ArrayList<Event> getAllEvents()
	{
		try
		{
			ArrayList<Event> allEs = new ArrayList<Event>();
			String sql = "SELECT * FROM Eventss";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Event e = new Event();
				
				e.setId(rs.getInt("EVENT_ID"));
				e.setType(rs.getInt("EVENT_TYPE"));
				e.setName(rs.getString("NAME"));
				e.setDate(rs.getString("DATTE"));
				e.setDescription(rs.getString("DESCRIPTION"));
				e.setCost(rs.getDouble("COST"));
				
				allEs.add(e);
			}
			return allEs;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateEvent(Event change)
	{
		try
		{
			String sql = "UPDATE eventss SET event_type = ?, name = ?, datte = ?, description = ?, cost = ? WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(change.getType()));
			ps.setString(2, change.getName());
			ps.setString(3, change.getDate());
			ps.setString(4, change.getDescription());
			ps.setString(5, Double.toString(change.getCost()));
			ps.setString(6, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;
		}
		
		catch (SQLException e)
		{
			System.err.println("Unable to update event");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addEvent(Event newEve)
	{
		try
		{
			String sql = "CALL add_event(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(newEve.getType()));
			cs.setString(2, newEve.getName());
			cs.setString(3, newEve.getDate());
			cs.setString(4, newEve.getDescription());
			cs.setString(5, Double.toString(newEve.getCost()));
			
			cs.execute();
			System.out.println("SUCCESS");
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Issue adding event");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEvent(Event delete)
	{
		try
		{
			String sql = "DELETE eventss WHERE event_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(delete.getId()));
			
			ps.executeQuery();
			return true;
		}
		catch (SQLException e)
		{
			System.err.println("Unable to delete event");
			e.printStackTrace();
		}
		return false;
	}
}
