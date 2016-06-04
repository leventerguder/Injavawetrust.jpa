package _26.oneToManyMap.service;

import javax.persistence.EntityManager;

import _26.oneToManyMap.model.Employee26;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee26 createEmployee(String name, String surname, int salary) {
		Employee26 employee = new Employee26(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
