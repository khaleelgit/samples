package com.techavalanche.oneToOne.fk;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

	private static String PERSISTENCE_UNIT_NAME = "perContext-Hibernate";
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		if(args.length != 0 && args[0] != null)
			PERSISTENCE_UNIT_NAME = args[0];
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = factory.createEntityManager();
		
		createPerson();
		
		getAllPassport();
		
	}
	
	public static void getAllPassport(){
		Query query = entityManager.createQuery("SELECT passport FROM Passport passport");
		
		List<Passport> lstPassport = query.getResultList();
		
		for (Passport passport : lstPassport) {
			System.out.println("-----------------------------------------------------------------------------------------");
			if (passport != null) {
				
				System.out.println(passport);
				
				if(passport.getPerson() != null)
					System.out.println(passport.getPerson());
			}
			System.out.println("-----------------------------------------------------------------------------------------");
		}
	}
	
	public static void createPerson(){
		
		entityManager.getTransaction().begin();

		Person person = new Person();
		person.setName("Sara Kamerkar");
		
		Passport passport = new Passport();
		passport.setPassportNo("GHABD877H");
		
		person.setPassport(passport);
		
		entityManager.persist(person);
		
		entityManager.getTransaction().commit();
	}
}
