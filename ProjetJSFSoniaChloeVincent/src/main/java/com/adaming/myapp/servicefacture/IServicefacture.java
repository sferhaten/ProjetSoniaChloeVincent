package com.adaming.myapp.servicefacture;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;

public interface IServicefacture {
	

	Facture addFactureToReservation(final Facture f, Set<Reservation> reservations, final Long idPersonne, final Long idHotel);
	Facture addFactureToConsomation(final Facture f, Set<Consomation> consomations, final Long idPersonne, final Long idHotel );
	Facture addFacture(final Facture f, Set<Reservation> reservations, Set<Consomation> consomations, final Long idPersonne, final Long idHotel);
	
	Facture updateFacture(final Facture f);
	
	Facture getOneFacture(final Long  idFacture);
	
	List<Facture> getAllFacture ();
	
	Set<Consomation> getConsoByFacture ( Long idFacture);
	Set<Reservation> getReserByFacture (Long idFacture);

}
