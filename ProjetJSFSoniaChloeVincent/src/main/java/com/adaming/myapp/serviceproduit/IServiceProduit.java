package com.adaming.myapp.serviceproduit;

import java.util.List;

import com.adaming.myapp.entities.Produit;

public interface IServiceProduit {

	
	Produit addProduit(final Produit p, Long idHotel);
	
	Produit updateProduit(final Produit p);
	
	Produit getOneProduit(final Long idProduit);
		
	List<Produit> getAllProduit();
}
