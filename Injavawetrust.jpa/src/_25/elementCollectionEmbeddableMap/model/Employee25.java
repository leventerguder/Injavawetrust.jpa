package _25.elementCollectionEmbeddableMap.model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Employee25 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	private int salary;

	@ElementCollection
	// Eger Generic yapi kullanilmazsa bu durumda targetClass parametresi
	// kullanilmalidir.
	// @ElementCollection(targetClass=Vacation.class)
	// @JoinTable annotation'i oldugu gibi benzer sekilde @CollectionTable
	// annotation'ini kullanabiliriz. "
	@CollectionTable(name = "EMP_VACATIONS_MAP", joinColumns = @JoinColumn(name = "EMP_ID"))
	// Embeddable sinifimiz icin karsilik gelen kolon/column isimlerini
	// guncelleyebiliriz.
	@AttributeOverride(name = "days", column = @Column(name = "offDays"))
	private Map<String, Vacation> vacations;

	Employee25() {
		super();
	}

	public Employee25(String name, String surname, int salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;	
		vacations = new LinkedHashMap<String, Vacation>();

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

	public Map<String, Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(Map<String, Vacation> vacations) {
		this.vacations = vacations;
	}

	@Override
	public String toString() {
		return "Employee25 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", vacations=" + vacations + "]";
	}

	
}
