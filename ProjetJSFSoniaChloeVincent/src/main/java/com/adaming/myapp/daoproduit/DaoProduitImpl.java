package com.adaming.myapp.daoproduit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoProduitImpl implements IDaoProduit {
	
	@PersistenceContext
	private EntityManager em;

}
