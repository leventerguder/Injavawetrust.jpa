package _29.jpql.service;

public class JPQLQuery {

	public final static String SELECT_ALL_EMPLOYEES = "Select e from Employee29 e";
	public final static String SELECT_NAME_OF_EMPLOYEES = "Select e.name from Employee29 e";
	public final static String SELECT_NAME_AND_SALARY = "Select e.name , e.salary from Employee29 e";
	public final static String SELECT_EMPLOYEE_DETAILS = "Select New _29.jpql.model.EmployeeDetails(e.name , e.salary , e.department.name) from Employee29 e";
	
	public final static String JOIN_SELECT_EMPLOYEE_AND_DEPARTMENT = "Select Distinct d FROM Employee29 e JOIN e.department d";
	public final static String SELECT_ALL_DEPARTMENTS_FROM_EMPLOYEE = "Select Distinct e.department from Employee29 e";
}