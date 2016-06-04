package _24.elementCollectionEnumMap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _24.elementCollectionEnumMap.model.Employee24;
import _24.elementCollectionEnumMap.model.PhoneType;
import _24.elementCollectionEnumMap.service.EmployeeService;
import _24.elementCollectionEnumMap.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee24 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		entityTransaction.commit();

		entityTransaction.begin();
		employee.getPhoneNumbers().put(PhoneType.HOME, "0216");
		employee.getPhoneNumbers().put(PhoneType.WORK, "0212");
		employee.getPhoneNumbers().put(PhoneType.MOBILE, "0555");
		entityTransaction.commit();
		
		System.out.println("Persisted : " + employee);

		entityManager.close();
		entityManagerFactory.close();

	}
}
