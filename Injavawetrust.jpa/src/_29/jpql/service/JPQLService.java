package _29.jpql.service;

import javax.persistence.EntityManager;

import _29.jpql.model.Department4;
import _29.jpql.model.Employee29;


public interface JPQLService {
	public EntityManager getEntityManager();
	public Employee29 createEmployee(String name, String surname, int salary);
	public Department4 createDepartment(String name);
}
