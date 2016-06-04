package _19.manyToMany.uni.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _19.manyToMany.uni.model.Employee19;
import _19.manyToMany.uni.model.Project;
import _19.manyToMany.uni.service.EmployeeService;
import _19.manyToMany.uni.service.EmployeeServiceImpl;
import _19.manyToMany.uni.service.ProjectService;
import _19.manyToMany.uni.service.ProjectServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee19 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee19 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee19 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee);

		ProjectService phoneService = new ProjectServiceImpl(entityManager);

		entityTransaction.begin();
		Project project = phoneService.createProject("Project1");
		Project project2 = phoneService.createProject("Project2");
		Project project3 = phoneService.createProject("Project3");
		entityTransaction.commit();

		System.out.println("Persisted :" + project);
		System.out.println("Persisted :" + project2);
		System.out.println("Persisted :" + project3);

		entityTransaction.begin();
		employee.getProjects().add(project);
		employee.getProjects().add(project2);

		employee2.getProjects().add(project2);
		employee2.getProjects().add(project3);

		employee3.getProjects().add(project);
		employee3.getProjects().add(project2);
		employee3.getProjects().add(project3);
		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
