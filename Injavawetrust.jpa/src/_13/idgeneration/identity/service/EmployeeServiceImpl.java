package _13.idgeneration.identity.service;

import javax.persistence.EntityManager;

import _13.idgeneration.identity.model.Employee13;

public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager entityManager;

    public EmployeeServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Override
    public Employee13 createEmployee(String name, String surname, int salary) {
	Employee13 employee = new Employee13(name, surname, salary);
	entityManager.persist(employee);
	return employee;
    }

}
