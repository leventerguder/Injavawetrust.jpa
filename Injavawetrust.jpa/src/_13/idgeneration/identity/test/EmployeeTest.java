package _13.idgeneration.identity.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _13.idgeneration.identity.model.Employee13;
import _13.idgeneration.identity.service.EmployeeService;
import _13.idgeneration.identity.service.EmployeeServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

	entityTransaction.begin();
	Employee13 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
	Employee13 Employee2 = employeeService.createEmployee("James", "Gosling", 10000);
	Employee13 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);
	System.out.println("Persisted :" + Employee2);
	System.out.println("Persisted :" + employee3);

	entityManager.close();
	entityManagerFactory.close();

    }
}
