package _31.criteria.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;

import _31.criteria.model.Address3;
import _31.criteria.model.Department6;
import _31.criteria.model.Employee31;
import _31.criteria.model.EmployeeDetails;
import _31.criteria.model.Phone3;
import _31.criteria.model.PhoneType;
import _31.criteria.model.Project4;
import _31.criteria.service.JPQLServiceImpl;

public class CriteriaAPITest {

	public static void main(String[] args) {

		JPQLServiceImpl jpqlService = new JPQLServiceImpl();
		EntityTransaction entityTransaction = jpqlService.getEntityManager().getTransaction();
		System.out.println("Preparing Employee Data...");
		//
		Employee31 employee1 = jpqlService.createEmployee("John", "Robbins", 55000);
		Employee31 employee2 = jpqlService.createEmployee("Rob", "Freeman", 53000);
		Employee31 employee3 = jpqlService.createEmployee("Peter", "Gunton", 40000);
		Employee31 employee4 = jpqlService.createEmployee("Frank", " Sadler", 41000);
		Employee31 employee5 = jpqlService.createEmployee("Scott", "Brown", 60000);
		Employee31 employee6 = jpqlService.createEmployee("Rod ", "Johnson ", 62000);
		Employee31 employee7 = jpqlService.createEmployee("Sue", "Bellows", 54000);
		Employee31 employee8 = jpqlService.createEmployee("Stephanie", "Whitmore", 45000);
		Employee31 employee9 = jpqlService.createEmployee("Jennifer", "Libby", 52000);
		Employee31 employee10 = jpqlService.createEmployee("Sarah", "Proval", 59000);
		Employee31 employee11 = jpqlService.createEmployee("Marcus", "Ragno", 35000);
		Employee31 employee12 = jpqlService.createEmployee("Joe", "Hatlen", 36000);
		@SuppressWarnings("unused")
		Employee31 employee13 = jpqlService.createEmployee("Jack", "Snooze", 43000);

		//
		Phone3 phone1 = jpqlService.createPhone("(212)555-1234", PhoneType.OFFICE);
		Phone3 phone2 = jpqlService.createPhone("(315)555-6253", PhoneType.HOME);
		Phone3 phone3 = jpqlService.createPhone("(212)555-9843", PhoneType.OFFICE);
		Phone3 phone4 = jpqlService.createPhone("(315)555-6253", PhoneType.OFFICE);
		Phone3 phone5 = jpqlService.createPhone("(516)555-9837", PhoneType.MOBILE);
		Phone3 phone6 = jpqlService.createPhone("(650)555-7583", PhoneType.OFFICE);
		Phone3 phone7 = jpqlService.createPhone("(650)555-5345", PhoneType.HOME);
		Phone3 phone8 = jpqlService.createPhone("(650)555-4885", PhoneType.MOBILE);
		Phone3 phone9 = jpqlService.createPhone("(516)555-9837", PhoneType.OFFICE);
		Phone3 phone10 = jpqlService.createPhone("(650)555-4759", PhoneType.OFFICE);
		Phone3 phone11 = jpqlService.createPhone("(585)555-0693", PhoneType.HOME);
		Phone3 phone12 = jpqlService.createPhone("(516)555-9837", PhoneType.MOBILE);
		Phone3 phone13 = jpqlService.createPhone("(650)555-2346", PhoneType.HOME);
		Phone3 phone14 = jpqlService.createPhone("(650)555-9874", PhoneType.MOBILE);
		Phone3 phone15 = jpqlService.createPhone("(585)555-1457", PhoneType.MOBILE);

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
		Department6 department1 = jpqlService.createDepartment("Engineering");
		Department6 department2 = jpqlService.createDepartment("QA");
		Department6 department3 = jpqlService.createDepartment("Accounting");

		@SuppressWarnings("unused")
		Department6 department4 = jpqlService.createDepartment("CAEngOtt");
		@SuppressWarnings("unused")
		Department6 department5 = jpqlService.createDepartment("USEngCal");
		@SuppressWarnings("unused")
		Department6 department6 = jpqlService.createDepartment("CADocOtt");

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
		// department3.addEmployee(employee12);
		// department3.addEmployee(employee13);
		entityTransaction.commit();

		Address3 address1 = jpqlService.createAddress("123 Apple Tree Cr.", "New York", "NY", "10001");
		Address3 address2 = jpqlService.createAddress("654 Stanton Way.", "Manhattan", "NY", "10003");
		Address3 address3 = jpqlService.createAddress("99 Queen St.", "New York", "NY", "10001");
		Address3 address4 = jpqlService.createAddress("445 McDonell Cr.", "Redwood Shores", "CA", "90123");
		Address3 address5 = jpqlService.createAddress("624 Hamilton Dr.", "San Jose", "CA", "90123");
		Address3 address6 = jpqlService.createAddress("724 Coventry Rd.'", "San Jose", "CA", "90123");
		Address3 address7 = jpqlService.createAddress("77 Manchester Blvd.", "San Francisco", "CA", "90123");
		Address3 address8 = jpqlService.createAddress("53 King St.", "Moorestown", "NJ", "08057");
		Address3 address9 = jpqlService.createAddress("14 Industrial Ave.", "New York", "NY", "10001");
		Address3 address10 = jpqlService.createAddress("'777 High Tech Ln.", "Redwood Shores", "CA", "90123");

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

		Project4 project1 = jpqlService.createProject("Design Release2");
		Project4 project2 = jpqlService.createProject("Release1");
		Project4 project3 = jpqlService.createProject("Test Release2");

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

		System.out.println("### getAllEmployees ###\n");
		List<Employee31> allEmployees = jpqlService.getAllEmployees();
		for (Employee31 emp : allEmployees) {
			System.out.println(emp);
		}
		System.out.println();

		System.out.println("### getEmployeesName ###");
		List<String> allEmployeeNames = jpqlService.getEmployeesName();
		for (String empName : allEmployeeNames) {
			System.out.println(empName);
		}
		System.out.println();

		System.out.println("### getEmployeesDeptSalary ###");
		List<Tuple> allEmployeesDeptSalary = jpqlService.getEmployeesDeptSalary();
		for (Tuple tp : allEmployeesDeptSalary) {
			System.out.println(tp.get(0) + " " + tp.get(1) + " " + tp.get(2));
		}
		System.out.println();

		System.out.println("### getEmployeesDeptSalaryV2 ###");
		List<Tuple> allEmployeesNameAndSalary = jpqlService.getEmployeesDeptSalaryV2();
		for (Tuple tp : allEmployeesNameAndSalary) {
			System.out.println(tp.get(0) + " " + tp.get(1) + " " + tp.get(2));
		}
		System.out.println();

		System.out.println("### getEmployeeDetails ###");
		List<EmployeeDetails> allEmployeeDetails = jpqlService.getEmployeeDetails();
		for (EmployeeDetails empDetails : allEmployeeDetails) {
			System.out.println(empDetails.getName() + " " + empDetails.getSalary() + " "
					+ empDetails.getDepartmentName());
		}
		System.out.println();

		System.out.println("### getDepartmentOfEmployeeJPQL ###");
		String departmentOfEmployeeJPQL = jpqlService.getDepartmentOfEmployeeJPQL("Frank");
		System.out.println(departmentOfEmployeeJPQL);
		System.out.println();

		System.out.println("### getDepartmentOfEmployeeCriteriaAPI ###\n");
		String departmentOfEmployeeCriteriaAPI = jpqlService.getDepartmentOfEmployeeCriteriaAPI("Frank");
		System.out.println(departmentOfEmployeeCriteriaAPI);
		System.out.println();

		System.out.println("### getDepartmentOfEmployeeCriteriaJoin ###\n");
		String departmentOfEmployeeJoin = jpqlService.getDepartmentOfEmployeeCriteriaJoin("Frank");
		System.out.println(departmentOfEmployeeJoin);
		System.out.println();

		System.out.println("### getNameOfEmployeesByCity ###\n");
		List<String> nameOfEmployeesByCity = jpqlService.getNameOfEmployeesByCity("Engineering", "San Jose");
		for (String name : nameOfEmployeesByCity) {
			System.out.println(name);
		}
		System.out.println();

		System.out.println("### getNameAndProjectName ###\n");
		List<Tuple> nameAndProjectName = jpqlService.getNameAndProjectName();
		for (Tuple tp : nameAndProjectName) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		// ### Where clause examples ###
		// ###Comparison Operator ###
		// equal
		System.out.println("### getDepartmentOfEmployeeWithParameterExpression ###");
		String deptName = jpqlService.getDepartmentOfEmployeeWithParameterExpression("John");
		System.out.println(deptName);

		// notEqual
		System.out.println("### getEmployeeNameSalaryNotEqual ###");
		List<Tuple> notEquals = jpqlService.getEmployeeNameSalaryNotEqual(60000);
		for (Tuple tp : notEquals) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		// greateThan
		System.out.println("### getEmployeeNameSalaryGreaterThan ###");
		List<Tuple> greaterThan = jpqlService.getEmployeeNameSalaryGreaterThan(55000);
		for (Tuple tp : greaterThan) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		// between
		System.out.println("### getEmployeeNameSalaryBetween ###");
		List<Tuple> between = jpqlService.getEmployeeNameSalaryBetween(50000, 55000);
		for (Tuple tp : between) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		System.out.println("### getEmployeeNameSalaryLike ###");
		List<Tuple> like = jpqlService.getEmployeeNameSalaryLike("%ar%");
		for (Tuple tp : like) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		System.out.println("### getEmployeeNameSalaryIn ###");
		List<Integer> salaries = new ArrayList<Integer>();
		salaries.add(53000);
		salaries.add(54000);
		salaries.add(62000);
		List<Tuple> in = jpqlService.getEmployeeNameSalaryIn(salaries);
		for (Tuple tp : in) {
			System.out.println(tp.get(0) + " " + tp.get(1));
		}
		System.out.println();

		System.out.println("### getDepartmentOfEmployeeIsNull ###");
		List<String> isNull = jpqlService.getDepartmentOfEmployeeIsNull();
		for (String name : isNull) {
			System.out.println(name);
		}
		System.out.println();
	}
}
