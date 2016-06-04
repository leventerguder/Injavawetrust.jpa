package _27.query.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import _27.query.model.Employee27;

public class EmployeeServiceImpl implements EmployeeService {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EmployeeServiceImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public Employee27 createEmployee(String name, String surname, int salary) {
		Employee27 employee = new Employee27(name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public List<Employee27> findAllEmployees() {
		// //Query query =
		// entityManager.createQuery("Select e from Employee27 e",
		// Employee27.class);

		// Query ya da TypedQuery kullanabiliriz.

		TypedQuery<Employee27> query = entityManager.createQuery("Select e from Employee27 e", Employee27.class);
		return query.getResultList();

	}

	@Override
	public List<String> getEmployeeNames() {
		TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee27 e", String.class);
		return query.getResultList();
	}

	@Override
	public String getEmployeeNameById(int id) {

		// TypedQuery<String> query =
		// entityManager.createQuery("Select e.name from Employee e where e.id= ?1",
		// String.class).setParameter(1, id);

		TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee27 e where e.id= :empId",
				String.class).setParameter("empId", id);
		return query.getSingleResult();
	}

	@Override
	public int getEmployeeSalaryByName(String name) {
		 //TypedQuery<Integer> query = entityManager.createQuery("Select e.salary from Employee27 e where e.name= "
		 //+ name,Integer.class);

		TypedQuery<Integer> query = entityManager.createQuery(
				"Select e.salary from Employee27 e where e.name=:nameParam", Integer.class).setParameter("nameParam",
				name);
		return query.getSingleResult();
	}

}
