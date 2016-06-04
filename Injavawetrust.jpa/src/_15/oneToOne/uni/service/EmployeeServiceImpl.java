package _15.oneToOne.uni.service;

import javax.persistence.EntityManager;
import _15.oneToOne.uni.model.Employee15;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee15 createEmployee(String name, String surname, int salary) {
		Employee15 employee = new Employee15(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
