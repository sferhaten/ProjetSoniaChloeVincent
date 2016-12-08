package com.adaming.myapp.daohotel;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.adaming.myapp.entities.Hotel;



public class DaoHotelImpl implements IDaoHotel {

	@PersistenceContext
	private EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger("DaoHotelImpl");

	@Override
	public Hotel addHotel(final Hotel h) {
		em.persist(h);
		LOGGER.info("<--------- Hotel " + h.getIdHotel() + " has been created -------->");
		return h;
	}

	@Override
	public Hotel getHotel(final Long id) {
		Hotel h = em.find(Hotel.class, id);
		LOGGER.info("<--------- Hotel " + id + " has been found -------->");
		return h;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getAll() {
		return em.createQuery("from Hotel").getResultList();
	}





}
