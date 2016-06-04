package _06.mapping.column.service;

import javax.persistence.EntityManager;

import _06.mapping.column.model.Employee6;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee6 createEmployee(int id, String name, String surname, int salary) {
		Employee6 employee = new Employee6(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
