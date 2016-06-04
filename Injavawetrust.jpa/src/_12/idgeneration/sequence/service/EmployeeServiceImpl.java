package _12.idgeneration.sequence.service;

import javax.persistence.EntityManager;
import _12.idgeneration.sequence.model.Employee12;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee12 createEmployee(String name, String surname, int salary) {
		Employee12 employee = new Employee12(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
