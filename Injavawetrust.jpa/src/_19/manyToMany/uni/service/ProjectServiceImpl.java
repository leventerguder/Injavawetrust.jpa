package _19.manyToMany.uni.service;

import javax.persistence.EntityManager;

import _19.manyToMany.uni.model.Project;

public class ProjectServiceImpl implements ProjectService {

    private EntityManager entityManager;

    public ProjectServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public Project createProject(String name) {
    	Project project = new Project(name);
		entityManager.persist(project);
		return project;
    }

}
