package com.agency.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Branch;
import com.agency.domain.BranchCommissionConfig;

public class BranchCommissionConfigTest {

	public static void main(String[] args) {
		Branch branch1 = new Branch();
		branch1.setName("NDU");
		
		Branch branch2 = new Branch();
		branch2.setName("ABC");
		
		Branch branch3 = new Branch();
		branch2.setName("DEF");
		
		BranchCommissionConfig bcg = new BranchCommissionConfig();
		bcg.setName("BCG0");

		BranchCommissionConfig bcg1 = new BranchCommissionConfig();
		bcg1.setName("BCG1");
		

		BranchCommissionConfig bcg2 = new BranchCommissionConfig();
		bcg2.setName("BCG2");
		
		branch1.getBranchCommissionConfigList().add(bcg);
		branch1.getBranchCommissionConfigList().add(bcg1);
		branch1.getBranchCommissionConfigList().add(bcg2);
		
		branch2.getBranchCommissionConfigList().add(bcg);
		branch2.getBranchCommissionConfigList().add(bcg1);
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(branch1);
		session.save(branch2);
		session.save(branch3);
		session.save(bcg);
		session.save(bcg1);
		session.save(bcg2);
		session.getTransaction().commit();

	}

}
