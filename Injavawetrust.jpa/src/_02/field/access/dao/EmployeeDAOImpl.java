package _02.field.access.dao;

import javax.persistence.EntityManager;
import _02.field.access.model.Employee2;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee2 insertEmployee(int id, String name, String surname, int salary) {
		Employee2 employee = new Employee2(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
