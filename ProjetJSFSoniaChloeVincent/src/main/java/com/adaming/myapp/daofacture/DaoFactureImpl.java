package com.adaming.myapp.daofacture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoFactureImpl implements IDaoFacture {
	
	@PersistenceContext
	private EntityManager em;

}
