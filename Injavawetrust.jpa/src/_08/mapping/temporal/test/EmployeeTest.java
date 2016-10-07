package _08.mapping.temporal.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _08.mapping.temporal.dao.EmployeeDAO;
import _08.mapping.temporal.dao.EmployeeDAOImpl;
import _08.mapping.temporal.model.Employee8;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

	entityTransaction.begin();

	Calendar birthCalendar = prepareCalendarAndDate(1989, 5, 18);
	// 18.06.1989
	Date startDate = prepareCalendarAndDate(2013, 9, 7).getTime();
	// 07.10.2013

	Calendar birthCalendar2 = prepareCalendarAndDate(1955, 4, 19);
	Date startDate2 = prepareCalendarAndDate(2011, 7, 1).getTime();

	Calendar birthCalendar3 = prepareCalendarAndDate(1961, 7, 28);
	Date startDate3 = prepareCalendarAndDate(2004, 6, 1).getTime();

	Employee8 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000,
		startDate, birthCalendar);
	Employee8 employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000,
		startDate2, birthCalendar2);
	Employee8 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000,
		startDate3, birthCalendar3);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);
	System.out.println("Persisted :" + employee2);
	System.out.println("Persisted :" + employee3);

	entityManager.close();
	entityManagerFactory.close();

    }

    public static Calendar prepareCalendarAndDate(int year, int month, int day) {
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.YEAR, year);
	calendar.set(Calendar.MONTH, month);// Not : Ocak/June --> 0 dan baslar.
	calendar.set(Calendar.DAY_OF_MONTH, day);

		return calendar;
	}
}
