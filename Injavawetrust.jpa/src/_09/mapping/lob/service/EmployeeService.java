package _09.mapping.lob.service;

import _09.mapping.lob.model.Employee9;

public interface EmployeeService {

	public Employee9 createEmployee(int id, String name, String surname, int salary, byte[] picture);

}
