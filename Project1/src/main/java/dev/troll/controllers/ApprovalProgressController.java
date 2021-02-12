package dev.troll.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.troll.entities.ApprovalProgress;
import dev.troll.services.ApprovalProgressService;

public class ApprovalProgressController 
{
	public static Gson gson = new Gson();
	public static ApprovalProgressService aps = new ApprovalProgressService();
	
	public static void addApprovalProgress(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ApprovalProgress ap = gson.fromJson(request.getReader(), ApprovalProgress.class);
		boolean a = aps.addApprovalProgress(ap);
		
		response.getWriter().append((a) ? gson.toJson(ap) : "{}");
	}
	
	public static void getApprovalProgressBySupervisorId(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		
		ArrayList <ApprovalProgress> ap = aps.getApprovalProgressBySupervisorId(id);
		
		response.getWriter().append((ap) != null ? gson.toJson(ap) : "{}");
	}

	public static void getApprovalProgressByEmployeeId(HttpServletRequest request, HttpServletResponse response) throws IOException {
String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		ArrayList <ApprovalProgress> ap = aps.getApprovalProgressBySupervisorId(id);
		
		response.getWriter().append((ap) != null ? gson.toJson(ap) : "{}");
		
	}
}
