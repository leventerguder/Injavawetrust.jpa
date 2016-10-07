package _06.mapping.column.dao;

import _06.mapping.column.model.Employee6;

public interface EmployeeDAO {

	public Employee6 insertEmployee(int id, String name, String surname, int salary);
	
}
