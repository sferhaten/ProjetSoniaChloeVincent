package com.adaming.myapp.servicereservation;

import java.util.List;

import org.jboss.logging.Logger;

import com.adaming.myapp.daoreservation.IDaoReservation;
import com.adaming.myapp.entities.Reservation;

public class ServiceReservationImpl implements IServiceReservation {
	
	private IDaoReservation dao;
	
	private final Logger LOGGER = Logger.getLogger(ServiceReservationImpl.class);

	public void setDao(IDaoReservation dao) {
		this.dao = dao;
		LOGGER.info("<----- Dao Reservation injected ----->");
	}

	@Override
	public Reservation addReservation(Reservation r) {
		// TODO Auto-generated method stub
		return dao.addReservation(r);
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		// TODO Auto-generated method stub
		return dao.updateReservation(r);
	}

	@Override
	public Reservation getOneReservation(Long idReservation) {
		// TODO Auto-generated method stub
		return dao.getOneReservation(idReservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return dao.getAllReservation();
	}
	
	
}
