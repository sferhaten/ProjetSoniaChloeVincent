package com.adaming.myapp.daochambre;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Chambre;

public interface IDaoChambre {

	Chambre addChambre(final Chambre c, Long idHotel);
	
	Chambre updateChambre(final Chambre c);
	
	Chambre getOneChambre(final Long  idChambre);
	
	List<Chambre> getAllChambre ();
	
	
}
