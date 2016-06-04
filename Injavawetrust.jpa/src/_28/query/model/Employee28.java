package _28.query.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee28 e")

@NamedQueries({
	@NamedQuery(name = "Employee.findByPrimaryKey",
		query = "SELECT e FROM Employee28 e WHERE e.id = :id"),
	@NamedQuery(name = "Employee.findByName", 
		query = "SELECT e FROM Employee28 e WHERE e.name = :name")})
public class Employee28 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	Employee28() {
		super();
	}

	public Employee28(String name, String surname, int salary) {
		super();
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
		return "Employee28 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
