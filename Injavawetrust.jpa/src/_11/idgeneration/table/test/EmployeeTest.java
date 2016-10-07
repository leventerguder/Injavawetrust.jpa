package _11.idgeneration.table.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _11.idgeneration.table.dao.EmployeeDAO;
import _11.idgeneration.table.dao.EmployeeDAOImpl;
import _11.idgeneration.table.model.Employee11;

public class EmployeeTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee11 employee = employeeService.insertEmployee("Levent", "Erguder", 1000);
		Employee11 Employee2 = employeeService.insertEmployee("James", "Gosling", 10000);
		Employee11 employee3 = employeeService.insertEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + Employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
