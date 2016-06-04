package _20.manyToMany.bi.service;

import javax.persistence.EntityManager;
import _20.manyToMany.bi.model.Project2;

public class ProjectServiceImpl implements ProjectService {

    private EntityManager entityManager;

    public ProjectServiceImpl(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    public Project2 createProject(String name) {
    	Project2 project = new Project2(name);
		entityManager.persist(project);
		return project;
    }

}
