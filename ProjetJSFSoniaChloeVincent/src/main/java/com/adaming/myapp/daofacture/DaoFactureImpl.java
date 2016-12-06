package com.adaming.myapp.daofacture;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;

public class DaoFactureImpl implements IDaoFacture {
	
	@PersistenceContext
	private EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger(DaoFactureImpl.class);

	@Override
	public Facture addFacture(Facture f) {
		em.persist(f);
		LOGGER.info(f + "has been created");
		return f;
	}

	@Override
	public Facture updateFacture(Facture f) {
		em.merge(f);
		LOGGER.info(f + "has been update");
		return f;
	}

	@Override
	public Facture getOneFacture(Long idFacture) {
		Facture f = em.find(Facture.class, idFacture);
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

}
