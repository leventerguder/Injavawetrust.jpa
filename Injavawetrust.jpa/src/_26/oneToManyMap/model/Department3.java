package _26.oneToManyMap.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class Department3 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;

	@OneToMany
	@JoinTable(name = "EMP_DEPT_MAP", 
	joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "DEPT_ID"))
	@MapKeyColumn(name = "emp_map_id")
	private Map<String, Employee26> employeesMap;

	public Department3() {

	}

	public Department3(String name) {
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

	public Map<String, Employee26> getEmployeesMap() {
		return employeesMap;
	}

	public void setEmployeesMap(Map<String, Employee26> employeesMap) {
		this.employeesMap = employeesMap;
	}

	@Override
	public String toString() {
		return "Department3 [id=" + id + ", name=" + name + "]";
	}

}
