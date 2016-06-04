package _31.criteria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

@Entity
public class Project4 {

	@Id
	@TableGenerator(name="Prj_Gen")
	@GeneratedValue(generator="Prj_Gen")
	private int id;
	private String name;

	@ManyToMany(mappedBy = "projects")
	private List<Employee31> employees = new ArrayList<Employee31>();

	public Project4() {
		super();
	}

	public Project4(String name) {
		super();
		this.name = name;
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

	public List<Employee31> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee31> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project3 [id=" + id + ", name=" + name + "]";
	}

}
