package _17.oneToMany.bi.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department2 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;

	@OneToMany(mappedBy = "department")
	private Collection<Employee17> employees;

	// Collection taniminda generic yapi kullanilmazsa bu durumda @OneToMany
	// annotation'da targetEntity parametresi kullanilmalidir.
	// @OneToMany(targetEntity=Employee17.class)
	// private Collection employees;

	public Department2() {

	}

	public Department2(String name) {
		super();
		this.name = name;
		employees= new ArrayList<Employee17>();
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

	public Collection<Employee17> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee17> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department2 [id=" + id + ", name=" + name + "]";
	}

}
