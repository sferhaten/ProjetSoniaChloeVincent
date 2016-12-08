package com.adaming.myapp.daopersonne;

import java.util.List;






import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;

public class DaoPersonneImpl implements IDaoPersonne {
	
	private final Logger LOGGER = Logger.getLogger("DaoPersonneImpl");
	@PersistenceContext
	protected EntityManager em;

	
	
	@Override
	public Personne addPersonne(Personne P, Long idHotel) {
		Hotel h = em.find(Hotel.class, idHotel);
		
		em.persist(P);
		h.getPersonnes().add(P);
		
		return P;
	}

	@Override
	public Personne getPersonne(Long idPersonne) {
		Personne P = em.find(Personne.class, idPersonne); 
		LOGGER.info("<-----------"+P+" getted ------------------->");
		return P;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getAll() {
		Query query = em.createQuery("from Personne P");
		return query.getResultList();
	}

	@Override
	public Personne updatePersonne(Personne P) {
		em.merge(P);
		LOGGER.info("<-----------"+P+" updated ------------------->");
		return P;
	}



}
