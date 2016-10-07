package _03.property.access.dao;

import _03.property.access.model.Employee3;

public interface EmployeeDAO {

	public Employee3 insertEmployee(int id, String name, String surname, int salary);

}
