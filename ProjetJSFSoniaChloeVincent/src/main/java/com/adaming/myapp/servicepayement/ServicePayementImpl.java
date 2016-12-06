package com.adaming.myapp.servicepayement;

import com.adaming.myapp.daopayement.IDaoPayement;

public class ServicePayementImpl implements IServicePayement {
	
	private IDaoPayement dao;

	public void setDao(IDaoPayement dao) {
		this.dao = dao;
	}
	
	

}
