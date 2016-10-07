package _07.mapping.enumerated.dao;

import javax.persistence.EntityManager;

import _07.mapping.enumerated.model.Employee7;
import _07.mapping.enumerated.model.EmployeeType;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee7 insertEmployee(int id, String name, String surname, int salary,EmployeeType employeeType) {
		Employee7 employee = new Employee7(id, name, surname, salary,employeeType);
		entityManager.persist(employee);
		return employee;
	}

}
