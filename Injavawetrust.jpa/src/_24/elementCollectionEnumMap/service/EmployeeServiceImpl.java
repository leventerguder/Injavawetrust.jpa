package _24.elementCollectionEnumMap.service;

import javax.persistence.EntityManager;

import _24.elementCollectionEnumMap.model.Employee24;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee24 createEmployee(String name, String surname, int salary) {
		Employee24 employee = new Employee24(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}