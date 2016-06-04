package _07.mapping.enumerated.service;

import _07.mapping.enumerated.model.Employee7;
import _07.mapping.enumerated.model.EmployeeType;

public interface EmployeeService {

	public Employee7 createEmployee(int id, String name, String surname, int salary, EmployeeType employeeType);
	
}
