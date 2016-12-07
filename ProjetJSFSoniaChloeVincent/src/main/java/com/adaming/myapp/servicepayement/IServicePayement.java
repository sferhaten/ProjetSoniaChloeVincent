package com.adaming.myapp.servicepayement;

import java.util.List;

import com.adaming.myapp.entities.Payement;

public interface IServicePayement {

	Payement addPayement(final Payement p, Long idFacture);
	
	Payement updatePayement(final Payement p);
	
	Payement getOnePayement(final Long  idPayement);
	
	List<Payement> getAllPayement ();
}
