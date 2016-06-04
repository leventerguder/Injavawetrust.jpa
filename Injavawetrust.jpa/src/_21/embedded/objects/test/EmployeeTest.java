package _21.embedded.objects.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _21.embedded.objects.model.Address;
import _21.embedded.objects.model.Employee21;
import _21.embedded.objects.service.AddressService;
import _21.embedded.objects.service.AddressServiceImpl;
import _21.embedded.objects.service.EmployeeService;
import _21.embedded.objects.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee21 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);

		AddressService addressService = new AddressServiceImpl();
		Address address = addressService.createAddress("myStreet", "myRoad", "37", "Istanbul", "34000");

		entityTransaction.begin();
		employee.setAddress(address);
		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
