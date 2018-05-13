package com.agency.custom;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class BINumberGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor sessionImpl, Object data) throws HibernateException {
		Random rand = new Random();
		int  n = rand.nextInt(5) + 1;
		return n;
	}

}
