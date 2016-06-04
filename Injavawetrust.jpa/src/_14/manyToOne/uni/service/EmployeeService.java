package _14.manyToOne.uni.service;

import _14.manyToOne.uni.model.Employee14;

public interface EmployeeService {

	public Employee14 createEmployee(String name, String surname, int salary);
	public Employee14 findEmployee(int id);

}
