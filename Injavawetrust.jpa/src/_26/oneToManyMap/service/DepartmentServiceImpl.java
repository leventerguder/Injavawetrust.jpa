package _26.oneToManyMap.service;

import javax.persistence.EntityManager;

import _26.oneToManyMap.model.Department3;


public class DepartmentServiceImpl implements DepartmentService {

	private EntityManager entityManager;

	public DepartmentServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Department3 createDepartment(String name) {
		Department3 dept = new Department3(name);
		entityManager.persist(dept);
		return dept;
	}
}
