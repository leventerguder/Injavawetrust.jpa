package _21.embedded.objects.service;

import javax.persistence.EntityManager;

import _21.embedded.objects.model.Company;

public class CompanyServiceImpl implements CompanyService {


	private EntityManager entityManager;

	public CompanyServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Company createCompany(String name) {
		Company company = new Company(name);
		entityManager.persist(company);
		return company;
	}
}
