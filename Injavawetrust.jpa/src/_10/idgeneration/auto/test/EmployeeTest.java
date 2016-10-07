package _10.idgeneration.auto.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _10.idgeneration.auto.dao.EmployeeDAO;
import _10.idgeneration.auto.dao.EmployeeDAOImpl;
import _10.idgeneration.auto.model.Employee10;

public class EmployeeTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");
		// Hibernate icin Persistence Unit

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee10 employee = employeeService.insertEmployee("Levent", "Erguder", 1000);
		Employee10 Employee2 = employeeService.insertEmployee("James", "Gosling", 10000);
		Employee10 employee3 = employeeService.insertEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + Employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
