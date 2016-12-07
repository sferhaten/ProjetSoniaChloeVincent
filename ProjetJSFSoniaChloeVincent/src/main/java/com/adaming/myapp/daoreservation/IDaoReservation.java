package com.adaming.myapp.daoreservation;

import java.util.List;

import com.adaming.myapp.entities.Reservation;

public interface IDaoReservation {

	Reservation addReservation(final Reservation r, Long idClient, Long idHotel, Long idChambre);
	
	Reservation updateReservation(final Reservation r);
	
	Reservation getOneReservation(final Long  idReservation);
	
	List<Reservation> getAllReservation ();
	
	Reservation Annulation (final Long  idReservation);


	
}
