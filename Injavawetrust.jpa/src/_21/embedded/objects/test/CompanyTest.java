package _21.embedded.objects.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import _21.embedded.objects.model.Address;
import _21.embedded.objects.model.Company;
import _21.embedded.objects.service.AddressService;
import _21.embedded.objects.service.AddressServiceImpl;
import _21.embedded.objects.service.CompanyService;
import _21.embedded.objects.service.CompanyServiceImpl;

public class CompanyTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		CompanyService companyService = new CompanyServiceImpl(entityManager);

		entityTransaction.begin();
		Company company = companyService.createCompany("The Injavawetrust Company");
		entityTransaction.commit();

		System.out.println("Persisted :" + company);

		AddressService addressService = new AddressServiceImpl();
		Address address = addressService.createAddress("company street", "myAvenue", "100", "Istanbul", "34000");

		entityTransaction.begin();
		company.setAddress(address);
		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
