package _30.jpql.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Department5 {

	@Id
	@TableGenerator(name="Dep_Gen")
	@GeneratedValue(generator="Dep_Gen")
	private int id;
	private String name;

	@OneToMany(mappedBy = "department")
	private Collection<Employee30> employees;

	public Department5() {

	}

	public Department5(String name) {
		super();
		this.name = name;
		employees = new ArrayList<Employee30>();
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

	public Collection<Employee30> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee30> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee30 employee) {
		if (getEmployees() != null) {
			getEmployees().add(employee);
			employee.setDepartment(this);
		}
	}

	@Override
	public String toString() {
		return "Department4 [id=" + id + ", name=" + name + "]";
	}

}
