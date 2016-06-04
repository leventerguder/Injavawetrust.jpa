package _21.embedded.objects.service;

import _21.embedded.objects.model.Address;

public class AddressServiceImpl implements AddressService {

	@Override
	public Address createAddress(String street, String road,String no, String city, String zip) {
		Address address = new Address(street,road, no, city, zip);
		return address;
	}

}
