package com.adaming.myapp.daohotel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoHotelImpl implements IDaoHotel {

	@PersistenceContext
	private EntityManager em;
}
