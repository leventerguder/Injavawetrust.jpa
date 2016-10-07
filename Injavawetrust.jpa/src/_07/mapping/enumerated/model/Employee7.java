package _07.mapping.enumerated.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Employee7 {

	@Id
	private int id;
	private String name;
	private String surname;
	private int salary;

	@Enumerated(EnumType.STRING)
	// @Enumerated(EnumType.ORDINAL)
	// varsayilan olarak ORDINAL olarak calisir.
	// index 0 dan baslar!
	private EmployeeType employeeType;

	public Employee7() {
		super();
	}

	public Employee7(int id, String name, String surname, int salary, EmployeeType employeeType) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.employeeType = employeeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee7 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", employeeType=" + employeeType + "]";
	}

}
