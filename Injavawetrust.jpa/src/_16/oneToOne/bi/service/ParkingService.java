package _16.oneToOne.bi.service;

import _16.oneToOne.bi.model.ParkingSpace2;

public interface ParkingService {

	public ParkingSpace2 createParkingSpace(int lot, String location);

	public ParkingSpace2 findParkingSpace(int id);
}