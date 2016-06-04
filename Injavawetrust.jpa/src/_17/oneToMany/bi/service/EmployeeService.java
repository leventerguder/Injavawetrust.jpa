package _17.oneToMany.bi.service;

import _17.oneToMany.bi.model.Employee17;

public interface EmployeeService {

	public Employee17 createEmployee(String name, String surname, int salary);

	public Employee17 findEmployee(int id);

}
