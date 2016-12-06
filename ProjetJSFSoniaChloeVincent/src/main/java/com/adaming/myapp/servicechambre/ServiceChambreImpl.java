package com.adaming.myapp.servicechambre;

import com.adaming.myapp.daochambre.IDaoChambre;

public class ServiceChambreImpl implements IServiceChambre {
	
	private IDaoChambre dao;

	public void setDao(IDaoChambre dao) {
		this.dao = dao;
	}
	
	

}
