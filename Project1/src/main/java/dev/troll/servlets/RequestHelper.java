package dev.troll.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.troll.controllers.ApprovalProgressController;
import dev.troll.controllers.EmployeeController;
import dev.troll.controllers.EventController;



public class RequestHelper {
	
	/**
	 * This method will delegate other methods on the controller
	 * layer of our application to process the request.
	 * @param request the HTTP Request
	 * @param response the HTTP Response
	 * @throws IOException 
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		System.out.println("PROCESS ?");
		String uri = request.getRequestURI();
		
		System.out.println("HELLOOO! " + uri);
		
		switch (uri) {
		
		case "/Project1/addEvent.do": {
			EventController.addEvent(request, response);
			break;
		}
		case "/Project1/addApprovalProgress.do": { 
			ApprovalProgressController.addApprovalProgress(request, response);
			break;
		}
		case "/Project1/login.do": {
			EmployeeController.login(request, response);
			break;
		}
		
		case "/Project1/getApprovalProgressByEmployeeId.do":
		{
			ApprovalProgressController.getApprovalProgressByEmployeeId(request, response);
			break;
		}
		
		case "/Project1/getApprovalProgressBySupervisorId.do":
		{
			ApprovalProgressController.getApprovalProgressBySupervisorId(request, response);
			break;
		}
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot.");
			break;
		}
		}
		
	}

}
