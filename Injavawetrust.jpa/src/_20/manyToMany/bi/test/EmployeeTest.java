package _20.manyToMany.bi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _20.manyToMany.bi.model.Employee20;
import _20.manyToMany.bi.model.Project2;
import _20.manyToMany.bi.service.EmployeeService;
import _20.manyToMany.bi.service.EmployeeServiceImpl;
import _20.manyToMany.bi.service.ProjectService;
import _20.manyToMany.bi.service.ProjectServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

		entityTransaction.begin();
		Employee20 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee20 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee20 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee);

		ProjectService phoneService = new ProjectServiceImpl(entityManager);

		entityTransaction.begin();
		Project2 project = phoneService.createProject("Project1");
		Project2 project2 = phoneService.createProject("Project2");
		Project2 project3 = phoneService.createProject("Project3");
		entityTransaction.commit();

		System.out.println("Persisted :" + project);
		System.out.println("Persisted :" + project2);
		System.out.println("Persisted :" + project3);

		entityTransaction.begin();
		// bidirectional bir iliskide karsilikli olarak elemanlari List'lere
		// eklememiz gereklidir.
		//addLists metodunda
		// List<Project2> project2;
		// List<Employee20> employees;
		// listelerine elemanlar eklenmektedir.
		
		employee.addLists(project);
		
		//addLists metotu yerine su sekilde de yapabiliriz. 
		//employee.getProjects().add(project);
		//project.getEmployees().add(employee);
		
		employee.addLists(project2);

		employee2.addLists(project2);
		employee2.addLists(project3);

		employee3.addLists(project);
		employee3.addLists(project2);
		employee3.addLists(project3);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
		
		

	}
}
