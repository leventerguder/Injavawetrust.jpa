package _16.oneToOne.bi.service;

import javax.persistence.EntityManager;
import _16.oneToOne.bi.model.ParkingSpace2;

public class ParkingServiceImpl implements ParkingService {

	private EntityManager entityManager;

	public ParkingServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ParkingSpace2 createParkingSpace(int lot, String location) {
		ParkingSpace2 parkingSpace = new ParkingSpace2(lot, location);
		entityManager.persist(parkingSpace);
		return parkingSpace;
	}
	
	@Override
	public ParkingSpace2 findParkingSpace(int id) {
		return entityManager.find(ParkingSpace2.class, id);
	}

}
