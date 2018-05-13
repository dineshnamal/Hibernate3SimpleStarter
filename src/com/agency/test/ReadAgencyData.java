package com.agency.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;

public class ReadAgencyData {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		//Get Example
				Agency agency2 = (Agency)session.get(Agency.class, 4);
				System.out.println("Getting");
				System.out.println(agency2.getDescription());
				
				//load Example
				Agency agency3 = (Agency)session.load(Agency.class, 4);
				System.out.println("Loading");
				System.out.println(agency3.getDescription());
		
		/*
		 *Output 
		 *
		 *Hibernate: select agency0_.AGENCY_ID as AGENCY1_0_0_, agency0_.CODE as CODE0_0_, agency0_.DESCRIPTION as DESCRIPT3_0_0_, agency0_.FIRST_FINANCIAL_PERIOD_DATE as FIRST4_0_0_, agency0_.NAME as NAME0_0_ from AGENCY agency0_ where agency0_.AGENCY_ID=?
			Getting
		  The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa  The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwaThe hanguwa The hanguwa The hanguwaThe hanguwa
			Loading
		   The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa  The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwa The hanguwaThe hanguwa The hanguwa The hanguwaThe hanguwa
		 
		 Conclution
		 ==========
		 From the output it’s clear that get() returns the object by fetching it from database or from hibernate cache whereas load() just returns the reference of an object that might not actually exists, it loads the data from database or cache only when you access other properties of the object.
		  let’s try to fetch data that doesn’t exists in the database.
		 
		 */
				
				try {
					 agency2 = (Agency)session.get(Agency.class, 40);
					 System.out.println("Get called");
					 System.out.println(agency2);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					 agency3 = (Agency)session.load(Agency.class, 40);
					 System.out.println("Load called");
					 System.out.println(agency3.getId());
					 System.out.println(agency3);
					 
					 /*Hibernate: select agency0_.AGENCY_ID as AGENCY1_0_0_, agency0_.CODE as CODE0_0_, agency0_.DESCRIPTION as DESCRIPT3_0_0_, agency0_.FIRST_FINANCIAL_PERIOD_DATE as FIRST4_0_0_, agency0_.NAME as NAME0_0_ from AGENCY agency0_ where agency0_.AGENCY_ID=?
org.hibernate.ObjectNotFoundException: No row with the given identifier exists: [com.agency.domain.Agency#40]
	at org.hibernate.impl.SessionFactoryImpl$2.handleEntityNotFound(SessionFactoryImpl.java:435)
	at org.hibernate.proxy.AbstractLazyInitializer.checkTargetState(AbstractLazyInitializer.java:189)
	at org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:178)
	at org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:215)
	at org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer.invoke(JavassistLazyInitializer.java:190)
	at com.agency.domain.Agency_$$_javassist_0.toString(Agency_$$_javassist_0.java)
	at java.lang.String.valueOf(String.java:2994)
	at java.io.PrintStream.println(PrintStream.java:821)
	at com.agency.test.ReadAgencyData.main(ReadAgencyData.java:53)

*/
				}catch(Exception e) {
					e.printStackTrace();
				}

	}

}

/*
 * 
 * 1. get() loads the data as soon as it’s called whereas load() returns a proxy object and loads data only when it’s actually required, so load() is better because it support lazy loading.
   2. Since load() throws exception when data is not found, we should use it only when we know data exists.
   3. We should use get() when we want to make sure data exists in the database.
   
   Reference - https://www.journaldev.com/3472/hibernate-session-get-vs-load-difference-with-examples
 */
