package _17.oneToMany.bi.test;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _17.oneToMany.bi.model.Department2;
import _17.oneToMany.bi.model.Employee17;
import _17.oneToMany.bi.service.DepartmentService;
import _17.oneToMany.bi.service.DepartmentServiceImpl;
import _17.oneToMany.bi.service.EmployeeService;
import _17.oneToMany.bi.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee17 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee17 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee17 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		DepartmentService departmentService = new DepartmentServiceImpl(entityManager);

		entityTransaction.begin();
		Department2 department = departmentService.createDepartment("Junior Developers Dept.");
		Department2 department2 = departmentService.createDepartment("Master Developers Dept.");
		entityTransaction.commit();

		System.out.println("Persisted :" + department);
		System.out.println("Persisted :" + department2);

		entityTransaction.begin();

		employee.setDepartment(department);
		department.getEmployees().add(employee);

		employee2.setDepartment(department2);
		department2.getEmployees().add(employee2);

		employee3.setDepartment(department2);
		department2.getEmployees().add(employee3);

		entityTransaction.commit();

		System.out.println("finding...");
		Department2 foundDepartment = departmentService.findDepartment(5);
		if (foundDepartment != null) {
			Collection<Employee17> employees = foundDepartment.getEmployees();
			System.out.println(employees);
		}

		entityManager.close();
		entityManagerFactory.close();

	}
}
