package _29.jpql.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department4 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;

	@OneToMany(mappedBy = "department")
	private Collection<Employee29> employees;

	public Department4() {

	}

	public Department4(String name) {
		super();
		this.name = name;
		employees = new ArrayList<Employee29>();
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

	public Collection<Employee29> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee29> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee29 employee) {
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
