package _04.mixed.access.service;

import javax.persistence.EntityManager;
import _04.mixed.access.model.Employee4;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee4 createEmployee(int id, String name, String surname, int salary,String mobilePhone) {
		Employee4 employee = new Employee4(id, name, surname, salary,mobilePhone);
		entityManager.persist(employee);
		return employee;
	}

}
