package _01.hello.eclipselink.dao;

import java.util.List;

import _01.hello.eclipselink.model.Employee;

public interface EmployeeDAO {

	public Employee insertEmployee(int id, String name, String surname, int salary);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);

	public Employee raiseEmployeeSalary(int id, int raise);

}