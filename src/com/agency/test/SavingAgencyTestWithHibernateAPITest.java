package com.agency.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;

public class SavingAgencyTestWithHibernateAPITest {

	public static void main(String[] args) {
		Agency agency = new Agency();
		agency.setCode("A00011");
		agency.setName("CTM");
		agency.setFirstFinancialPeriodDate(new Date());
		agency.setDescription("The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa  The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwaThe hanguwa The hanguwa The hanguwaThe hanguwa");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
	    session.beginTransaction();
		session.save(agency);
		session.getTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
