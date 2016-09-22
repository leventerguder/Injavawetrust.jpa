package _01.hello.eclipselink.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import _01.hello.eclipselink.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;

	public EmployeeDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	@Override
	public Employee insertEmployee(int id, String name, String surname, int salary) {
		Employee employee = new Employee(id, name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("Select e from Employee e");
		return query.getResultList();

	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
	}

	@Override
	public Employee raiseEmployeeSalary(int id, int raise) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityTransaction.begin();
			employee.setSalary(employee.getSalary() + raise);
			entityTransaction.commit();
		}
		return employee;

	}

}
