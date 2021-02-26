package dev.troll.test;

import dev.troll.services.EmployeeService;

public class P1Runner {

	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		System.out.println(es.getEmployeesByDirectSupervisor(1));
	}

}
