package com.adaming.myapp.daoreservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoReservationImpl implements IDaoReservation {
	
	@PersistenceContext
	private EntityManager em;

}
