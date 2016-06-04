package _10.idgeneration.auto.service;

import javax.persistence.EntityManager;

import _10.idgeneration.auto.model.Employee10;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee10 createEmployee(String name, String surname, int salary) {
		Employee10 employee = new Employee10(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
