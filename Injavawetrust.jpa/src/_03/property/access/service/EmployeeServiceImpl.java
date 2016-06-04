package _03.property.access.service;

import javax.persistence.EntityManager;
import _03.property.access.model.Employee3;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee3 createEmployee(int id, String name, String surname, int salary) {
		Employee3 employee = new Employee3(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}
}
