package _23.elementCollectionStringMap.model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity
public class Employee23 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ElementCollection
	@CollectionTable(name = "EMP_PHN_MAP", joinColumns = @JoinColumn(name = "EMP_ID"))
	@MapKeyColumn(name = "PHONE_TPYE")
	@Column(name = "PHONE_NUM")
	private Map<String, String> phoneNumbers;

	Employee23() {
		super();
	}

	public Employee23(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		phoneNumbers = new LinkedHashMap<String, String>();

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

	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee23 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}

}
