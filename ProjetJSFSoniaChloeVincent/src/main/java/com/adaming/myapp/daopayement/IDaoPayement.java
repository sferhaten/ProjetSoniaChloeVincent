package com.adaming.myapp.daopayement;

import java.util.List;

import com.adaming.myapp.entities.Payement;


public interface IDaoPayement {
	
	Payement addPayement(final Payement p);
	
	Payement updatePayement(final Payement p);
	
	Payement getOnePayement(final Long  idPayement);
	
	List<Payement> getAllPayement ();

}
