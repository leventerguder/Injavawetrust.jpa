package _16.oneToOne.bi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int lot;
    private String location;

    @OneToOne(mappedBy = "parkingSpace2")
    private Employee16 employee;

    // Bidirectional One To One bir iliskide mappedBy inverse side'a eklenir.
    // Bunun anlami Employee16 Entity'si bu iliskinin sahibidir , owning side.
    // Foreign key bilgisi bu durumda Employee16 tablosunda yer almaktadir.
    // Boylelikle inverse side'ta (ParkingSpace2) foreign key bilgisi saklanmaz.

    public ParkingSpace2() {
	super();
    }

    public ParkingSpace2(int lot, String location) {
	super();
	this.lot = lot;
	this.location = location;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getLot() {
	return lot;
    }

    public void setLot(int lot) {
	this.lot = lot;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public Employee16 getEmployee() {
	return employee;
    }

    public void setEmployee(Employee16 employee) {
	this.employee = employee;
    }

    @Override
    public String toString() {
	return "ParkingSpace2 [id=" + id + ", lot=" + lot + ", location=" + location + ", employee=" + employee + "]";
    }

}
