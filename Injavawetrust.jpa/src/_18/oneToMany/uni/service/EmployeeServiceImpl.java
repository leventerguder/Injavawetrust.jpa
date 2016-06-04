package _18.oneToMany.uni.service;

import javax.persistence.EntityManager;

import _18.oneToMany.uni.model.Employee18;

public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager entityManager;

    public EmployeeServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Override
    public Employee18 createEmployee(String name, String surname, int salary) {
	Employee18 employee = new Employee18(name, surname, salary);
	entityManager.persist(employee);
	return employee;
    }

    @Override
    public Employee18 findEmployee(int id) {
	return entityManager.find(Employee18.class, id);
    }

}
