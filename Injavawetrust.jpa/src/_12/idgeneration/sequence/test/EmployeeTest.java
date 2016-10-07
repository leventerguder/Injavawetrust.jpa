package _12.idgeneration.sequence.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _12.idgeneration.sequence.dao.EmployeeDAO;
import _12.idgeneration.sequence.dao.EmployeeDAOImpl;
import _12.idgeneration.sequence.model.Employee12;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");		
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee12 employee = employeeService.insertEmployee("Levent", "Erguder", 1000);
		Employee12 Employee2 = employeeService.insertEmployee("James", "Gosling", 10000);
		Employee12 employee3 = employeeService.insertEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + Employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
