package com.adaming.myapp.daohotel;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;

public interface IDaoHotel {
	
	
	Hotel addHotel(final Hotel h);
	
	Hotel getHotel(final Long id);
	
	List<Hotel> getAll();
//	
////	Set<Client> clientsByHotel(Long idHotel);
////	
////	Set<Employe> employesByHotel(Long idHotel);
////	
//	Set<Produit> produitsByHotel(Long idHotel);
//	
//	Set<Personne> personnesByHotel(Long idHotel);
	
}
