package com.adaming.myapp.daochambre;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Hotel;


public class DaoChambreImpl implements IDaoChambre {
	
	@PersistenceContext
	private EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger(DaoChambreImpl.class);
	

	@Override
	public Chambre updateChambre(Chambre c) {
		em.merge(c);
		LOGGER.info(c + "has been updated");
		return c;
	}

	@Override
	public Chambre getOneChambre(Long idChambre) {
		Chambre c = em.find(Chambre.class, idChambre);
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Chambre> getAllChambre() {
		Query query = em.createQuery("from Chambre c");
		return query.getResultList();
	}

	@Override
	public Chambre addChambre(Chambre c, Long idHotel) {
		Hotel h = em.find(Hotel.class, idHotel);
	
		em.persist(c);
		h.getChambres().add(c);
		LOGGER.info(c + "has been created");
		return c;
	}

	
}
