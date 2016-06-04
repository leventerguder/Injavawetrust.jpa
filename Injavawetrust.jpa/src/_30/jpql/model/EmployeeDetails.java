package _30.jpql.model;

public class EmployeeDetails {

	private String name;
	private int salary;
	private String departmentName;

	public EmployeeDetails(String name, int salary, String departmentName) {
		super();
		this.name = name;
		this.salary = salary;
		this.departmentName = departmentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", salary=" + salary
				+ ", departmentName=" + departmentName + "]";
	}

}
