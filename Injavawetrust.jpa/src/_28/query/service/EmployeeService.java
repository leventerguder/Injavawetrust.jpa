package _28.query.service;

import java.util.List;

import _28.query.model.Employee28;

public interface EmployeeService {

	public Employee28 createEmployee(String name, String surname, int salary);

	public List<Employee28> findAllEmployees();

	public Employee28 getEmployeeById(int id);

	public Employee28 getEmployeeByName(String name);
	
	public int getEmployeeSalaryById(int id);
}
