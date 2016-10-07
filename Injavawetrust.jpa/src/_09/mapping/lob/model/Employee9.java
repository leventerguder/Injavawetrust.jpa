package _09.mapping.lob.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Employee9 {

	@Id
	private int id;
	private String name;
	private String surname;
	private int salary;	
	@Lob
	private byte[] picture;

	public Employee9() {
		super();
	}

	public Employee9(int id, String name, String surname, int salary, byte[] picture) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.picture = picture;
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	@Override
	public String toString() {
		return "Employee9 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", picture=" + Arrays.toString(picture)
				+ "]";
	}

}
