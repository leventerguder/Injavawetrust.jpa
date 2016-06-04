package _18.oneToMany.uni.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Employee18 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;
	@OneToMany
	/*
	 * Varsayilan table/column isimlerini degistirmek icin
	 * 
	 * @JoinTable annotation'i kullanabiliriz.
	 */
	//@JoinTable(name = "EMP_PHONE", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PHN_ID"))
	@JoinColumn(name="EMP_ID")
	/*
	 * @OneToMany annotation'i ekstra tablo olmadan da kullanabiliriz. Bunun
	 * icin @JoinTable annotation yerine @JoinColumn annotation'i
	 * kullanabiliriz.
	 */
	private List<Phone> phones;

	Employee18() {
		super();
	}

	public Employee18(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;	
		phones = new ArrayList<Phone>();
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Employee18 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
