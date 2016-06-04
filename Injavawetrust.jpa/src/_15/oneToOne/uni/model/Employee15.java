package _15.oneToOne.uni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee15 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int salary;

    @OneToOne
    @JoinColumn(name = "park_id", unique = true)
    private ParkingSpace parkingSpace;

    Employee15() {
	super();
    }

    public Employee15(String name, String surname, int salary) {
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

    public ParkingSpace getParkingSpace() {
	return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
	this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
	return "Employee15 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", parkingSpace=" + parkingSpace + "]";
    }

}
