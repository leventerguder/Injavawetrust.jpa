package _04.mixed.access.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
// Field Access ve Property access beraber kullanmak icin @Access annotation
// kullanmamiz gereklidir.
// Entity imiz AccessType olarak FIELD (instance variable) kullansin diye
// belirtiyoruz.
// bu durumda getter/setter metotlari degil instance variable Entity State icin
// kullanilir.
public class Employee4 {

	// static degiskenler Entity State icin degerlendirmeye alinmaz , table'da
	// bir column'a karsilik gelmez.
	public static String TURKEY_CODE = "+90";
	public static String USA_CODE = "+1";

	@Id
	private int id;
	private String name;
	private String surname;
	private int salary;
	
	@Transient
	// mobilePhone ve phoneNumberWithCode icin 2 tane column olusacaktir.
	// mobilePhone icin @Transient annotation kullanabiliriz ya da transient
	// olarak tanimlayabiliriz.
	// Bu durumda table'da bu column olusmayacaktir.
	private String mobilephone;

	// private transient String mobilephone;

	public Employee4() {
		super();
	}

	public Employee4(int id, String name, String surname, int salary, String mobilephone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.mobilephone = mobilephone;
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

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	// phoneNumberWithCode 'e karsilik gelen
	// JavaBean style uygun olarak tanimlanan getter/setter metodumuz.

	// Bu noktada Property Access yaklasimi uyguluyoruz.
	// Bunun icin @Access annotation kullaniyoruz.
	// Entity State icin diger getter/setter metotlar calismayacaktir. Fakat bu
	// noktada Property yaklasimi kullanildigi icin bu metot kullanilacaktir.
	@Access(AccessType.PROPERTY)
	public String getPhoneNumberWithCode() {
		if (mobilephone.startsWith("5")) {
			return TURKEY_CODE + mobilephone;
		} else {
			return USA_CODE + mobilephone;
		}
	}

	public void setPhoneNumberWithCode(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Override
	public String toString() {
		return "Employee4 [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", mobilephone=" + mobilephone + "]";
	}

}
