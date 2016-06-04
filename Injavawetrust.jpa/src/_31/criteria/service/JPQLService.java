package _31.criteria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;

import _31.criteria.model.Address3;
import _31.criteria.model.Department6;
import _31.criteria.model.Employee31;
import _31.criteria.model.EmployeeDetails;
import _31.criteria.model.Phone3;
import _31.criteria.model.PhoneType;
import _31.criteria.model.Project4;

public interface JPQLService {
	public EntityManager getEntityManager();
	public Employee31 createEmployee(String name, String surname, int salary);
	public Phone3 createPhone(String no, PhoneType phoneType);
	public Department6 createDepartment(String name);
	public Address3 createAddress(String street, String city, String state, String zip);
	public Project4 createProject(String name);

	public List<Employee31> getAllEmployees();
	public List<String> getEmployeesName();

	public List<Tuple> getEmployeesDeptSalary();
	public List<Tuple> getEmployeesDeptSalaryV2();
	public List<EmployeeDetails> getEmployeeDetails();

	public String getDepartmentOfEmployeeJPQL(String employeeName);
	public String getDepartmentOfEmployeeCriteriaAPI(String employeeName);
	public String getDepartmentOfEmployeeCriteriaJoin(String employeeName);
	public List<String> getNameOfEmployeesByCity(String departmentName, String city);
	public List<Tuple> getNameAndProjectName();

	// where
	// equal
	public String getDepartmentOfEmployeeWithParameterExpression(String employeeName);

	// notEqual
	public List<Tuple> getEmployeeNameSalaryNotEqual(int salary);

	// greaterThan
	// greaterThanOrEqualTo
	public List<Tuple> getEmployeeNameSalaryGreaterThan(int salary);

	// between
	public List<Tuple> getEmployeeNameSalaryBetween(int salary, int salary2);

	// like
	public List<Tuple> getEmployeeNameSalaryLike(String like);

	// in
	public List<Tuple> getEmployeeNameSalaryIn(List<Integer> salaries);
	
	//isNull
	public List<String> getDepartmentOfEmployeeIsNull();

}
