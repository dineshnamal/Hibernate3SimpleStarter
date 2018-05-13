package com.agency.test;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;
import com.agency.domain.AgencyGST;

public class ObjectRelationshipEmbeddableTest {
	// Agency has Address which is a complex type 
	// Where the Address has (address Line 2 , address line 2 , state , city , country ....So on)
	// Approach one - 1 Seperate columns 
	
	
	public static void main(String[] a) {
		Agency agency = new Agency();
		agency.setCode("A0003");
		agency.setName("CTM");
		agency.setFirstFinancialPeriodDate(new Date());
		agency.setDescription("The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa  The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwaThe hanguwa The hanguwa The hanguwaThe hanguwa");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
	    session.beginTransaction();
		
		AgencyGST agencyGSTAu = new AgencyGST();
		agencyGSTAu.setGstName("GST AU");
		agencyGSTAu.setGstPercentage(new BigDecimal(10.0));
		agencyGSTAu.setGstTaxCode("AUO");
		
		AgencyGST agencyGSTUs = new AgencyGST();
		agencyGSTUs.setGstName("GST US");
		agencyGSTUs.setGstPercentage(new BigDecimal(10.0));
		agencyGSTUs.setGstTaxCode("USO");
		
		agency.setAgencyAUGst(agencyGSTUs);
		
		
		session.save(agency);
		session.getTransaction().commit();	
	}

}
