package com.adaming.myapp.servicehotel;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;

public interface IServiceHotel {

	
	Hotel addHotel(Hotel h);
	
	Hotel getHotel(Long id);
	
	List<Hotel> getAll();
	
	Set<Client> clientsByHotel(final Long idHotel);

	Set<Employe> employesByHotel(final Long idHotel);
	
	//Set<Personne> typePersonnesByHotel(final Long idHotel, final String type);
	
	Set<Produit> produitsByHotel(final Long idHotel);
	
	Set<Produit> produitsDisposByHotel(final Long idHotel);
	
	Set<Produit> produitsNonDisposByHotel(final Long idHotel);
	
	Set<Chambre> chambreByHotel(final Long idHotel);
	
	Set<Chambre> chambreDisposByHotel(final Long idHotel, final Date dateDemandee);
	
	//Set<Personne> personnesByHotel(Long idHotel);
	
	Double beneficeAnnuel(final Long idHotel);
	
	Set<Chambre> chambreSimpleDisposByHotel(final Long idHotel, final Date dateDemandee1, final Date dateDemandee2);
	
	Set<Chambre> chambreDoubleDisposByHotel(final Long idHotel, final Date dateDemandee1, final Date dateDemandee2);
	
	Set<Chambre> chambreSuiteDisposByHotel(final Long idHotel, final Date dateDemandee1, final Date dateDemandee2);
	
	
}
