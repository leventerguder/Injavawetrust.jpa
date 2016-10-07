package _02.field.access.dao;

import _02.field.access.model.Employee2;

public interface EmployeeDAO {

	public Employee2 insertEmployee(int id, String name, String surname, int salary);

}
