package com.adaming.myapp.daoconsomation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Produit;

public class DaoConsomationImpl implements IDaoConsomation {
	
	@PersistenceContext
	private EntityManager em;

	@Override 
	 	public Consomation addConsommation(Consomation c, Long idClient, 
	 			Long idProduit) { 
			 
	 		Client cl = em.find(Client.class, idClient); 
	 		 
	 		Produit p = em.find(Produit.class, idProduit); 
	 		 
	 		//Hotel h = em.find(Hotel.class, idHotel); 
	 		 
	 		c.setProduit(p); 
	 		em.persist(c); 
	 		 
	 		p.setQuantite(p.getQuantite()-c.getQuantite()); 
	 		 
	 		cl.getConsomations().add(c); 
	 		 
	 		return c; 
	 	} 
	 
	 
	 	@Override 
	 	public Consomation updateConsommation(Consomation c) { 
	 		em.merge(c); 
	 		return c; 
	 	} 
	 	 
	 	@Override 
	 	public Consomation getConsommation(Long idConsommation) { 
	 		Consomation c =em.find(Consomation.class, idConsommation); 
	 		return c; 
	 	} 
	 
	 
	 	@Override 
	 	public List<Consomation> consommations() { 
	 		List<Consomation> consommations = (List<Consomation>) em.createQuery("from Consomation"); 
	 		return consommations; 
	 	} 

}
