package _22.elementCollection.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _22.elementCollection.model.Employee22;
import _22.elementCollection.model.Vacation;
import _22.elementCollection.service.EmployeeService;
import _22.elementCollection.service.EmployeeServiceImpl;
import _22.elementCollection.service.VacationService;
import _22.elementCollection.service.VacationServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee22 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		entityTransaction.commit();

		System.out.println("Persisted : " + employee);

		VacationService vacationService = new VacationServiceImpl();
		Vacation vacation1 = vacationService.createVacation(new Date(), 5);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		Vacation vacation2 = vacationService.createVacation(cal.getTime(), 3);

		entityTransaction.begin();
		employee.getVacations().add(vacation1);
		employee.getVacations().add(vacation2);
		employee.getEmails().add("erguder.levent@gmail.com");
		employee.getEmails().add("injavawetrust@gmail.com");
		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
