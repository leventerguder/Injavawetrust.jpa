package _01.hello.eclipselink.service;

import java.util.List;

import _01.hello.eclipselink.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(int id, String name, String surname, int salary);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);

	public Employee raiseEmployeeSalary(int id, int raise);

}
