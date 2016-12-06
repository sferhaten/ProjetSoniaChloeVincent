package com.adaming.myapp.daoconsomation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoConsomationImpl implements IDaoConsomation {
	
	@PersistenceContext
	private EntityManager em;

}
