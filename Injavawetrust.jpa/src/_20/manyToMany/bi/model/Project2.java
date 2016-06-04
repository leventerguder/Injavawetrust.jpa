package _20.manyToMany.bi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project2 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;

	@ManyToMany(mappedBy = "projects")
	private List<Employee20> employees;

	public Project2() {
		super();
	}

	public Project2(String name) {
		super();
		this.name = name;
		employees = new ArrayList<Employee20>();
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

	public List<Employee20> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee20> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project2 [id=" + id + ", name=" + name + "]";
	}

}
