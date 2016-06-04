package _14.manyToOne.uni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee14 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int salary;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;

    Employee14() {
	super();
    }

    public Employee14(String name, String surname, int salary) {
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

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    @Override
    public String toString() {
	return "Employee14 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", department=" + department + "]";
    }

}
