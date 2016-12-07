package com.adaming.myapp.servicepersonne;

import java.util.List;


import com.adaming.myapp.entities.Personne;

public interface IServicePersonne {

	

	Personne addPersonne(Personne P, Long idHotel);
	Personne getPersonne(Long idPersonne);
	List<Personne> getAll();
	Personne updatePersonne(Personne P);
}
