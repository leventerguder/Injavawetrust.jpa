package _30.jpql.service;

import java.util.List;

import javax.persistence.EntityManager;

import _30.jpql.model.Address2;
import _30.jpql.model.Department5;
import _30.jpql.model.Employee30;
import _30.jpql.model.Phone2;
import _30.jpql.model.PhoneType;
import _30.jpql.model.Project3;


public interface JPQLService {
	public EntityManager getEntityManager();
	public Employee30 createEmployee(String name, String surname, int salary);
	public Phone2 createPhone(String no, PhoneType phoneType);
	public Department5 createDepartment(String name);
	public Address2 createAddress(String street, String city, String state, String zip);
	public Project3 createProject(String name);
	
	public <T> List<T> executeResultListQuery(String queryString, Class<T> resultClass, Object... params);
}
