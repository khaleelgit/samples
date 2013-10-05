package com.techavalanche.oneToOne.sharedPk;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

	private static String PERSISTENCE_UNIT_NAME = "perContext-EclipseLink";
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		if(args.length != 0 && args[0] != null)
			PERSISTENCE_UNIT_NAME = args[0];
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = factory.createEntityManager();
		
		createCustomer();
		getCustomers();
		
	}
	
	public static void getCustomers(){
		Query query = entityManager.createQuery("SELECT obj FROM Customer obj");
		
		List<Customer> lstCustomer = query.getResultList();
		
		for (Customer customer : lstCustomer) {
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("[ "+customer.toString()+" ]");
			if(customer.getAddress() != null)
				System.out.println("[ Customer City : "+customer.getAddress().getCity()+" ]");
			else
				System.out.println("[ Customer City : Not Applicable ]");
			System.out.println("-----------------------------------------------------------------------------------------");
		}
	}
	
	public static void createCustomer(){
		
		entityManager.getTransaction().begin();

		Customer customer = new Customer();
		customer.setName("Ninad Kamerkar");
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setCountry("India");
		
		customer.setAddress(address);
		
		entityManager.persist(customer);
		
		entityManager.getTransaction().commit();
	}
}
