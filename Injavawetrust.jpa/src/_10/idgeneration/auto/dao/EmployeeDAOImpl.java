package _10.idgeneration.auto.dao;

import javax.persistence.EntityManager;

import _10.idgeneration.auto.model.Employee10;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee10 insertEmployee(String name, String surname, int salary) {
		Employee10 employee = new Employee10(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
