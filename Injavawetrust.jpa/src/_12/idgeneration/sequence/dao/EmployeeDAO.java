package _12.idgeneration.sequence.dao;

import _12.idgeneration.sequence.model.Employee12;

public interface EmployeeDAO {

	public Employee12 insertEmployee(String name, String surname, int salary);

}
