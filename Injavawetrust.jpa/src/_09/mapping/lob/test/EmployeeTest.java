package _09.mapping.lob.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _09.mapping.lob.dao.EmployeeDAO;
import _09.mapping.lob.dao.EmployeeDAOImpl;
import _09.mapping.lob.model.Employee9;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		byte[] picture = { 1, 5, 6, 7, 2, 5, 10, 22, 40, 50 };
		// picture byte , sample

		entityTransaction.begin();
		Employee9 employee = employeeService.createEmployee(1, "Levent", "Erguder", 1000, picture);
		Employee9 employee2 = employeeService.createEmployee(2, "James", "Gosling", 10000, picture);
		Employee9 employee3 = employeeService.createEmployee(3, "Joshua", "Bloch", 10000, picture);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
