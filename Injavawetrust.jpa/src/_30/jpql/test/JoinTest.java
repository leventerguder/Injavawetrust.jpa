package _30.jpql.test;

import static _30.jpql.service.JPQLQuery.*;

import java.util.List;

import javax.persistence.EntityTransaction;

import _30.jpql.model.Address2;
import _30.jpql.model.Department5;
import _30.jpql.model.Employee30;
import _30.jpql.model.Phone2;
import _30.jpql.model.PhoneType;
import _30.jpql.model.Project3;
import _30.jpql.service.JPQLServiceImpl;

public class JoinTest {

	public static void main(String[] args) {

		JPQLServiceImpl jpqlService = new JPQLServiceImpl();
		EntityTransaction entityTransaction = jpqlService.getEntityManager().getTransaction();
		System.out.println("Preparing Employee Data...");
		//
		Employee30 employee1 = jpqlService.createEmployee("John", "Robbins", 55000);
		Employee30 employee2 = jpqlService.createEmployee("Rob", "Freeman", 53000);
		Employee30 employee3 = jpqlService.createEmployee("Peter", "Gunton", 40000);
		Employee30 employee4 = jpqlService.createEmployee("Frank", " Sadler", 41000);
		Employee30 employee5 = jpqlService.createEmployee("Scott", "Brown", 60000);
		Employee30 employee6 = jpqlService.createEmployee("Rod ", "Johnson ", 62000);
		Employee30 employee7 = jpqlService.createEmployee("Sue", "Bellows", 54000);
		Employee30 employee8 = jpqlService.createEmployee("Stephanie", "Whitmore", 45000);
		Employee30 employee9 = jpqlService.createEmployee("Jennifer", "Libby", 52000);
		Employee30 employee10 = jpqlService.createEmployee("Sarah", "Proval", 59000);
		Employee30 employee11 = jpqlService.createEmployee("Marcus", "Ragno", 35000);
		Employee30 employee12 = jpqlService.createEmployee("Joe", "Hatlen", 36000);
		@SuppressWarnings("unused")
		Employee30 employee13 = jpqlService.createEmployee("Jack", "Snooze", 43000);


		//
		Phone2 phone1 = jpqlService.createPhone("(212)555-1234", PhoneType.OFFICE);
		Phone2 phone2 = jpqlService.createPhone("(315)555-6253", PhoneType.HOME);
		Phone2 phone3 = jpqlService.createPhone("(212)555-9843", PhoneType.OFFICE);
		Phone2 phone4 = jpqlService.createPhone("(315)555-6253", PhoneType.OFFICE);
		Phone2 phone5 = jpqlService.createPhone("(516)555-9837", PhoneType.MOBILE);
		Phone2 phone6 = jpqlService.createPhone("(650)555-7583", PhoneType.OFFICE);
		Phone2 phone7 = jpqlService.createPhone("(650)555-5345", PhoneType.HOME);
		Phone2 phone8 = jpqlService.createPhone("(650)555-4885", PhoneType.MOBILE);
		Phone2 phone9 = jpqlService.createPhone("(516)555-9837", PhoneType.OFFICE);
		Phone2 phone10 = jpqlService.createPhone("(650)555-4759", PhoneType.OFFICE);
		Phone2 phone11 = jpqlService.createPhone("(585)555-0693", PhoneType.HOME);
		Phone2 phone12 = jpqlService.createPhone("(516)555-9837", PhoneType.MOBILE);
		Phone2 phone13 = jpqlService.createPhone("(650)555-2346", PhoneType.HOME);
		Phone2 phone14 = jpqlService.createPhone("(650)555-9874", PhoneType.MOBILE);
		Phone2 phone15 = jpqlService.createPhone("(585)555-1457", PhoneType.MOBILE);

		//
		entityTransaction.begin();
		employee1.addPhoneList(phone1);
		employee1.addPhoneList(phone2);
		employee2.addPhoneList(phone3);
		employee3.addPhoneList(phone4);
		employee3.addPhoneList(phone5);
		employee4.addPhoneList(phone6);
		employee4.addPhoneList(phone7);
		employee5.addPhoneList(phone8);
		employee6.addPhoneList(phone9);
		employee7.addPhoneList(phone10);
		employee8.addPhoneList(phone11);
		employee9.addPhoneList(phone12);
		employee9.addPhoneList(phone13);
		employee10.addPhoneList(phone14);
		employee11.addPhoneList(phone15);
		employee12.addPhoneList(phone15);
		entityTransaction.commit();
		
		//
		Department5 department1 = jpqlService.createDepartment("Engineering");
		Department5 department2 = jpqlService.createDepartment("QA");
		Department5 department3 = jpqlService.createDepartment("Accounting");
		
		@SuppressWarnings("unused")
		Department5 department4 = jpqlService.createDepartment("CAEngOtt");
		@SuppressWarnings("unused")
		Department5 department5 = jpqlService.createDepartment("USEngCal");
		@SuppressWarnings("unused")
		Department5 department6 = jpqlService.createDepartment("CADocOtt");

		//
		entityTransaction.begin();
		department2.addEmployee(employee1);
		department2.addEmployee(employee2);
		department2.addEmployee(employee3);
		department1.addEmployee(employee4);
		department1.addEmployee(employee5);
		department1.addEmployee(employee6);
		department1.addEmployee(employee7);
		department1.addEmployee(employee8);
		department2.addEmployee(employee9);
		department1.addEmployee(employee10);
		department3.addEmployee(employee11);
		//department3.addEmployee(employee12);
		//department3.addEmployee(employee13);
		entityTransaction.commit();

		Address2 address1 = jpqlService.createAddress("123 Apple Tree Cr.", "New York", "NY", "10001");
		Address2 address2 = jpqlService.createAddress("654 Stanton Way.", "Manhattan", "NY", "10003");
		Address2 address3 = jpqlService.createAddress("99 Queen St.", "New York", "NY", "10001");
		Address2 address4 = jpqlService.createAddress("445 McDonell Cr.", "Redwood Shores", "CA", "90123");
		Address2 address5 = jpqlService.createAddress("624 Hamilton Dr.", "San Jose", "CA", "90123");
		Address2 address6 = jpqlService.createAddress("724 Coventry Rd.'", "San Jose", "CA", "90123");
		Address2 address7 = jpqlService.createAddress("77 Manchester Blvd.", "San Francisco", "CA", "90123");
		Address2 address8 = jpqlService.createAddress("53 King St.", "Moorestown", "NJ", "08057");
		Address2 address9 = jpqlService.createAddress("14 Industrial Ave.", "New York", "NY", "10001");
		Address2 address10 = jpqlService.createAddress("'777 High Tech Ln.", "Redwood Shores", "CA", "90123");

		entityTransaction.begin();
		employee1.setAddress(address1);
		employee2.setAddress(address2);
		employee3.setAddress(address3);
		employee4.setAddress(address4);
		employee5.setAddress(address5);
		employee6.setAddress(address6);
		employee7.setAddress(address7);
		employee8.setAddress(address8);
		employee9.setAddress(address9);
		employee10.setAddress(address10);
		entityTransaction.commit();

		Project3 project1 = jpqlService.createProject("Design Release2");
		Project3 project2 = jpqlService.createProject("Release1");
		Project3 project3 = jpqlService.createProject("Test Release2");

		entityTransaction.begin();
		employee1.addProjectAndEmployeeList(project1);

		employee2.addProjectAndEmployeeList(project2);
		employee2.addProjectAndEmployeeList(project3);

		employee3.addProjectAndEmployeeList(project1);
		employee3.addProjectAndEmployeeList(project2);
		employee3.addProjectAndEmployeeList(project3);

		employee4.addProjectAndEmployeeList(project1);

		employee5.addProjectAndEmployeeList(project2);
		employee5.addProjectAndEmployeeList(project3);

		employee6.addProjectAndEmployeeList(project1);
		employee6.addProjectAndEmployeeList(project2);

		employee7.addProjectAndEmployeeList(project3);

		employee8.addProjectAndEmployeeList(project1);
		employee8.addProjectAndEmployeeList(project2);

		employee9.addProjectAndEmployeeList(project1);
		employee9.addProjectAndEmployeeList(project3);

		employee10.addProjectAndEmployeeList(project1);
		employee10.addProjectAndEmployeeList(project2);
		employee10.addProjectAndEmployeeList(project3);

		entityTransaction.commit();

		System.out.println("JOIN_EMPLOYEE_AND_PHONE");
		List<Phone2> phoneList = jpqlService.executeResultListQuery(JOIN_EMPLOYEE_AND_PHONE, Phone2.class);

		for (Phone2 phone : phoneList) {
			System.out.println(phone);
		}
		
		System.out.println("SELECT_ALL_PHONES_FROM_EMPLOYEE");
		List<Phone2> phoneListFromEmployee = jpqlService.executeResultListQuery(SELECT_ALL_PHONES_FROM_EMPLOYEE, Phone2.class);

		for (Phone2 phone : phoneListFromEmployee) {
			System.out.println(phone);
		}

		System.out.println("JOIN_SELECT_EMPLOYEE_AND_DEPARTMENT");
		List<Department5> departmentJoinList = jpqlService.executeResultListQuery(JOIN_SELECT_EMPLOYEE_AND_DEPARTMENT,
				Department5.class);

		for (Department5 dept : departmentJoinList) {
			System.out.println(dept);
		}

		System.out.println("SELECT_ALL_DEPARTMENTS_FROM_EMPLOYEE");
		List<Department5> departmentFromEmployeeList = jpqlService.executeResultListQuery(
				SELECT_ALL_DEPARTMENTS_FROM_EMPLOYEE, Department5.class);

		for (Department5 dept : departmentFromEmployeeList) {
			System.out.println(dept);
		}

		System.out.println("JOIN_DEPARTMENT_PROJECT_ADDRESS");
		List<Department5> departmentProjectAddress = jpqlService.executeResultListQuery(JOIN_DEPARTMENT_PROJECT_ADDRESS,
				Department5.class);

		for (Department5 dept : departmentProjectAddress) {
			System.out.println(dept);
		}

		System.out.println("MORE_JOIN");
		List<Object[]> moreJoinList = jpqlService.executeResultListQuery(MORE_JOIN, Object[].class);

		for (Object[] element : moreJoinList) {
			System.out.println(element[0] + " " + element[1]);
		}
		
		System.out.println("LEFT OUTER JOIN");

		List<Object[]> lefOuterJoin = jpqlService.executeResultListQuery(LEFT_OUTER_JOIN, Object[].class);

		for (Object[] element : lefOuterJoin) {
			System.out.println(element[0] + " " + element[1]);
		}
		
		
		System.out.println("RIGHT OUTER JOIN");

		List<Object[]> rightOuterJoin = jpqlService.executeResultListQuery(RIGHT_OUTER_JOIN, Object[].class);

		for (Object[] element : rightOuterJoin) {
			System.out.println(element[0] + " " + element[1]);
		}
		

		System.out.println("INPUT_PARAMETER");

		List<Employee30> inputParameterList = jpqlService.executeResultListQuery(INPUT_PARAMETER, Employee30.class,
				58000);

		for (Employee30 employee : inputParameterList) {
			System.out.println(employee);
		}

		System.out.println("GREAT_AND_LESS");

		List<Employee30> greatAndLessList = jpqlService.executeResultListQuery(GREAT_AND_LESS, Employee30.class, 45000,
				55000);

		for (Employee30 employee : greatAndLessList) {
			System.out.println(employee);
		}

		System.out.println("BETWEEN_EXPRESSION");

		List<Employee30> betweenList = jpqlService.executeResultListQuery(BETWEEN_EXPRESSION, Employee30.class, 45000,
				55000);

		for (Employee30 employee : betweenList) {
			System.out.println(employee);
		}

		System.out.println("NOT_BETWEEN_EXPRESSION");

		List<Employee30> notBetweenList = jpqlService.executeResultListQuery(NOT_BETWEEN_EXPRESSION, Employee30.class,
				45000, 55000);

		for (Employee30 employee : notBetweenList) {
			System.out.println(employee);
		}

		System.out.println("LIKE_EXPRESSION");

		List<Department5> likeList = jpqlService.executeResultListQuery(LIKE_EXPRESSION, Department5.class, "Eng%");

		for (Department5 department : likeList) {
			System.out.println(department);
		}

		System.out.println("IN_EXPRESSION");

		List<Employee30> inExpression = jpqlService.executeResultListQuery(IN_EXPRESSION, Employee30.class, "NY", "NJ");

		for (Employee30 employee : inExpression) {
			System.out.println(employee);
		}

		System.out.println("ALL_EXPRESSION");

		List<Employee30> allExpression = jpqlService.executeResultListQuery(ALL_EXPRESSION, Employee30.class, 2);

		for (Employee30 employee : allExpression) {
			System.out.println(employee);
		}

	}
}
