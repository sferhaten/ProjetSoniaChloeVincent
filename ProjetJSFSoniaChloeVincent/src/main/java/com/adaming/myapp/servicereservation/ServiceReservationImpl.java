package com.adaming.myapp.servicereservation;

import com.adaming.myapp.daoreservation.IDaoReservation;

public class ServiceReservationImpl implements IServiceReservation {
	
	private IDaoReservation dao;

	public void setDao(IDaoReservation dao) {
		this.dao = dao;
	}
	
	
}
