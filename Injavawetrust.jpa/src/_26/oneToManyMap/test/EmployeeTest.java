package _26.oneToManyMap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _26.oneToManyMap.model.Department3;
import _26.oneToManyMap.model.Employee26;
import _26.oneToManyMap.service.DepartmentService;
import _26.oneToManyMap.service.DepartmentServiceImpl;
import _26.oneToManyMap.service.EmployeeService;
import _26.oneToManyMap.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee26 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee26 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee26 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		DepartmentService departmentService = new DepartmentServiceImpl(entityManager);

		entityTransaction.begin();
		Department3 department = departmentService.createDepartment("Junior Developers Dept.");
		Department3 department2 = departmentService.createDepartment("Master Developers Dept.");
		entityTransaction.commit();
		

		entityTransaction.begin();

		employee.setDepartment(department);
		department.getEmployeesMap().put("key1", employee);

		employee2.setDepartment(department2);
		department2.getEmployeesMap().put("key2", employee2);

		employee3.setDepartment(department2);
		department2.getEmployeesMap().put("key3", employee3);

		entityTransaction.commit();
		
		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);
		System.out.println("Persisted :" + department);
		System.out.println("Persisted :" + department2);

		entityManager.close();
		entityManagerFactory.close();

	}
}
