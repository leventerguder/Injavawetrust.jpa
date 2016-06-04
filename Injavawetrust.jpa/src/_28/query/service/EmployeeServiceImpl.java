package _28.query.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import _28.query.model.Employee28;

public class EmployeeServiceImpl implements EmployeeService {

	private static final String QUERY = "SELECT e.salary FROM Employee28 e  where e.id = :empId ";

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public EmployeeServiceImpl() {

		entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		// create Dynamic Named Query
		TypedQuery<Integer> query = entityManager.createQuery(QUERY, Integer.class);
		entityManagerFactory.addNamedQuery("Employee.findSalary", query);
	}

	@Override
	public Employee28 createEmployee(String name, String surname, int salary) {
		Employee28 employee = new Employee28(name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public List<Employee28> findAllEmployees() {
		TypedQuery<Employee28> query = entityManager.createNamedQuery("Employee.findAll", Employee28.class);
		return query.getResultList();
	}

	@Override
	public Employee28 getEmployeeById(int id) {
		TypedQuery<Employee28> query = entityManager.createNamedQuery("Employee.findByPrimaryKey", Employee28.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Employee28 getEmployeeByName(String name) {
		TypedQuery<Employee28> query = entityManager.createNamedQuery("Employee.findByName", Employee28.class)
				.setParameter("name", name);
		return query.getSingleResult();
	}

	@Override
	public int getEmployeeSalaryById(int id) {
		TypedQuery<Integer> query= entityManager.createNamedQuery("Employee.findSalary", Integer.class).
				setParameter("empId", id);
		return query.getSingleResult();

	}
}
