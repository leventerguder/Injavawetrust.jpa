package _07.mapping.enumerated.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _07.mapping.enumerated.dao.EmployeeDAO;
import _07.mapping.enumerated.dao.EmployeeDAOImpl;
import _07.mapping.enumerated.model.Employee7;
import _07.mapping.enumerated.model.EmployeeType;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee7 employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000, EmployeeType.PART_TIME_EMPLOYEE);
		Employee7 employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000, EmployeeType.CONTRACT_EMPLOYE);
		Employee7 employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000, EmployeeType.FULL_TIME_EMPLOYEE);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		entityManager.close();
		entityManagerFactory.close();

	}
}
