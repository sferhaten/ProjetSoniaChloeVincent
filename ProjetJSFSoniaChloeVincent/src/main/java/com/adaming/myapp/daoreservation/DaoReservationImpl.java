package com.adaming.myapp.daoreservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Reservation;

public class DaoReservationImpl implements IDaoReservation {
	
	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger(DaoReservationImpl.class);
	
	@Override
	public Reservation addReservation(Reservation r) {
		em.persist(r);
		LOGGER.info(r + "has been created");
		return r;
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		em.merge(r);
		LOGGER.info(r + "has been update");
		return r;
	}

	@Override
	public Reservation getOneReservation(Long idReservation) {
		Reservation r= em.find(Reservation.class, idReservation);
		return r;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservation() {
		Query query = em.createQuery("from Reservation r");
		return query.getResultList();
	}

}
