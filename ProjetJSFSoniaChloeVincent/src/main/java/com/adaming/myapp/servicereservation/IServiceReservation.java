package com.adaming.myapp.servicereservation;

import java.util.List;

import com.adaming.myapp.entities.Reservation;

public interface IServiceReservation {
	
	Reservation addReservation(final Reservation r);
	
	Reservation updateReservation(final Reservation r);
	
	Reservation getOneReservation(final Long  idReservation);
	
	List<Reservation> getAllReservation ();

}
