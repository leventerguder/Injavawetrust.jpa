package _08.mapping.temporal.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee8 {

	@Id
	private int id;
	private String name;
	private String surname;
	private int salary;
	@Temporal(TemporalType.DATE)
	// year month day
	private Date startDate;
	// @Temporal(TemporalType.TIME) -> hour minute second
	@Temporal(TemporalType.TIMESTAMP)
	// year month day hour minute second
	private Calendar birthDay;

	public Employee8() {
		super();
	}

	public Employee8(int id, String name, String surname, int salary, Date startDate, Calendar birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.startDate = startDate;
		this.birthDay = birthDay;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Employee8 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", startDate=" + startDate + ", birthDay="
				+ birthDay + "]";
	}

}
