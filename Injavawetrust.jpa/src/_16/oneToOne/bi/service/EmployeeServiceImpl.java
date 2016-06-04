package _16.oneToOne.bi.service;

import javax.persistence.EntityManager;
import _16.oneToOne.bi.model.Employee16;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee16 createEmployee(String name, String surname, int salary) {
		Employee16 employee = new Employee16(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}
}
