package com.adaming.myapp.daohotel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;

public class DaoHotelImpl implements IDaoHotel {

	@PersistenceContext
	private EntityManager em;
	
	private final Logger LOGGER = Logger.getLogger("DaoHotelImpl");

	@Override
	public Hotel addHotel(Hotel h) {
		em.persist(h);
		LOGGER.info("<--------- Hotel " + h.getIdHotel() + " has been created -------->");
		return h;
	}

	@Override
	public Hotel getHotel(Long id) {
		Hotel h = em.find(Hotel.class, id);
		LOGGER.info("<--------- Hotel " + id + " has been found -------->");
		return h;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getAll() {
		return em.createQuery("from Hotel").getResultList();
	}

//	@Override
//	public Set<Client> clientsByHotel(Long idHotel) {
//		Hotel h = getHotel(idHotel);
//		Set<Client> clients = new HashSet<Client>();
//		for (Personne p : h.getPersonnes()) {
//			if (p.getClass().toString().equals("Client")) {
//				clients.add((Client) p);
//			}
//		}
//		
//		return clients;
//	}
//
//	@Override
//	public Set<Employe> employesByHotel(Long idHotel) {
//		Hotel h = getHotel(idHotel);
//		Set<Employe> employes = new HashSet<Employe>();
//		for (Personne p : h.getPersonnes()) {
//			if (p.getClass().toString().equals("Employe") ) {
//				employes.add((Employe) p);
//			}
//		}
//		
//		return employes;
//	}
//	
//
//	@Override
//	public Set<Produit> produitsByHotel(Long idHotel) {
//		Hotel h = getHotel(idHotel);
//		return h.getProduits();
//	}
//
//	@Override
//	public Set<Personne> personnesByHotel(Long idHotel) {
//		Hotel h = em.find(Hotel.class, idHotel);
//		return h.getPersonnes();
//	}
//	
	

}
