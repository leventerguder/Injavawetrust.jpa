package _11.idgeneration.table.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee11 {
	
	//##### example 1 start
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	//MySQL de varsayilan olarak "sequence" tablosu kullanilir.
	//varsayilan olarak SEQ_NAME column degeri -> SEQ_GEN_TABLE
	
	//##### example 1 end
	
	//##### example 2 start
	
	//TableGenerator annotation kullanildiginda SEQ_NAME degeri icin SEQ_GEN_TABLE override edilir.
	// SEQ_GEN_TABLE yerine EMP_GEN degeri kullanilir.
	//@TableGenerator(name="EMP_GEN")
	//@Id 
	//@GeneratedValue(generator="EMP_GEN")	
	//##### example2 end
	
	//##### example 3 start
	//@TableGenerator da table attribute kullanarak yeni bir tablo olusturabiliriz.
	//tablomuzun adi ID_GEN
	//SEQ_NAME ve SEQ_COUNT olan column isimleri ID_GEN_NAME ve ID_GEN_COUNT olsun.
	//ID_GEN_NAME degeri -> EMP_GEN
	@TableGenerator(name="EMP_GEN_DETAILED",
	table="ID_GEN",
	pkColumnName="ID_GEN_NAME",
	valueColumnName="ID_GEN_COUNT",
	initialValue=200,
	//varsayilan olarak initial 0 dir.
	//varsayilan olarak allocationSize 50dir.
	allocationSize=10)
	@Id
	@GeneratedValue(generator="EMP_GEN_DETAILED")
	//##### example 3 end
	private int id;
	private String name;
	private String surname;
	private int salary;

	public Employee11() {
		super();
	}

	// id degerini kendimiz vermiyoruz!
	public Employee11(String name, String surname, int salary) {
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

	@Override
	public String toString() {
		return "Employee11 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}	

}
