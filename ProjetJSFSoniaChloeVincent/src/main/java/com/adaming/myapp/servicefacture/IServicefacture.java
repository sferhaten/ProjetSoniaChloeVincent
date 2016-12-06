package com.adaming.myapp.servicefacture;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;

public interface IServicefacture {
	
	Facture addFacture(final Facture f);
	
	Facture updateFacture(final Facture f);
	
	Facture getOneFacture(final Long  idFacture);
	
	List<Facture> getAllFacture ();
	
	Set<Consomation> getConsoByFacture ( Long idFacture);

}
