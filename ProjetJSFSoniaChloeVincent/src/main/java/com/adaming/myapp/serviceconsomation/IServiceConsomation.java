package com.adaming.myapp.serviceconsomation;

import java.util.List;

import com.adaming.myapp.entities.Consomation;

public interface IServiceConsomation {
	
	Consomation addConsommation(final Consomation c, final Long idClient, final Long idProduit);
	
	Consomation updateConsommation(final Consomation c);
	
	Consomation getConsommation(Long idConsommation);
	
	List<Consomation> consommations();

}
