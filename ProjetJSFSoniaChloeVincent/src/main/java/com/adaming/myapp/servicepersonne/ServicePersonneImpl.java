package com.adaming.myapp.servicepersonne;

import java.util.List;



import com.adaming.myapp.daopersonne.IDaoPersonne;
import com.adaming.myapp.entities.Personne;

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



	

}
