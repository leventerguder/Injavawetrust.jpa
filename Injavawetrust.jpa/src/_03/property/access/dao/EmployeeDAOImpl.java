package _03.property.access.dao;

import javax.persistence.EntityManager;
import _03.property.access.model.Employee3;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee3 insertEmployee(int id, String name, String surname, int salary) {
		Employee3 employee = new Employee3(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}
}
