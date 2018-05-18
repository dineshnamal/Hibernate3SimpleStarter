package com.agency.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;
import com.agency.domain.Branch;

public class BranchTest {

	public static void main(String ap[]) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Agency agency = new Agency();
		agency.setCode("A00016");
		agency.setName("CTM");
		
		
		Branch one = new Branch();
		one.setCode("BraOne");
		one.setName("BraOne");
		one.setAgency(agency);
		
		Branch two = new Branch();
		two.setCode("BraTwo");
		two.setName("BraTwo");
		two.setAgency(agency);
		
		session.beginTransaction();
		session.save(agency);
		session.save(one);
		session.save(two);
		
		agency.getBranch().add(one);
		agency.getBranch().add(two);
		
	
		session.getTransaction().commit();

	}
}
