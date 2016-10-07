package _02.field.access.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee2 {

	@Id
	// field access
	private int id;
	private String name;
	private String surname;
	private int salary;

	public Employee2() {
		super();
	}

	public Employee2(int id, String name, String surname, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
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

	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
