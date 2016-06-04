package _16.oneToOne.bi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _16.oneToOne.bi.model.Employee16;
import _16.oneToOne.bi.model.ParkingSpace2;
import _16.oneToOne.bi.service.EmployeeService;
import _16.oneToOne.bi.service.EmployeeServiceImpl;
import _16.oneToOne.bi.service.ParkingService;
import _16.oneToOne.bi.service.ParkingServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

	entityTransaction.begin();
	Employee16 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
	Employee16 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
	Employee16 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);
	System.out.println("Persisted :" + employee2);
	System.out.println("Persisted :" + employee3);

	ParkingService parkingSpaceService = new ParkingServiceImpl(entityManager);

	entityTransaction.begin();
	ParkingSpace2 parkingSpace = parkingSpaceService.createParkingSpace(10, "Flat1");
	ParkingSpace2 parkingSpace2 = parkingSpaceService.createParkingSpace(20, "Flat2");
	ParkingSpace2 parkingSpace3 = parkingSpaceService.createParkingSpace(30, "Flat3");
	entityTransaction.commit();

	System.out.println("Persisted :" + parkingSpace);
	System.out.println("Persisted :" + parkingSpace2);
	System.out.println("Persisted :" + parkingSpace3);

	entityTransaction.begin();
	employee.setParkingSpace(parkingSpace);
	parkingSpace.setEmployee(employee);

	employee2.setParkingSpace(parkingSpace2);
	parkingSpace2.setEmployee(employee2);

	employee3.setParkingSpace(parkingSpace3);
	parkingSpace3.setEmployee(employee3);

	// Bidirectional iliskinin dogru sekilde calismasi icin karsilikli
	// olarak setter metodunu kullanmak gereklidir.
	// Bu islem otomatik olarak yapilmaz!
	// Eger karsilikli olarak setter calistirilmazsa find islemi sonrasinda
	entityTransaction.commit();

	ParkingSpace2 foundParkingSpace = parkingSpaceService.findParkingSpace(4);

	if (foundParkingSpace != null) {
	    Employee16 emp = foundParkingSpace.getEmployee();
	    System.out.println(emp.getName() + " " + emp.getSurname() + " " + emp.getSalary());
	}
	entityManager.close();
	entityManagerFactory.close();

    }
}
