package _06.mapping.column.dao;

import javax.persistence.EntityManager;

import _06.mapping.column.model.Employee6;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee6 insertEmployee(int id, String name, String surname, int salary) {
		Employee6 employee = new Employee6(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
