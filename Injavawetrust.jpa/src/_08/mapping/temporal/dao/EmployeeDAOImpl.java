package _08.mapping.temporal.dao;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import _08.mapping.temporal.model.Employee8;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee8 insertEmployee(int id, String name, String surname, int salary,Date startDate, Calendar birthDate) {
		Employee8 employee = new Employee8(id, name, surname, salary,startDate,birthDate);
		entityManager.persist(employee);
		return employee;
	}

}
