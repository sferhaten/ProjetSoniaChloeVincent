package com.adaming.myapp.serviceconsomation;

import java.util.List;

import com.adaming.myapp.daoconsomation.IDaoConsomation;
import com.adaming.myapp.entities.Consomation;

public class ServiceConsomationImpl implements IServiceConsomation {
	
	private IDaoConsomation dao;

	public void setDao(IDaoConsomation dao) {
		this.dao = dao;
	}

	@Override
	public Consomation addConsommation(Consomation c, Long idClient,
			Long idProduit) {
		return dao.addConsommation(c, idClient, idProduit);
	}

	@Override
	public Consomation updateConsommation(Consomation c) {
		return dao.updateConsommation(c);
	}

	@Override
	public Consomation getConsommation(Long idConsommation) {
		return dao.getConsommation(idConsommation);
	}

	@Override
	public List<Consomation> consommations() {
		return dao.consommations();
	}
	
	

}
