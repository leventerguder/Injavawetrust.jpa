package _04.mixed.access.service;

import _04.mixed.access.model.Employee4;

public interface EmployeeService {

	public Employee4 createEmployee(int id, String name, String surname, int salary, String mobilePhone);
	
}
