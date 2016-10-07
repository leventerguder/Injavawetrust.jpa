package _05.mapping.table.dao;

import _05.mapping.table.model.Employee5;

public interface EmployeeDAO {

	public Employee5 insertEmployee(int id, String name, String surname, int salary);
	
}
