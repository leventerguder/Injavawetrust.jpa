package _05.mapping.table.dao;

import javax.persistence.EntityManager;

import _05.mapping.table.model.Employee5;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee5 insertEmployee(int id, String name, String surname, int salary) {
		Employee5 employee = new Employee5(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
