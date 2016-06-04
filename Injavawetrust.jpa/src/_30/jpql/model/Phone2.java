package _30.jpql.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Phone2 {
	@Id
	@TableGenerator(name = "PHN_GEN")
	@GeneratedValue(generator = "PHN_GEN")
	private int id;
	private String no;
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;

	public Phone2() {
		super();
	}

	public Phone2(String no, PhoneType phoneType) {
		super();
		this.no = no;
		this.phoneType = phoneType;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public String toString() {
		return "Phone2 [id=" + id + ", no=" + no + ", phoneType=" + phoneType + "]";
	}
	
	

}
