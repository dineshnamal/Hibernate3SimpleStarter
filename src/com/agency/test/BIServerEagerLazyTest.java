package com.agency.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;

public class BIServerEagerLazyTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Agency agency = (Agency)session.get(Agency.class, 14);
		System.out.println(agency.getCode());
		System.out.println("==================================================================");
		System.out.println(agency.getBiServers().size());
		

	}

}
