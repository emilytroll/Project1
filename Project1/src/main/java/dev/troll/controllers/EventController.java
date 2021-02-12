package dev.troll.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.troll.entities.Event;
import dev.troll.services.EventService;

public class EventController 
{
	public static Gson gson = new Gson();
	public static EventService es = new EventService();
	
	public static void addEvent(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Event newEve = gson.fromJson(request.getReader(), Event.class);
		System.out.println("neweve: " + newEve.toString());
		boolean ae = es.addEvent(newEve);
		
		response.getWriter().append((ae) ? gson.toJson(newEve) : "{}");
	}

}
