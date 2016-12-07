package com.adaming.myapp.daopayement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Payement;

public class DaoPayementImpl implements IDaoPayement {
	
	@PersistenceContext
	protected EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger(DaoPayementImpl.class);



	@Override
	public Payement updatePayement(Payement p) {
		em.merge(p);
		LOGGER.info(p + "has been update");
		return p;
	}

	@Override
	public Payement getOnePayement(Long idPayement) {
		Payement p =em.find(Payement.class, idPayement);
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Payement> getAllPayement() {
		Query query = em.createQuery("from Payement p");
		return query.getResultList();
	}

	@Override
	public Payement addPayement(Payement p, Long idFacture) {
		
		Facture f = em.find(Facture.class, idFacture);
		
		em.persist(p);
		f.setPayement(p);
		LOGGER.info(p + "has been created");
		return p;
	}

}
