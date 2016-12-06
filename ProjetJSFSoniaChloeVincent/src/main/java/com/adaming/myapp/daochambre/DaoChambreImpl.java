package com.adaming.myapp.daochambre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoChambreImpl implements IDaoChambre {
	
	@PersistenceContext
	private EntityManager em;

}
