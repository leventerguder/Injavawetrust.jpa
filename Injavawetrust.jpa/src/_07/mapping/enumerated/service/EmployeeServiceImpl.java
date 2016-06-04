package _07.mapping.enumerated.service;

import javax.persistence.EntityManager;

import _07.mapping.enumerated.model.Employee7;
import _07.mapping.enumerated.model.EmployeeType;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee7 createEmployee(int id, String name, String surname, int salary,EmployeeType employeeType) {
		Employee7 employee = new Employee7(id, name, surname, salary,employeeType);
		entityManager.persist(employee);
		return employee;
	}

}
