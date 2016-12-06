package com.adaming.myapp.servicechambre;

import java.util.List;

import com.adaming.myapp.entities.Chambre;

public interface IServiceChambre {
	
	Chambre addChambre(final Chambre c);
	
	Chambre updateChambre(final Chambre c);
	
	Chambre getOneChambre(final Long  idChambre);
	
	List<Chambre> getAllChambre ();

}
