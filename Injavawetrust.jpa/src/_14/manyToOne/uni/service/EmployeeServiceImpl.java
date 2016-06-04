package _14.manyToOne.uni.service;

import javax.persistence.EntityManager;

import _14.manyToOne.uni.model.Employee14;

public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager entityManager;

    public EmployeeServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Override
    public Employee14 createEmployee(String name, String surname, int salary) {
	Employee14 employee = new Employee14(name, surname, salary);
	entityManager.persist(employee);
	return employee;
    }

    @Override
    public Employee14 findEmployee(int id) {
	return entityManager.find(Employee14.class, id);
    }

}
