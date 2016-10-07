package _04.mixed.access.service;

import _04.mixed.access.model.Employee4;

public interface EmployeeDAO {

	public Employee4 insertEmployee(int id, String name, String surname, int salary, String mobilePhone);
	
}
