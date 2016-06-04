package _23.elementCollectionStringMap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _23.elementCollectionStringMap.model.Employee23;
import _23.elementCollectionStringMap.service.EmployeeService;
import _23.elementCollectionStringMap.service.EmployeeServiceImpl;


public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee23 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		entityTransaction.commit();

		entityTransaction.begin();
		employee.getPhoneNumbers().put("Home", "0216");
		employee.getPhoneNumbers().put("Work", "0212");
		employee.getPhoneNumbers().put("Mobile", "055");
		entityTransaction.commit();

		System.out.println("Persisted : " + employee);
		
		
		entityManager.close();
		entityManagerFactory.close();

	}
}
