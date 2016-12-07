package com.adaming.myapp.servicehotel;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;









import com.adaming.myapp.daohotel.IDaoHotel;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.entities.Reservation;

public class ServiceHotelImpl implements IServiceHotel{

	
	private IDaoHotel dao;


	public void setDao(IDaoHotel dao) {
		this.dao = dao;
	}


	@Override
	public Hotel addHotel(final Hotel h) {		
		return dao.addHotel(h);
	}


	@Override
	public Hotel getHotel(final Long id) {
		return dao.getHotel(id);
	}


	@Override
	public List<Hotel> getAll() {
		return dao.getAll();
	}


//	@Override
//	public Set<Client> clientsByHotel(Long idHotel) {
//		return dao.clientsByHotel(idHotel);
//	}
//
//
//	@Override
//	public Set<Employe> employesByHotel(Long idHotel) {
//		return dao.employesByHotel(idHotel);
//	}


//	@Override
//	public Set<Produit> produitsByHotel(Long idHotel) {
//		return dao.produitsByHotel(idHotel);
//	}


	@Override
	public Set<Employe> employesByHotel(final Long idHotel) {
		Hotel h = dao.getHotel(idHotel);
		Set<Employe> employes = new HashSet<Employe>();
		for (Personne p : h.getPersonnes()) {
		
			if (p.getClass().toString().equals("Employe") ) {
				employes.add((Employe) p);
			}
		}
		return employes;
}


	@Override
	public Set<Client> clientsByHotel(final Long idHotel) {
		Hotel h = dao.getHotel(idHotel);
		Set<Client> clients = new HashSet<Client>();
		for (Personne p : h.getPersonnes()) {
		
			if (p.getClass().toString().equals("Client") ) {
				clients.add((Client) p);
			}
		}
		return clients;
	}


	@Override
	public Set<Produit> produitsByHotel(final Long idHotel) {
		Hotel h = dao.getHotel(idHotel);
		return h.getProduits();
	}
	
	@Override
	public Set<Produit> produitsDisposByHotel(Long idHotel) {
		Set<Produit> produits = produitsByHotel(idHotel);
		
		Set<Produit> produitsDispos = new HashSet<Produit>();
		
		for (Produit p : produits) {
			if (p.getQuantite() > 0) {
				produitsDispos.add(p);
			}
		}
		
		return produitsDispos;
	}


	@Override
	public Double beneficeAnnuel(final Long idHotel) {
		Hotel h = dao.getHotel(idHotel);
		Double recettes = 0.0;
		Double charges = 0.0;
		Double benefice = 0.0;
		
		for (Reservation r : h.getReservations()) {
			recettes = recettes + r.getCoutResa();
		}
		
		for (Personne p : h.getPersonnes()) {
			
			for (Consomation c : p.getConsomations()) {
				
				recettes = recettes + (c.getQuantite() * (c.getProduit().getCoutVente()-c.getProduit().getCoutAchat()));
				
			}
		}
		
		
		
		return 0.0;
	}


	@Override
	public Set<Chambre> chambreByHotel(final Long idHotel) {
		// TODO Auto-generated method stub
		return dao.getHotel(idHotel).getChambres();
	}


	@Override
	public Set<Chambre> chambreDisposByHotel(Long idHotel, Date dateDemandee) {
		
		Set<Chambre> chambres = chambreByHotel(idHotel);
		Set<Chambre> chambresDispos = new HashSet<Chambre>();
		
		
		for (Chambre c : chambres) {
			if (c.DispoChambre(dateDemandee)) {
				chambresDispos.add(c);
			}
		}
		
		return chambresDispos;
	}



	
	
	
}
