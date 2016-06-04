package _02.field.access.service;

import javax.persistence.EntityManager;
import _02.field.access.model.Employee2;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee2 createEmployee(int id, String name, String surname, int salary) {
		Employee2 employee = new Employee2(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
