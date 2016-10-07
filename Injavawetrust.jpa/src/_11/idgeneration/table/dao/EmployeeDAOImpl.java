package _11.idgeneration.table.dao;

import javax.persistence.EntityManager;
import _11.idgeneration.table.model.Employee11;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee11 insertEmployee(String name, String surname, int salary) {
		Employee11 employee = new Employee11(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
