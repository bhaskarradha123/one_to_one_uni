package com.ty.one_to_one_1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_to_one_1.dto.PanCard;
import com.ty.one_to_one_1.dto.Person;

public class PanCard_Dao {
	
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		return entityManagerFactory.createEntityManager();
		
		
	}
	
	
	public void updatePan(PanCard card) {
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.merge(card);
		entityTransaction.commit();
		
	}
	
	public void  deletePan(int id) throws Exception{
		EntityManager entityManager= geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
        PanCard card=entityManager.find(PanCard.class, id);
	
		if(card!=null)
		{
			entityTransaction.begin();
	
			
		    entityManager.remove(card);
			
			
			entityTransaction.commit();
			System.out.println("Deleted");
		}
		else
			System.out.println("No such data is present");
		
	}
	

	public void panDetailsById(int id)
	{
		EntityManager entityManager= geEntityManager();
		   PanCard card=entityManager.find(PanCard.class, id);
		
		 
		 System.out.println(card);
	}
	
	

}
