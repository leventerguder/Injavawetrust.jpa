package _15.oneToOne.uni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int lot;
    private String location;

    public ParkingSpace() {
	super();
    }

    public ParkingSpace(int lot, String location) {
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

    @Override
    public String toString() {
	return "ParkingSpace [id=" + id + ", lot=" + lot + ", location=" + location + "]";
    }

}
