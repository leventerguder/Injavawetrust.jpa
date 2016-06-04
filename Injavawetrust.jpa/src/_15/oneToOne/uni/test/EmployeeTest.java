package _15.oneToOne.uni.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _15.oneToOne.uni.model.Employee15;
import _15.oneToOne.uni.model.ParkingSpace;
import _15.oneToOne.uni.service.EmployeeService;
import _15.oneToOne.uni.service.EmployeeServiceImpl;
import _15.oneToOne.uni.service.ParkingService;
import _15.oneToOne.uni.service.ParkingServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

	entityTransaction.begin();
	Employee15 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
	Employee15 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
	Employee15 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);
	System.out.println("Persisted :" + employee2);
	System.out.println("Persisted :" + employee3);

	ParkingService parkingSpaceService = new ParkingServiceImpl(entityManager);

	entityTransaction.begin();
	ParkingSpace parkingSpace = parkingSpaceService.createParkingSpace(10, "Flat1");
	ParkingSpace parkingSpace2 = parkingSpaceService.createParkingSpace(20, "Flat2");
	ParkingSpace parkingSpace3 = parkingSpaceService.createParkingSpace(30, "Flat3");
	entityTransaction.commit();

	System.out.println("Persisted :" + parkingSpace);
	System.out.println("Persisted :" + parkingSpace2);
	System.out.println("Persisted :" + parkingSpace3);

	entityTransaction.begin();
	employee.setParkingSpace(parkingSpace);
	employee2.setParkingSpace(parkingSpace2);
	employee3.setParkingSpace(parkingSpace3);
	entityTransaction.commit();

	// @JoinColumn(name="parking_id", unique=true) unique true oldugu icin
	// ayni parkingSpace i eklememize izin vermez ! Calisma zamaninda hata
	// verecektir.
	//
	// entityTransaction.begin();
	// employee.setParkingSpace(parkingSpace);
	// employee2.setParkingSpace(parkingSpace);
	// employee3.setParkingSpace(parkingSpace);
	// entityTransaction.commit();

	entityManager.close();
	entityManagerFactory.close();

    }
}
