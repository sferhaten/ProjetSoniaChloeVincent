package com.adaming.myapp.daofacture;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;

import com.adaming.myapp.entities.Reservation;

public class DaoFactureImpl implements IDaoFacture {
	
	@PersistenceContext
	private EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger(DaoFactureImpl.class);



	@Override
	public Facture updateFacture(Facture f) {
		em.merge(f);
		LOGGER.info(f + "has been updated");
		return f;
	}

	@Override
	public Facture getOneFacture(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
		LOGGER.info(f + "has been found");
		return f;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Facture> getAllFacture() {
		Query query = em.createQuery("from Facture c");
		return query.getResultList();
	}

	@Override
	public Set<Consomation> getConsoByFacture(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
		Set<Consomation> consomations = f.getConsomation();
		LOGGER.info("la liste des consomation par facture: " + consomations);
		return  consomations;
	}
	
	@Override
	public Set<Reservation> getReserByFacture(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
		Set<Reservation> reservations = f.getReservations();
		LOGGER.info("la liste des reservations par facture: " + reservations);
		return reservations;
	}

	@Override
	public Facture addFactureToReservation(Facture f, Set<Reservation> reservations, Long idHotel) {
		
		f.setReservations(reservations);
			
		Hotel h = em.find(Hotel.class, idHotel);
		f.setHotel(h);
		
		em.persist(f);
		
		for (Reservation r : reservations) {
			System.out.println("Reservation : " + r);
			r.setFacture(f);
			em.merge(r);
			System.out.println("Reservation trouv�e : " + r.getIdReservation());
		}
		
		LOGGER.info(f + "has been created");
		
		return f;
		
		
		
		
	}

	@Override
	public Facture addFactureToConsomation(Facture f,
			Set<Consomation> consomations, Long idHotel) {
		
		f.setConsomation(consomations);
		
		Hotel h = em.find(Hotel.class, idHotel);
		f.setHotel(h);
		
		em.persist(f);
		
		
		return f;
	}

	@Override
	public Facture addFacture(Facture f, Set<Reservation> reservations,
			Set<Consomation> consomations, Long idHotel) {
		
		f.setReservations(reservations);
		f.setConsomation(consomations);
					
		Hotel h = em.find(Hotel.class, idHotel);
		f.setHotel(h);

		em.persist(f);

		for (Reservation r : reservations) {
			System.out.println("Reservation : " + r);
			r.setFacture(f);
			em.merge(r);
			System.out.println("Reservation trouv�e : " + r.getIdReservation());
		};
		
		return f;
		
	}


	
/*	Client client = em.find(Client.class, idClient);
	Banque banque = em.find(Banque.class, idBanque);
	client.getBanques().add(banque);
	banque.getClients().add(client);
	em.merge(client);
	em.merge(banque);*/

	




}
