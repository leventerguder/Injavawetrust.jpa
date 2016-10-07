package _03.property.access.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee3 {

	private int id;
	private String name;
	private String surname;
	private int salary;

	public Employee3() {
		super();
	}

	public Employee3(int id, String name, String surname, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	@Id
	// property access!
	// @Id annotation getter metot uzerinde olmalidir. setter metot uzerinde
	// tanimlamak gecerli degildir.
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
		return "Employee3 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
