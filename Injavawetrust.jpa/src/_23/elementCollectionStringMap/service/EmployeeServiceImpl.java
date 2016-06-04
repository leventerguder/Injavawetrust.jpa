package _23.elementCollectionStringMap.service;

import javax.persistence.EntityManager;

import _23.elementCollectionStringMap.model.Employee23;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee23 createEmployee(String name, String surname, int salary) {
		Employee23 employee = new Employee23(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}