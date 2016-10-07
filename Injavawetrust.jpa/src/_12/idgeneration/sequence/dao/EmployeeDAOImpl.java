package _12.idgeneration.sequence.dao;

import javax.persistence.EntityManager;
import _12.idgeneration.sequence.model.Employee12;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee12 insertEmployee(String name, String surname, int salary) {
		Employee12 employee = new Employee12(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

}
