package _25.elementCollectionEmbeddableMap.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _25.elementCollectionEmbeddableMap.model.Employee25;
import _25.elementCollectionEmbeddableMap.model.Vacation;
import _25.elementCollectionEmbeddableMap.service.EmployeeService;
import _25.elementCollectionEmbeddableMap.service.EmployeeServiceImpl;
import _25.elementCollectionEmbeddableMap.service.VacationService;
import _25.elementCollectionEmbeddableMap.service.VacationServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee25 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		entityTransaction.commit();

	
		VacationService vacationService = new VacationServiceImpl();
		Vacation vacation1 = vacationService.createVacation(new Date(), 5);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		Vacation vacation2 = vacationService.createVacation(cal.getTime(), 3);

		entityTransaction.begin();
		employee.getVacations().put("key1", vacation1);
		employee.getVacations().put("key2", vacation2);
		entityTransaction.commit();
		
		System.out.println("Persisted : " + employee);
		
		entityManager.close();
		entityManagerFactory.close();

	}
}
