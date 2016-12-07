package com.adaming.myapp.daoproduit;

import java.util.List;

import com.adaming.myapp.entities.Produit;

public interface IDaoProduit {

	
	Produit addProduit(final Produit p, Long idHotel);
	
	Produit updateProduit(final Produit p);
	
	Produit getOneProduit(final Long idProduit);
		
	List<Produit> getAllProduit();
	
	List<Produit> getStock();
}
