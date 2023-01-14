package com.ty.one_to_one_1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_1.dto.PanCard;
import com.ty.one_to_one_1.dto.Person;



public class PersonDao {
	
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		return entityManagerFactory.createEntityManager();
		
		
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		PanCard card=person.getCard();
	
	    entityManager.persist(card);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.merge(person);
		entityTransaction.commit();
		
	}
	
	public void  deletePerson(int id) {
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
        Person person=entityManager.find(Person.class, id);
	
		if(person!=null)
		{
			entityTransaction.begin();
			PanCard card=person.getCard();
			
		    
			
			entityManager.remove(person);
			
			
			entityTransaction.commit();
			System.out.println("Deleted");
		}
		else
			System.out.println("No such data is present");
		
	}
	
	public void detailsById(int id)
	{
		EntityManager entityManager= geEntityManager();
		
		 Person person= entityManager.find(Person.class, id);
		 System.out.println(person);
	}
	
	public void detailsALL() {
		EntityManager entityManager= geEntityManager();
		Query query= entityManager.createQuery("select a from Person a");
		List<Person> list=query.getResultList();
		System.out.println(list);
		
		
	}
	
	public void  deleteAllPerson(int id) {
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
        Person person=entityManager.find(Person.class, id);
	
		if(person!=null)
		{
			entityTransaction.begin();
			PanCard card=person.getCard();
			
		    entityManager.remove(card);
			
			entityManager.remove(person);
			
			
			entityTransaction.commit();
			System.out.println("Deleted");
		}
		else
			System.out.println("No such data is present");
		
	}
	
	

}
