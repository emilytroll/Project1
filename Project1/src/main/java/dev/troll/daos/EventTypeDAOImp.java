package dev.troll.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.troll.entities.EventType;
import dev.troll.util.JDBCConnection;

public class EventTypeDAOImp 
{

	//does not need to be changed so don't try
public static Connection conn = JDBCConnection.getConnection();
	
	public EventType getEventTypeById(int eventTypeId)
	{
		try 
		{
			String sql = "SELECT * FROM Event_Types WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(eventTypeId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				EventType et = new EventType();
				et.setId(eventTypeId);
				et.setName(rs.getString("NAME"));
				et.setReimbursementPercentage(rs.getInt("REIMBURSEMENT_PERCENTAGE"));

				return et;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}
	
	public EventType getEventTypeByName(String name)
	{
		try 
		{
			String sql = "SELECT * FROM Event_Types WHERE name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				EventType et = new EventType();
				et.setId(rs.getInt("TYPE_ID"));
				et.setName(name);
				et.setReimbursementPercentage(rs.getInt("REIMBURSEMENT_PERCENTAGE"));

				return et;
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;	
	}

	public ArrayList<EventType> getAllEventTypes()
	{
		try
		{
			ArrayList<EventType> allEts = new ArrayList<EventType>();
			String sql = "SELECT * FROM Event_Types";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				EventType et = new EventType();
				et.setId(rs.getInt("TYPE_ID"));
				et.setName(rs.getString("NAME"));
				et.setReimbursementPercentage(rs.getInt("REIMBURSEMENT_PERCENTAGE"));
				
				allEts.add(et);
			}
			return allEts;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
