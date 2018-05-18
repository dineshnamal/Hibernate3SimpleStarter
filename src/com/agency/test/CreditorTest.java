package com.agency.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;
import com.agency.domain.Creditor;

public class CreditorTest {

	public static void main(String[] args) {
	Creditor creditor = new Creditor();
	creditor.setCreditorCode("EXPEDIA");
	
	Agency agency = new Agency();
	agency.setCode("A00016");
	agency.setName("CTM");
	agency.setCommissionCreditor(creditor);
	
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(creditor);
	session.save(agency);
	session.getTransaction().commit();

	}

}
