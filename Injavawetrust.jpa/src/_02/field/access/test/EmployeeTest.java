package _02.field.access.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _02.field.access.dao.EmployeeDAO;
import _02.field.access.dao.EmployeeDAOImpl;
import _02.field.access.model.Employee2;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee2 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000);
		Employee2 employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000);
		Employee2 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
