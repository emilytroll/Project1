package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.EventDAOImp;
import dev.troll.entities.Event;

public class EventService 
{
	private EventDAOImp ei = new EventDAOImp();
	
	public Event getEventById(int eventId)
	{
		return ei.getEventById(eventId);
	}

	public Event getEventByName(String name)
	{
		return ei.getEventByName(name);
	}

	public ArrayList<Event> getAllEvents()
	{
		return ei.getAllEvents();
	}

	public boolean updateEvent(Event change)
	{
		return ei.updateEvent(change);
	}

	public boolean addEvent(Event newEve)
	{
		return ei.addEvent(newEve);
	}
	
	public boolean deleteEvent(Event delete)
	{
		return ei.deleteEvent(delete);
	}
}
