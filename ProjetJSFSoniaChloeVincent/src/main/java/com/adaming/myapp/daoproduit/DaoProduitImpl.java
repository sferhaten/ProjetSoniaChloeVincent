package com.adaming.myapp.daoproduit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Produit;

public class DaoProduitImpl implements IDaoProduit {
	
	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger(DaoProduitImpl.class);

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		LOGGER.info(p + "has been created");
		return p;
	}

	@Override
	public Produit updateProduit(Produit p) {
		em.merge(p);
		LOGGER.info(p + "has been edited");
		return p;
	}

	@Override
	public Produit getOneProduit(Long idProduit) {
		Produit p = em.find(Produit.class, idProduit);
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduit() {
		Query query = em.createQuery("from Produit p");
		return query.getResultList();
	}

	@Override
	public List<Produit> getStock() {
		
		return null;
	}
	
}
