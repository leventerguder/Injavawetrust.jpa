package _06.mapping.column.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _06.mapping.column.model.Employee6;
import _06.mapping.column.service.EmployeeService;
import _06.mapping.column.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee6 employee = employeeService.createEmployee(1, "Levent", "Erguder", 1000);
		Employee6 employee2 = employeeService.createEmployee(2, "James", "Gosling", 10000);
		Employee6 employee3 = employeeService.createEmployee(3, "Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
