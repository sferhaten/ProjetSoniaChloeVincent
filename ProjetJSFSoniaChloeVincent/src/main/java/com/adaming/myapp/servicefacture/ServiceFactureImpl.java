package com.adaming.myapp.servicefacture;

import com.adaming.myapp.daofacture.IDaoFacture;

public class ServiceFactureImpl implements IServicefacture {
	
	private IDaoFacture dao;

	public void setDao(IDaoFacture dao) {
		this.dao = dao;
	}
	
	

}
