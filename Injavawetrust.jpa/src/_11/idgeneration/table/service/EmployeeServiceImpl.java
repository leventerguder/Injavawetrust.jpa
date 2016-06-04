package _11.idgeneration.table.service;

import javax.persistence.EntityManager;
import _11.idgeneration.table.model.Employee11;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee11 createEmployee(String name, String surname, int salary) {
		Employee11 employee = new Employee11(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
