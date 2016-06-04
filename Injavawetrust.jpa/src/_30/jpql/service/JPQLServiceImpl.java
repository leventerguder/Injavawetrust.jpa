package _30.jpql.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import _30.jpql.model.Address2;
import _30.jpql.model.Department5;
import _30.jpql.model.Employee30;
import _30.jpql.model.Phone2;
import _30.jpql.model.PhoneType;
import _30.jpql.model.Project3;

public class JPQLServiceImpl implements JPQLService {

	EntityManager entityManager;
	EntityManagerFactory entityManagerFactory;
	EntityTransaction entityTransaction;

	public JPQLServiceImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Employee30 createEmployee(String name, String surname, int salary) {
		Employee30 employee = new Employee30(name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Phone2 createPhone(String no, PhoneType phoneType) {
		Phone2 phone = new Phone2(no, phoneType);
		entityTransaction.begin();
		entityManager.persist(phone);
		entityTransaction.commit();
		return phone;
	}

	@Override
	public Department5 createDepartment(String name) {
		Department5 department = new Department5(name);
		entityTransaction.begin();
		entityManager.persist(department);
		entityTransaction.commit();
		return department;
	}

	@Override
	public Address2 createAddress(String street, String city, String state, String zip) {
		Address2 address = new Address2(street, city, state, zip);
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		return address;
	}

	@Override
	public Project3 createProject(String name) {
		Project3 project = new Project3(name);
		entityTransaction.begin();
		entityManager.persist(project);
		entityTransaction.commit();
		return project;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> executeResultListQuery(String queryString, Class<T> resultClass, Object... params) {

		TypedQuery<?> query = entityManager.createQuery(queryString, resultClass.getClass());

		int index = 1;
		if (params != null) {
			for (Object param : params) {

				query.setParameter(index++, param);
			}
		}

		return (List<T>) query.getResultList();

	}
}
