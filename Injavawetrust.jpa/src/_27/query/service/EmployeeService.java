package _27.query.service;

import java.util.List;

import _27.query.model.Employee27;

public interface EmployeeService {

	public Employee27 createEmployee(String name, String surname, int salary);

	public List<Employee27> findAllEmployees();
	
	public List<String> getEmployeeNames();

	public String getEmployeeNameById(int id);	

	public int getEmployeeSalaryByName(String name);
}
