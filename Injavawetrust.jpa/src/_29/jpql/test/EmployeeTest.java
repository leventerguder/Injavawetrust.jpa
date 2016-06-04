package _29.jpql.test;

import static _29.jpql.service.JPQLQuery.*;

import java.util.List;

import javax.persistence.EntityTransaction;

import _29.jpql.model.Department4;
import _29.jpql.model.Employee29;
import _29.jpql.model.EmployeeDetails;
import _29.jpql.service.JPQLServiceImpl;

public class EmployeeTest {

	public static void main(String[] args) {

		JPQLServiceImpl jpqlService = new JPQLServiceImpl();
		//
		Employee29 employee1 = jpqlService.createEmployee("Levent", "Erguder", 1000);
		Employee29 employee2 = jpqlService.createEmployee("James", "Gosling", 10000);
		Employee29 employee3 = jpqlService.createEmployee("Joshua", "Bloch", 6000);
		Employee29 employee4 = jpqlService.createEmployee("Kathy", "Sierra", 4000);
		Employee29 employee5 = jpqlService.createEmployee("Linda", "DeMichiel", 300);
		Employee29 employee6 = jpqlService.createEmployee("Rod ", "Johnson ", 5000);
		Employee29 employee7 = jpqlService.createEmployee("Gavin", "King", 5000);

		//
		Department4 department1 = jpqlService.createDepartment("Software Deparment 1");
		Department4 department2 = jpqlService.createDepartment("Software Department 2");
		Department4 department3 = jpqlService.createDepartment("Software Department 3");

		EntityTransaction entityTransaction = jpqlService.getEntityManager().getTransaction();
		entityTransaction.begin();

		department1.addEmployee(employee1);
		department1.addEmployee(employee2);

		department2.addEmployee(employee3);
		department2.addEmployee(employee4);
		department2.addEmployee(employee5);

		department3.addEmployee(employee6);
		department3.addEmployee(employee7);

		entityTransaction.commit();

		System.out.println("SELECT_ALL_EMPLOYEES");

		List<Employee29> allEmployeeList = jpqlService.executeResultListQuery(SELECT_ALL_EMPLOYEES, Employee29.class);

		for (Employee29 emp : allEmployeeList) {
			System.out.println(emp);
		}

		System.out.println("SELECT_NAME_OF_EMPLOYEES");
		List<String> employeeNameList = jpqlService.executeResultListQuery(SELECT_NAME_OF_EMPLOYEES, String.class);

		for (String name : employeeNameList) {
			System.out.println(name);
		}

		System.out.println("SELECT_NAME_AND_SALARY");
		List<Object[]> nameAndSalaryList = jpqlService.executeResultListQuery(SELECT_NAME_AND_SALARY, Object[].class);

		for (Object[] nameAndSalaryElement : nameAndSalaryList) {
			System.out.println(nameAndSalaryElement[0] + " " + nameAndSalaryElement[1]);
		}

		System.out.println("SELECT_EMPLOYEE_DETAILS");
		List<EmployeeDetails> employeeDetailsList = jpqlService.executeResultListQuery(SELECT_EMPLOYEE_DETAILS,
				EmployeeDetails.class);
		for (EmployeeDetails empDetails : employeeDetailsList) {
			System.out.println(empDetails);
		}

		System.out.println("JOIN_SELECT_EMPLOYEE_AND_DEPARTMENT");
		List<Department4> departmentJoinList = jpqlService.executeResultListQuery(JOIN_SELECT_EMPLOYEE_AND_DEPARTMENT,
				Department4.class);

		for (Department4 dept : departmentJoinList) {
			System.out.println(dept);
		}

		System.out.println("SELECT_ALL_DEPARTMENTS_FROM_EMPLOYEE");
		List<Department4> departmentFromEmployeeList = jpqlService.executeResultListQuery(
				SELECT_ALL_DEPARTMENTS_FROM_EMPLOYEE, Department4.class);

		for (Department4 dept : departmentFromEmployeeList) {
			System.out.println(dept);
		}

	}
}
