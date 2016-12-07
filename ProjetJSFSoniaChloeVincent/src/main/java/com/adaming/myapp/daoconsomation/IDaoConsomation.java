package com.adaming.myapp.daoconsomation;

import java.util.List;

import com.adaming.myapp.entities.Consomation;

public interface IDaoConsomation {
	
	Consomation addConsommation(final Consomation c, final Long idClient,
			final Long idProduit);

	Consomation updateConsommation(final Consomation c);

	Consomation getConsommation(Long idConsommation);

	List<Consomation> consommations();

}
