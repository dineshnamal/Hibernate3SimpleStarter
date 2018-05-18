package com.agency.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.agency.domain.Agency;
import com.agency.domain.BIServer;

public class BIServerTest {

	private Set<BIServer> getBIServer(){
		Set<BIServer> biServerSet = new HashSet<BIServer>();
		biServerSet.add(initiBIServer("1qaz2wsx@","admin1","biserver1",true,true));
		biServerSet.add(initiBIServer("1qaz2wsx@","admin2","biserver2",true,true));
		biServerSet.add(initiBIServer("1qaz2wsx@","admin3","biserver3",true,true));
		biServerSet.add(initiBIServer("1qaz2wsx@","admin4","biserver4",true,true));
		return biServerSet;
	}
	
	private BIServer initiBIServer(String adminPwd,String biAdminUsername,String biServerAddress,boolean showAlternativeReportingEngine, boolean showAlternativeReportingEngineForOnlineUsers) {
		BIServer biServer = new BIServer();
		biServer.setBiAdminPassword(adminPwd);
		biServer.setBiAdminUsername(biAdminUsername);
		biServer.setBiServerAddress(biServerAddress);
		biServer.setShowAlternativeReportingEngine(showAlternativeReportingEngine);
		biServer.setShowAlternativeReportingEngineForOnlineUsers(showAlternativeReportingEngineForOnlineUsers);
		return biServer;
		
	}
	public static void main(String[] args) {
		Agency agency = new Agency();
		agency.setCode("A00017");
		agency.setName("CTM");
		BIServerTest biServerTest = new BIServerTest();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		agency.setBiServers(biServerTest.getBIServer());
		session.save(agency);
		session.getTransaction().commit();

	}

}
