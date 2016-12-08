package com.adaming.myapp.servicepersonne;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;




import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.daopersonne.IDaoPersonne;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Reservation;
@Transactional
public class ServicePersonneImpl implements IServicePersonne {
	
	
	private IDaoPersonne dao;

	public void setDao(IDaoPersonne dao) {
		this.dao = dao;
	}




	@Override
	public Personne addPersonne(Personne P, Long idHotel) {
		
		return dao.addPersonne(P, idHotel);
	}
	
	@Override
	public Personne getPersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return dao.getPersonne(idPersonne);
	}

	@Override
	public List<Personne> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Personne updatePersonne(Personne P) {
		// TODO Auto-generated method stub
		return dao.updatePersonne(P);
	}




	@Override
	public Set<Reservation> reservations(Long idPersonne) {
		Personne p = dao.getPersonne(idPersonne);
		
		return p.getReservations();
	}




	@Override
	public Set<Reservation> reservationsNonFacturees(Long idPersonne) {
		Personne p = dao.getPersonne(idPersonne);
		
		Set<Reservation> reservations = reservations(idPersonne);
		Set<Reservation> reservationsNonFacturees = new HashSet<Reservation>();
		
		for (Reservation r : reservations) {
			if (r.getFacture() == null) {
				reservationsNonFacturees.add(r);
			}
		}
		
		return reservationsNonFacturees;
	}




	@Override
	public Set<Consomation> consomations(Long idPersonne) {
		Personne p = dao.getPersonne(idPersonne);
		
		return p.getConsomations();
	}




	@Override
	public Set<Consomation> consomationsNonFacturees(Long idPersonne) {
		
		Personne p = dao.getPersonne(idPersonne);
		
		Set<Reservation> reservations = p.getReservations();
		Iterator<Reservation> iter = reservations.iterator();
		Reservation reserv = iter.next();
		
		Hotel h = reserv.getHotel();
		
		Set<Consomation> consomations = consomations(idPersonne);
		Set<Consomation> consomationsNonFacturees = new HashSet<Consomation>();
		
		
		
		for (Consomation c : consomations) {
			for (Facture f : h.getFactures()) {
				for (Consomation conso : f.getConsomation()) {
					if (conso.getIdConsommation() == c.getIdConsommation()) {
						consomationsNonFacturees.add(c);
					}
				}
			}
		}
		
		return consomationsNonFacturees;
		
	}



	

}
