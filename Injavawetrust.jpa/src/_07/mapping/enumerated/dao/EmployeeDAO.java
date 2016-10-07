package _07.mapping.enumerated.dao;

import _07.mapping.enumerated.model.Employee7;
import _07.mapping.enumerated.model.EmployeeType;

public interface EmployeeDAO {

	public Employee7 insertEmployee(int id, String name, String surname, int salary, EmployeeType employeeType);
	
}
