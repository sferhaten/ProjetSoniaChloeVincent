package com.adaming.myapp.daopayement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class DaoPayementImpl implements IDaoPayement {

	
	@PersistenceContext
	protected EntityManager em;

}
