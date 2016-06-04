package _25.elementCollectionEmbeddableMap.service;

import javax.persistence.EntityManager;

import _25.elementCollectionEmbeddableMap.model.Employee25;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee25 createEmployee(String name, String surname, int salary) {
		Employee25 employee = new Employee25(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
