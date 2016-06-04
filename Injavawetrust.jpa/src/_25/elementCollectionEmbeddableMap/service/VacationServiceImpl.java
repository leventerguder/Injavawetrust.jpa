package _25.elementCollectionEmbeddableMap.service;

import java.util.Date;

import _25.elementCollectionEmbeddableMap.model.Vacation;

public class VacationServiceImpl implements VacationService {

	@Override
	public Vacation createVacation(Date startDate, int days) {
		Vacation project = new Vacation(startDate, days);
		return project;
	}

}
