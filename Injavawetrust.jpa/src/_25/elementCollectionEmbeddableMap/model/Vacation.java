package _25.elementCollectionEmbeddableMap.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Vacation {

	@Temporal(TemporalType.DATE)
	private Date startDate;
	private int days;

	public Vacation() {
		super();
	}

	public Vacation(Date startDate, int days) {
		super();
		this.startDate = startDate;
		this.days = days;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Vacation [startDate=" + startDate + ", days=" + days + "]";
	}
	

}
