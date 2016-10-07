package _12.idgeneration.sequence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee12 {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	@SequenceGenerator(name="Emp_Seq_Gen", sequenceName="EMP_SEQUENCE", initialValue=20, allocationSize=30)
	@Id @GeneratedValue(generator="Emp_Seq_Gen" , strategy= GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	public Employee12() {
		super();
	}

	// id degerini kendimiz vermiyoruz!
	public Employee12(String name, String surname, int salary) {
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
		return "Employee12 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
