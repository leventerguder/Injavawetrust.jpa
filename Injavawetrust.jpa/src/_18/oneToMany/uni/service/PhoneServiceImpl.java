package _18.oneToMany.uni.service;

import javax.persistence.EntityManager;

import _18.oneToMany.uni.model.Phone;

public class PhoneServiceImpl implements PhoneService {

    private EntityManager entityManager;

    public PhoneServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public Phone createPhone(String no, String type) {
	Phone phone = new Phone(no, type);
	entityManager.persist(phone);
	return phone;
    }

}
