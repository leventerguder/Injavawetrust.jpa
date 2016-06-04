package _14.manyToOne.uni.service;

import javax.persistence.EntityManager;

import _14.manyToOne.uni.model.Department;

public class DepartmentServiceImpl implements DepartmentService{

	private EntityManager entityManager;

	public DepartmentServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Department createDepartment(String name) {
		Department dept = new Department(name);
		entityManager.persist(dept);

		return dept;
	}
}
