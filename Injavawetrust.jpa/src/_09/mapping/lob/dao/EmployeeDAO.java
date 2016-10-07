package _09.mapping.lob.dao;

import _09.mapping.lob.model.Employee9;

public interface EmployeeDAO {

	public Employee9 createEmployee(int id, String name, String surname, int salary, byte[] picture);

}
