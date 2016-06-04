package _19.manyToMany.uni.service;

import javax.persistence.EntityManager;

import _19.manyToMany.uni.model.Employee19;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee19 createEmployee(String name, String surname, int salary) {
		Employee19 employee = new Employee19(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
