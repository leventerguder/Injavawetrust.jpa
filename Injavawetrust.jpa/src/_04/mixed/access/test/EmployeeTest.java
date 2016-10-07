package _04.mixed.access.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _04.mixed.access.model.Employee4;
import _04.mixed.access.service.EmployeeDAO;
import _04.mixed.access.service.EmployeeDAOImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee4 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000, "555 000 00 00");
		Employee4 employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000, "200 400 50");
		Employee4 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000, "300 500 70");
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
