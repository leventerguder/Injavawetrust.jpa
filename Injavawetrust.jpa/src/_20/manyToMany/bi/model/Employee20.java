package _20.manyToMany.bi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee20 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ManyToMany
	@JoinTable(name = "EMP_PRJ_BI", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PRJ_ID"))
	private List<Project2> projects;

	Employee20() {
		super();
	}

	public Employee20(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		projects = new ArrayList<Project2>();

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

	public List<Project2> getProjects() {
		return projects;
	}

	public void setProjects(List<Project2> projects) {
		this.projects = projects;
	}

	public void addLists(Project2 project) {
		// bidirectional bir iliskide karsilikli olarak elemanlari List'lere
		// eklememiz gereklidir.
		if (!getProjects().contains(project)) {
			getProjects().add(project);
		}
		if (!project.getEmployees().contains(this)) {
			project.getEmployees().add(this);
		}
	}

	@Override
	public String toString() {
		return "Employee20 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

}
