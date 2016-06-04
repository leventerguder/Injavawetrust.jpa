package _22.elementCollection.service;

import java.util.Date;
import _22.elementCollection.model.Vacation;

public class VacationServiceImpl implements VacationService {

	@Override
	public Vacation createVacation(Date startDate, int days) {
		Vacation project = new Vacation(startDate, days);
		return project;
	}

}
