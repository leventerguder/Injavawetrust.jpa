package _17.oneToMany.bi.service;

import javax.persistence.EntityManager;

import _17.oneToMany.bi.model.Department2;

public class DepartmentServiceImpl implements DepartmentService {

	private EntityManager entityManager;

	public DepartmentServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Department2 createDepartment(String name) {
		Department2 dept = new Department2(name);
		entityManager.persist(dept);

		return dept;
	}

	public Department2 findDepartment(int id) {
		return entityManager.find(Department2.class, id);
	}
}
