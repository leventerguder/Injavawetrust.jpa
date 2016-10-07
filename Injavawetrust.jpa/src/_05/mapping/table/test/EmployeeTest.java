package _05.mapping.table.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _05.mapping.table.dao.EmployeeDAO;
import _05.mapping.table.dao.EmployeeDAOImpl;
import _05.mapping.table.model.Employee5;


public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee5 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000);
		Employee5 employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000);
		Employee5 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
