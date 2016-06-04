package _30.jpql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Employee30 {

	@Id
	@TableGenerator(name="Emp_Gen")
	@GeneratedValue(generator="Emp_Gen")
	private int id;
	private String name;
	private String surname;
	private int salary;

	@OneToOne
	private Address2 address;
	
	@OneToMany
	@JoinColumn(name="EMP_ID")
	private List<Phone2> phones = new ArrayList<Phone2>();

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department5 department;

	@ManyToMany
	private List<Project3> projects = new ArrayList<Project3>();

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

	public Department5 getDepartment() {
		return department;
	}

	public void setDepartment(Department5 department) {
		this.department = department;
	}

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}

	public Employee30(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public Employee30() {
	}

	@Override
	public String toString() {
		return "Employee30 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

	public List<Project3> getProjects() {
		return projects;
	}

	public void setProjects(List<Project3> projects) {
		this.projects = projects;
	}
	
	
	
	public List<Phone2> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone2> phones) {
		this.phones = phones;
	}

	public void addPhoneList(Phone2 phone){
		if(!getPhones().contains(phone)){
			getPhones().add(phone);
		}
	}

	public void addProjectAndEmployeeList(Project3 project) {
		// bidirectional bir iliskide karsilikli olarak elemanlari List'lere
		// eklememiz gereklidir.
		if (!getProjects().contains(project)) {
			getProjects().add(project);
		}
		if (!project.getEmployees().contains(this)) {
			project.getEmployees().add(this);
		}
	}
}
