package _15.oneToOne.uni.service;

import javax.persistence.EntityManager;
import _15.oneToOne.uni.model.ParkingSpace;

public class ParkingServiceImpl implements ParkingService {

	private EntityManager entityManager;

	public ParkingServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ParkingSpace createParkingSpace(int lot, String location) {
		ParkingSpace parkingSpace = new ParkingSpace(lot, location);
		entityManager.persist(parkingSpace);
		return parkingSpace;
	}
}
