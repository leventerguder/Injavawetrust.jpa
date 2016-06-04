package _09.mapping.lob.service;

import javax.persistence.EntityManager;

import _09.mapping.lob.model.Employee9;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee9 createEmployee(int id, String name, String surname, int salary,byte [] picture) {
		Employee9 employee = new Employee9(id, name, surname, salary,picture);
		entityManager.persist(employee);
		return employee;
	}

}
