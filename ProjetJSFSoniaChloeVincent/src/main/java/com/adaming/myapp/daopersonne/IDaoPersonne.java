package com.adaming.myapp.daopersonne;



import java.util.List;

import com.adaming.myapp.entities.Personne;

public interface IDaoPersonne {

	
	Personne addPersonne(Personne P, Long idHotel);
	
	Personne getPersonne(Long idPersonne);
	List<Personne> getAll();
	Personne updatePersonne(Personne P);
}
