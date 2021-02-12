package dev.troll.services;

import java.util.ArrayList;

import dev.troll.daos.EventTypeDAOImp;
import dev.troll.entities.EventType;

public class EventTypeService 
{
	private EventTypeDAOImp eti = new EventTypeDAOImp();
		
		public EventType getEventTypeById(int eventTypeId)
		{
			return eti.getEventTypeById(eventTypeId);
		}

		public EventType getEventTypeByName(String name)
		{
			return eti.getEventTypeByName(name);
		}
		
		public ArrayList<EventType> getAllEventTypes()
		{
			return eti.getAllEventTypes();
		}

}
