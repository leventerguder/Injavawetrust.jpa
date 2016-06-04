package _20.manyToMany.bi.service;

import javax.persistence.EntityManager;
import _20.manyToMany.bi.model.Employee20;

public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager entityManager;

	public EmployeeServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee20 createEmployee(String name, String surname, int salary) {
		Employee20 employee = new Employee20(name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public Employee20 findEmployee(int id) {
		return entityManager.find(Employee20.class, id);
	}

}
