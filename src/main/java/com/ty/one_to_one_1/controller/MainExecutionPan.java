package com.ty.one_to_one_1.controller;

import java.util.Scanner;

import com.ty.one_to_one_1.dao.PanCard_Dao;
import com.ty.one_to_one_1.dao.PersonDao;
import com.ty.one_to_one_1.dto.PanCard;
import com.ty.one_to_one_1.dto.Person;

public class MainExecutionPan {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PersonDao dao=new PersonDao();
		PanCard_Dao dao2=new PanCard_Dao();
		
		boolean check=true;
		do {
			
			System.out.println("Enter your choice  \n 1.Save the details \n 2.update the person  "
					+ "\n 3.Update panCard  \n 4.Delete the person  \n 5.Delete PanCard \n 6.your Details  " 
					+ "\n 7.PanCard details   \n 8.All Details  \n 9.Delete All details \n 10.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the given criteria");
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter address");
				String address=sc.next();
				System.out.println("Enter phone ");
				long phone=sc.nextLong();
				System.out.println("Enter adhar");
				int adhar=sc.nextInt();
				Person person=new Person();
				person.setAddress(address);
				person.setAdhar(adhar);
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				System.out.println("Enter pan num");
				int pid=sc.nextInt();
				System.out.println("Enter pan name");
				String pname=sc.next();
				System.out.println("Enter pan address");
				String paddress=sc.next();
				PanCard card=new PanCard();
				card.setP_address(paddress);
				card.setP_id(pid);
				card.setP_name(pname);
				person.setCard(card);
				
				dao.savePerson(person);
				
			}break;
			case 2:
			{
				System.out.println("Enter the given criteria please give your correct id");
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter address");
				String address=sc.next();
				System.out.println("Enter phone ");
				long phone=sc.nextLong();
				System.out.println("Enter adhar");
				int adhar=sc.nextInt();
				Person person=new Person();
				person.setAddress(address);
				person.setAdhar(adhar);
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				System.out.println("Enter pan num");
				int pid=sc.nextInt();
				
				
				PanCard card=new PanCard();
			
				card.setP_id(pid);
				
				person.setCard(card);
				dao.updatePerson(person);
				
			}break;
			case 3:{
				System.out.println("To update pan pls provide correct pan id");
				System.out.println("Enter pan num");
				int pid=sc.nextInt();
				System.out.println("Enter pan name");
				String pname=sc.next();
				System.out.println("Enter pan address");
				String paddress=sc.next();
				PanCard card=new PanCard();
				card.setP_address(paddress);
				card.setP_id(pid);
				card.setP_name(pname);
				
				dao2.updatePan(card);
				
				
			}break;
			
			case 4:
			{
				System.out.println("please enter id to delete your details");
				int id=sc.nextInt();
				dao.deletePerson(id);
			}break;
			
			case 5:{
				System.out.println("please enter id to delete your PanCard details");
				int id=sc.nextInt();
				try {
					dao2.deletePan(id);
				} catch (Exception e) {
					System.out.println("Your data cant be deletd for pan  pls first delete your details "
							+ "choose 4 or delete all your details choose  9");
					
				}
				
			}break;
			case 6:
			{
				System.out.println("please enter id to get details of you");
				int id=sc.nextInt();
				dao.detailsById(id);
			}break;
			
			case 7:{
				System.out.println("please enter id to get details of your panCard");
				int id=sc.nextInt();
				dao2.panDetailsById(id);
				
			}break;
			case 8:{
				
				dao.detailsALL();
			}break;
			case 9:
			{System.out.println("please enter id to delete all details");
			int id=sc.nextInt();
			dao.deleteAllPerson(id);
				
			}
			case 10:{
				check=false;
			}break;
				
				

			
			}
			
		}while(check);
		System.out.println("======thank you=====");

	}

}
