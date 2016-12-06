package com.adaming.myapp.daofacture;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;

public interface IDaoFacture {

	Facture addFacture(final Facture f);
	
	Facture updateFacture(final Facture f);
	
	Facture getOneFacture(final Long  idFacture);
	
	List<Facture> getAllFacture ();
	
	Set<Consomation> getConsoByFacture ( Long idFacture);
}
