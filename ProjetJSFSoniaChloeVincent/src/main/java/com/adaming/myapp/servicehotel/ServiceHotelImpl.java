package com.adaming.myapp.servicehotel;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;













import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.daohotel.IDaoHotel;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.entities.Reservation;

@Transactional
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
		//System.out.println("getClass de la personne : " + p.getClass().toString() );
		//System.out.println("getClass().getName() de la personne : " + p.getClass().getName() );
		//System.out.println("getClass().getSimpleName() de la personne : " + p.getClass().getSimpleName() );
		System.out.println("Superclass de la personne : " + p.getClass().getSuperclass() );
			if (p.getClass().getSuperclass().getSimpleName().equals("Employe") ) {
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
			//System.out.println("getClass de la personne : " + p.getClass().toString() );
			//System.out.println("getClass().getName() de la personne : " + p.getClass().getName() );
			//System.out.println("getClass().getSimpleName() de la personne : " + p.getClass().getSimpleName() );
			System.out.println("Superclass de la personne : " + p.getClass().getSuperclass() );
				if (p.getClass().getSimpleName().equals("Client") ) {
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
	public Set<Produit> produitsNonDisposByHotel(Long idHotel) {
Set<Produit> produits = produitsByHotel(idHotel);
		
		Set<Produit> produitsNonDispos = new HashSet<Produit>();
		
		for (Produit p : produits) {
			if (p.getQuantite() == 0) {
				produitsNonDispos.add(p);
			}
		}
		
		return produitsNonDispos;
	}



	@Override
	public Double beneficeAnnuel(final Long idHotel) {
		Hotel h = dao.getHotel(idHotel);
		Double recettes = 0.0;
		Double charges = 0.0;
		Double benefice = 0.0;
		
		for (Facture f : h.getFactures()) {
			recettes = recettes + f.getCoutConso() + f.getCoutResa();
			System.out.println("Facture : ");
			System.out.println("Cout conso : " + f.getCoutConso());
			System.out.println("Cout resa : " + f.getCoutResa());
		}
		
		for (Employe emp : employesByHotel(idHotel)) {
			charges = charges + emp.salaireTotal();
			System.out.println("Employe " + emp.getIdPersonne() + " :");
			System.out.println("Salaire Total : " + emp.salaireTotal());
		}
		
		System.out.println("Recettes : " + recettes);
		System.out.println("Charges : " + charges);
		benefice = recettes - charges;
		return benefice;
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
