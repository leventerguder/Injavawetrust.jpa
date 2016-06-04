package _22.elementCollection.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

@Entity
public class Employee22 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ElementCollection
	@CollectionTable(name="EMP_EMAIL_LIST" , joinColumns=@JoinColumn(name="EMP_ID"))
	private Set<String> emails;

	@ElementCollection
	// Eger Generic yapi kullanilmazsa bu durumda targetClass parametresi
	// kullanilmalidir.
	// @ElementCollection(targetClass=Vacation.class)
	// @JoinTable annotation'i oldugu gibi benzer sekilde @CollectionTable
	// annotation'ini kullanabiliriz.
	@CollectionTable(name = "EMP_VACATIONS", joinColumns = @JoinColumn(name = "EMP_ID"))
    //Embeddable sinifimiz icin karsilik gelen kolon/column isimlerini guncelleyebiliriz.
	@AttributeOverride(name = "days", column = @Column(name = "offDays"))
	private List<Vacation> vacations;

	Employee22() {
		super();
	}

	public Employee22(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		emails = new LinkedHashSet<String>();
		vacations = new ArrayList<Vacation>();

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

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public List<Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

	@Override
	public String toString() {
		return "Employee22 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", emails="
				+ emails + ", vacations=" + vacations + "]";
	}

}
