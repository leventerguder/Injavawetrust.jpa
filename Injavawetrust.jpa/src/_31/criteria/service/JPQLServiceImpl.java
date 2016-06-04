package _31.criteria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import _31.criteria.model.Address3;
import _31.criteria.model.Department6;
import _31.criteria.model.Employee31;
import _31.criteria.model.EmployeeDetails;
import _31.criteria.model.Phone3;
import _31.criteria.model.PhoneType;
import _31.criteria.model.Project4;

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
	public Employee31 createEmployee(String name, String surname, int salary) {
		Employee31 employee = new Employee31(name, surname, salary);
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Phone3 createPhone(String no, PhoneType phoneType) {
		Phone3 phone = new Phone3(no, phoneType);
		entityTransaction.begin();
		entityManager.persist(phone);
		entityTransaction.commit();
		return phone;
	}

	@Override
	public Department6 createDepartment(String name) {
		Department6 department = new Department6(name);
		entityTransaction.begin();
		entityManager.persist(department);
		entityTransaction.commit();
		return department;
	}

	@Override
	public Address3 createAddress(String street, String city, String state, String zip) {
		Address3 address = new Address3(street, city, state, zip);
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		return address;
	}

	@Override
	public Project4 createProject(String name) {
		Project4 project = new Project4(name);
		entityTransaction.begin();
		entityManager.persist(project);
		entityTransaction.commit();
		return project;
	}

	@SuppressWarnings("unchecked")
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

	public void updateSalary(String queryString) {
		entityTransaction.begin();
		entityManager.createQuery(queryString).executeUpdate();
		entityTransaction.commit();
	}

	@Override
	public List<Employee31> getAllEmployees() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee31> criteriaQuery = criteriaBuilder.createQuery(Employee31.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(empRoot);
		TypedQuery<Employee31> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<String> getEmployeesName() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(empRoot.get("name")).distinct(true);
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Tuple> getEmployeesDeptSalary() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary"), empRoot
				.get("department").get("name")));
		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Tuple> getEmployeesDeptSalaryV2() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.multiselect(empRoot.get("name"), empRoot.get("salary"), empRoot.get("department").get("name"));
		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeDetails> criteriaQuery = criteriaBuilder.createQuery(EmployeeDetails.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);

		// criteriaQuery.multiselect(empRoot.get("name"), empRoot.get("salary"),
		// empRoot.get("department").get("name"));

		criteriaQuery.select(criteriaBuilder.construct(EmployeeDetails.class, empRoot.get("name"),
				empRoot.get("salary"), empRoot.get("department").get("name")));
		TypedQuery<EmployeeDetails> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public String getDepartmentOfEmployeeJPQL(String employeeName) {
		TypedQuery<String> query = entityManager.createQuery(
				"Select e.department.name from Employee31 e WHERE e.name = :empName ", String.class).setParameter(
				"empName", employeeName);
		return query.getSingleResult();
	}

	@Override
	public String getDepartmentOfEmployeeCriteriaAPI(String employeeName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(empRoot.get("department").get("name")).where(
				criteriaBuilder.equal(empRoot.get("name"), employeeName));
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}

	@Override
	public String getDepartmentOfEmployeeCriteriaJoin(String employeeName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);

		Join<Employee31, Department6> departmentJoin = empRoot.join("department");
		criteriaQuery.select(departmentJoin.get("name"))
				.where(criteriaBuilder.equal(empRoot.get("name"), employeeName));

		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}

	@Override
	public List<String> getNameOfEmployeesByCity(String departmentName, String city) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);

		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		Join<Employee31, Department6> departmentJoin = empRoot.join("department");

		System.out.println(empRoot.getJoins().size());

		Join<Employee31, Address3> addressJoin = empRoot.join("address");

		System.out.println(empRoot.getJoins().size());

		criteriaQuery.select(empRoot.get("name")).where(
				criteriaBuilder.equal(departmentJoin.get("name"), departmentName),
				criteriaBuilder.equal(addressJoin.get("city"), city));

		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Tuple> getNameAndProjectName() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		Join<Employee31, Project4> departmentJoin = empRoot.join("projects", JoinType.LEFT);
		criteriaQuery.multiselect(empRoot.get("name"), departmentJoin.get("name"));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	// ### Where clause examples ###
	// ###Comparison Operator ###
	// equal
	@Override
	public String getDepartmentOfEmployeeWithParameterExpression(String employeeName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		ParameterExpression<String> empNameExpression = criteriaBuilder.parameter(String.class, "empName");
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(empRoot.get("department").get("name")).where(
				criteriaBuilder.equal(empRoot.get("name"), empNameExpression));
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery).setParameter("empName", employeeName);
		return query.getSingleResult();
	}

	// notEqual
	public List<Tuple> getEmployeeNameSalaryNotEqual(int salary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

		ParameterExpression<Integer> empNameExpression = criteriaBuilder.parameter(Integer.class, "salaryParam");
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(criteriaBuilder.notEqual(empRoot.get("salary"), empNameExpression));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery).setParameter(empNameExpression, salary);
		return query.getResultList();

	}
	// greaterThan
	public List<Tuple> getEmployeeNameSalaryGreaterThan(int salary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

		ParameterExpression<Integer> empNameExpression = criteriaBuilder.parameter(Integer.class, "salaryParam");
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(criteriaBuilder.greaterThan(empRoot.get("salary"), empNameExpression));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery).setParameter(empNameExpression, salary);
		return query.getResultList();

	}

	// between
	public List<Tuple> getEmployeeNameSalaryBetween(int salary, int salary2) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));

		criteriaQuery.where(criteriaBuilder.between(empRoot.get("salary"),
				criteriaBuilder.parameter(Integer.class, "lowSalary"),
				criteriaBuilder.parameter(Integer.class, "highSalary")));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery).setParameter("lowSalary", salary)
				.setParameter("highSalary", salary2);
		return query.getResultList();

	}

	// like
	public List<Tuple> getEmployeeNameSalaryLike(String like) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);

		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(criteriaBuilder.like(empRoot.get("name"), like));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	// in
	public List<Tuple> getEmployeeNameSalaryIn(List<Integer> salaries) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));

		criteriaQuery.where(criteriaBuilder.in(empRoot.get("salary")).value(salaries.get(0)).value(salaries.get(1))
				.value(salaries.get(2)));

		// 2.yontem
		// criteriaQuery.where(empRoot.get("salary").in(salaries));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	// isNull
	@Override
	public List<String> getDepartmentOfEmployeeIsNull() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee31> empRoot = criteriaQuery.from(Employee31.class);
		criteriaQuery.select(empRoot.get("name")).where(criteriaBuilder.isNull(empRoot.get("department")));
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}
