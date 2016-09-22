package _01.hello.eclipselink.test;

import java.util.List;

import _01.hello.eclipselink.dao.EmployeeDAO;
import _01.hello.eclipselink.dao.EmployeeDAOImpl;
import _01.hello.eclipselink.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		EmployeeDAO employeeService = new EmployeeDAOImpl();

		Employee employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000);
		Employee employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000);
		Employee employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000);

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		Employee employee4 = employeeService.findEmployee(1);
		System.out.println("Found : " + employee4);

		Employee employee5 = employeeService.raiseEmployeeSalary(1, 1000);

		System.out.println("Updated : " + employee5);

		employeeService.removeEmployee(1);

		System.out.println("Removed Employee id:" + 1);

		System.out.println("findAllEmployees");
		List<Employee> employees = employeeService.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println("Found : " + emp);
		}

	}
}
