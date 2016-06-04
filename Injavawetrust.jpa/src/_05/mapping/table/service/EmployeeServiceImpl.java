package _05.mapping.table.service;

import javax.persistence.EntityManager;

import _05.mapping.table.model.Employee5;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee5 createEmployee(int id, String name, String surname, int salary) {
		Employee5 employee = new Employee5(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
