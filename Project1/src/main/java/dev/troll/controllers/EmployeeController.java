package dev.troll.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.troll.entities.Employee;
import dev.troll.services.EmployeeService;

public class EmployeeController 
{
	public static EmployeeService empser = new EmployeeService();
	public static Gson gson = new Gson();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		Employee currEmp = empser.getEmployeeByEmail(email);
		
		if (empser.login(email, password))
		{
			session.setAttribute("currId", currEmp.getId());
			session.setAttribute("currFn", currEmp.getFirstName());
			session.setAttribute("currLn", currEmp.getLastName());
			session.setAttribute("currEm", currEmp.getEmail());
			session.setAttribute("currPa", currEmp.getPassword());
			session.setAttribute("currSu", currEmp.getSupervisorId());
			session.setAttribute("currDe", currEmp.getDepartmentId());
		}
		
		response.getWriter().append((currEmp != null) ? gson.toJson(currEmp) : "{}");
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
