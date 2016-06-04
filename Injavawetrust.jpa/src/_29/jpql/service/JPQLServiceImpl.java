package _29.jpql.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import _29.jpql.model.Department4;
import _29.jpql.model.Employee29;

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
	public Employee29 createEmployee(String name, String surname, int salary) {
		Employee29 employee = new Employee29(name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Department4 createDepartment(String name) {
		Department4 department = new Department4(name);
		entityTransaction.begin();
		entityManager.persist(department);
		entityTransaction.commit();
		return department;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> executeResultListQuery(String queryString, Class<T> resultClass) {

		TypedQuery<?> query = entityManager.createQuery(queryString, resultClass.getClass());
		return (List<T>) query.getResultList();

	}
}
