package _24.elementCollectionEnumMap.model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;

@Entity
public class Employee24 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ElementCollection
	@CollectionTable(name = "EMP_PHONE_MAP")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHN_TYPE")
	@Column(name = "PHN_NUM")
	private Map<PhoneType, String> phoneNumbers;

	Employee24() {
		super();
	}

	public Employee24(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		phoneNumbers = new LinkedHashMap<PhoneType, String>();
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

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee24 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}

}
