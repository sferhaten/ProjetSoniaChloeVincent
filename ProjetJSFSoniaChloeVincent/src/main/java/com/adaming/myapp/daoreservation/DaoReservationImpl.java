package com.adaming.myapp.daoreservation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Reservation;

public class DaoReservationImpl implements IDaoReservation {
	
	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger(DaoReservationImpl.class);
	
	@Override
	public Reservation addReservation(Reservation r, Long idClient, Long idHotel, Long idChambre) {
		Client client =em.find(Client.class, idClient);
		r.setPersonne(client);
		
		client.setNombreReservations(client.getNombreReservations());
		Hotel h =em.find(Hotel.class, idHotel);
		Chambre c = em.find(Chambre.class, idChambre);
		
		r.setHotel(h);
		r.setChambre(c);
		em.persist(r);
		Double coutResa =0.0;
		int nbJour = (int) ((r.getDateSortie().getTime() -r.getDateArrive().getTime())/(3600*24*1000));
		coutResa = c.cout()*nbJour;
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

	@Override
	public Reservation Annulation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		Hotel h = em.find(Hotel.class, r.getHotel().getIdHotel());
		Client client =em.find(Client.class, r.getPersonne().getIdPersonne());
		Chambre c = em.find(Chambre.class, r.getChambre().getIdChambre());
		Facture f = em.find(Facture.class, r.getFacture().getIdFacture());
		h.getReservations().remove(r);
		client.getReservations().remove(r);
		client.setNombreReservations(client.getNombreReservations()-1);
		c.getReservations().remove(r);
		f.getReservations().remove(r);
		em.remove(r);
		return r;
	}

}
