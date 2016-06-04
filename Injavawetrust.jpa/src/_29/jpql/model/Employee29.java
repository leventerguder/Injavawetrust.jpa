package _29.jpql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee29 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department4 department;

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

	public Department4 getDepartment() {
		return department;
	}

	public void setDepartment(Department4 department) {
		this.department = department;
	}

	public Employee29(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	
	public Employee29(){}

	@Override
	public String toString() {
		return "Employee29 [id=" + id + ", name=" + name + ", surname="
				+ surname + ", salary=" + salary + "]";
	}
	
	
	
	
}
