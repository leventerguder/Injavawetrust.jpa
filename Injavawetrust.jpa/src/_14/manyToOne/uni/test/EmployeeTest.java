package _14.manyToOne.uni.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _14.manyToOne.uni.model.Department;
import _14.manyToOne.uni.model.Employee14;
import _14.manyToOne.uni.service.DepartmentService;
import _14.manyToOne.uni.service.DepartmentServiceImpl;
import _14.manyToOne.uni.service.EmployeeService;
import _14.manyToOne.uni.service.EmployeeServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	EmployeeService employeeService = new EmployeeServiceImpl(entityManager);

	entityTransaction.begin();
	Employee14 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
	Employee14 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
	Employee14 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);
	entityTransaction.commit();

	System.out.println("Persisted :" + employee);
	System.out.println("Persisted :" + employee2);
	System.out.println("Persisted :" + employee3);

	DepartmentService departmentService = new DepartmentServiceImpl(entityManager);

	entityTransaction.begin();
	Department department = departmentService.createDepartment("Junior Developers Dept.");
	Department department2 = departmentService.createDepartment("Master Developers Dept.");
	entityTransaction.commit();

	System.out.println("Persisted :" + department);
	System.out.println("Persisted :" + department2);

	entityTransaction.begin();
	employee.setDepartment(department);
	employee2.setDepartment(department2);
	employee3.setDepartment(department2);
	entityTransaction.commit();

	System.out.println("Finding...");
	Employee14 emp = employeeService.findEmployee(1);
	System.out.println(emp);

	entityManager.close();
	entityManagerFactory.close();

    }
}
