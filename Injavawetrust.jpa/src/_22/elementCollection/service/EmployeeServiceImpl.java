package _22.elementCollection.service;

import javax.persistence.EntityManager;

import _22.elementCollection.model.Employee22;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee22 createEmployee(String name, String surname, int salary) {
		Employee22 employee = new Employee22(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
