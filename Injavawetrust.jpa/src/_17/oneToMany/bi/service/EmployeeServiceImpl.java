package _17.oneToMany.bi.service;

import javax.persistence.EntityManager;

import _17.oneToMany.bi.model.Employee17;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee17 createEmployee(String name, String surname, int salary) {
		Employee17 employee = new Employee17(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public Employee17 findEmployee(int id) {
		return entityManager.find(Employee17.class, id);
	}

}
