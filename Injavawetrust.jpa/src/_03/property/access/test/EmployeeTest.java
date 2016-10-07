package _03.property.access.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _03.property.access.dao.EmployeeDAO;
import _03.property.access.dao.EmployeeDAOImpl;
import _03.property.access.model.Employee3;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee3 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000);
		Employee3 Employee3 = employeeService.insertEmployee(2, "James", "Gosling", 10000);
		Employee3 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + Employee3);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
