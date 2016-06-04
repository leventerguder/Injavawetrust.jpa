package _21.embedded.objects.service;

import _21.embedded.objects.model.Address;

public interface AddressService {

    public Address createAddress(String street,String road, String no, String city, String zip);

}
