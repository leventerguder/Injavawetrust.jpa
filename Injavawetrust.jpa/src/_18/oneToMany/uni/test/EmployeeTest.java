package _18.oneToMany.uni.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _18.oneToMany.uni.model.Employee18;
import _18.oneToMany.uni.model.Phone;
import _18.oneToMany.uni.service.EmployeeService;
import _18.oneToMany.uni.service.EmployeeServiceImpl;
import _18.oneToMany.uni.service.PhoneService;
import _18.oneToMany.uni.service.PhoneServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

	entityTransaction.begin();
	Employee18 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);

	PhoneService phoneService = new PhoneServiceImpl(entityManager);

	entityTransaction.begin();
	Phone phone = phoneService.createPhone("0555", "Mobile");
	Phone phone2 = phoneService.createPhone("216", "Home");
	Phone phone3 = phoneService.createPhone("212", "Work");
	entityTransaction.commit();

	System.out.println("Persisted :" + phone);
	System.out.println("Persisted :" + phone2);
	System.out.println("Persisted :" + phone3);

	entityTransaction.begin();
	employee.getPhones().add(phone);
	employee.getPhones().add(phone2);
	employee.getPhones().add(phone3);
	entityTransaction.commit();

	entityManager.close();
	entityManagerFactory.close();

    }
}
