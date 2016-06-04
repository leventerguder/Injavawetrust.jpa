package _21.embedded.objects.service;

import javax.persistence.EntityManager;
import _21.embedded.objects.model.Employee21;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee21 createEmployee(String name, String surname, int salary) {
		Employee21 employee = new Employee21(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
