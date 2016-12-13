package com.adaming.myapp.daoconsomation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	 		 System.out.println("le client est " + cl.getNom());
	 		Produit p = em.find(Produit.class, idProduit); 
	 		 
	 		//Hotel h = em.find(Hotel.class, idHotel); 
	 		 
	 		c.setProduit(p); 
	 		c.setPersonne(cl);
	 		p.setQuantite(p.getQuantite()-c.getQuantiteConsomation()); 
	 		 
	 		cl.getConsomations().add(c); 
	 		em.persist(c); 
	 		System.out.println("identifiant " + c.getPersonne().getIdPersonne());
	 		System.out.println("tableau" + cl.getConsomations().size());
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
	 
	 
	 	@SuppressWarnings("unchecked")
		@Override 
	 	public List<Consomation> consommations() { 
	 		Query query = em.createQuery("from Consomation"); 
	 		return query.getResultList(); 
	 	} 

}
