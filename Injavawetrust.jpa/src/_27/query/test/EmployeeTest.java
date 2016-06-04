package _27.query.test;

import java.util.List;

import _27.query.model.Employee27;
import _27.query.service.EmployeeService;
import _27.query.service.EmployeeServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeServiceImpl();

		Employee27 employee = employeeService.createEmployee("Levent", "Erguder", 1000);
		Employee27 employee2 = employeeService.createEmployee("James", "Gosling", 10000);
		Employee27 employee3 = employeeService.createEmployee("Joshua", "Bloch", 10000);

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		System.out.println("findAllEmployees");
		List<Employee27> allEmployees = employeeService.findAllEmployees();
		for (Employee27 emp : allEmployees) {
			System.out.println(emp);
		}

		System.out.println("getEmployeeNames");
		List<String> employeeNames = employeeService.getEmployeeNames();

		for (String emp : employeeNames) {
			System.out.println(emp);
		}

		System.out.println("getEmployeeNameById");
		String employeeName = employeeService.getEmployeeNameById(1);
		System.out.println(employeeName);

		// int
		// salary=employeeService.getEmployeeSalaryByName("'XXXX' OR e.name='James' ");

		System.out.println("getEmployeeSalaryByName");
		String name = "Levent";
		int salary = employeeService.getEmployeeSalaryByName(name);
		System.out.println(name + "'s salary :" + salary);

	}
}
