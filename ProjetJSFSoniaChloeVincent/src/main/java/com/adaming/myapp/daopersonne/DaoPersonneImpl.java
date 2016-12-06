package com.adaming.myapp.daopersonne;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoPersonneImpl implements IDaoPersonne {
	
	@PersistenceContext
	protected EntityManager em;

}
