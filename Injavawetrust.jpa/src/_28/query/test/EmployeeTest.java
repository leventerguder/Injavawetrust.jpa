package _28.query.test;

import java.util.List;

import _28.query.model.Employee28;
import _28.query.service.EmployeeService;
import _28.query.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeServiceImpl();

		Employee28 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee28 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee28 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		System.out.println("findAllEmployees");
		List<Employee28> allEmployees = employeeService.findAllEmployees();
		for (Employee28 emp : allEmployees) {
			System.out.println(emp);
		}

		System.out.println("getEmployeeById");
		Employee28 foundEmployeeById = employeeService.getEmployeeById(1);
		System.out.println(foundEmployeeById);

		System.out.println("getEmployeeByName");
		Employee28 foundEmployeeByName = employeeService.getEmployeeByName("James");
		System.out.println(foundEmployeeByName);

		System.out.println("getEmployeeSalaryById");
		int salary = employeeService.getEmployeeSalaryById(2);
		System.out.println("salary : " + salary);

	}
}
