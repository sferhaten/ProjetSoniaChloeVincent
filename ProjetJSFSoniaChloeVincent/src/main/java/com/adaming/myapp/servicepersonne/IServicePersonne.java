package com.adaming.myapp.servicepersonne;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Personne;

public interface IServicePersonne {

	

	Personne addPersonne(Personne P);
	Personne getPersonne(Long idPersonne);
	List<Personne> getAll();
	Personne updatePersonne(Personne P);
}
