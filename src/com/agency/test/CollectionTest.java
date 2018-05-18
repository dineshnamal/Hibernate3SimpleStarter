package com.agency.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;
import com.agency.domain.Consultant;

public class CollectionTest {
	
	
	public Set<Consultant> gddConsultants(){
		Set<Consultant> consultantSet = new HashSet<Consultant>();
		consultantSet.add(getConsultant("namal","namalk","123456","namal@tramada.com","112763150","0426488070","SE","112763895"));
		consultantSet.add(getConsultant("kamal","kamalk","123457","kamal@tramada.com","212763150","0426488071","SE","112763896"));
		consultantSet.add(getConsultant("namal","ramalk","123456","ramal@tramada.com","312763150","0426488072","SE","112763897"));
		consultantSet.add(getConsultant("namal","bamalk","123456","bamal@tramada.com","412763150","0426488073","SE","112763898"));
		return consultantSet;
	}
	
	private Consultant getConsultant(String name,String userName,String password, String email,String fax,String homeMobilePhone, String position,String workPhone) {
		Consultant consultant = new Consultant();
		consultant.setEmail(email);
		consultant.setDateOfBirth(new Date());
		consultant.setFax(fax);
		consultant.setHomeMobilePhone(homeMobilePhone);
		consultant.setName(name);
		consultant.setPassword(password);
		consultant.setPosition(position);
		consultant.setReportingEmail(email);
		consultant.setUserName(userName);
		consultant.setWorkPhone(workPhone);
		return consultant;
	}
	
	

	public static void main(String[] args) {
		Agency agency = new Agency();
		agency.setCode("A00016");
		agency.setName("CTM");
		agency.setFirstFinancialPeriodDate(new Date());
		agency.setDescription("The Tower Travel");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		CollectionTest ct = new CollectionTest();
		Set<Consultant> consultants = ct.gddConsultants();
		//agency.setConsultants(consultants);
		
	    session.beginTransaction();
		session.save(agency);
		session.getTransaction().commit();

	}

}
