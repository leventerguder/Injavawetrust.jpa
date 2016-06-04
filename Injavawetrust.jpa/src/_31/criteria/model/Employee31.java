package _31.criteria.model;

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
public class Employee31 {

	@Id
	@TableGenerator(name="Emp_Gen")
	@GeneratedValue(generator="Emp_Gen")
	private int id;
	private String name;
	private String surname;
	private int salary;

	@OneToOne
	private Address3 address;
	
	@OneToMany
	@JoinColumn(name="EMP_ID")
	private List<Phone3> phones = new ArrayList<Phone3>();

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department6 department;

	@ManyToMany
	private List<Project4> projects = new ArrayList<Project4>();

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

	public Department6 getDepartment() {
		return department;
	}

	public void setDepartment(Department6 department) {
		this.department = department;
	}

	public Address3 getAddress() {
		return address;
	}

	public void setAddress(Address3 address) {
		this.address = address;
	}

	public Employee31(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public Employee31() {
	}



	@Override
	public String toString() {
		return "Employee31 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

	public List<Project4> getProjects() {
		return projects;
	}

	public void setProjects(List<Project4> projects) {
		this.projects = projects;
	}
	
	
	
	public List<Phone3> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone3> phones) {
		this.phones = phones;
	}

	public void addPhoneList(Phone3 phone){
		if(!getPhones().contains(phone)){
			getPhones().add(phone);
		}
	}

	public void addProjectAndEmployeeList(Project4 project) {
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
