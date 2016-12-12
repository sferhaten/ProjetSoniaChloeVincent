package com.adaming.myapp.servicepersonne;

import java.util.List;


import java.util.Set;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Reservation;

public interface IServicePersonne {

	

	Personne addPersonne(Personne P, Long idHotel);
	
	Personne getPersonne(Long idPersonne);
	
	List<Personne> getAll();
	
	Personne updatePersonne(Personne P);
	
	Set<Reservation> reservations(Long idPersonne);
	
	Set<Reservation> reservationsNonFacturees(Long idPersonne);
	
	Set<Consomation> consomations(Long idPersonne);
	
	Set<Consomation> consomationsNonFacturees(Long idPersonne);
	Set<Consomation> consomationsFacturees(Long idPersonne);
	
	
}
