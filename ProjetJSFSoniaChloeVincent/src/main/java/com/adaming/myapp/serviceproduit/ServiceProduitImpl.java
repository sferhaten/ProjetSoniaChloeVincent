package com.adaming.myapp.serviceproduit;

import com.adaming.myapp.daoproduit.IDaoProduit;

public class ServiceProduitImpl implements IServiceProduit {
	
	private IDaoProduit dao;

	public void setDao(IDaoProduit dao) {
		this.dao = dao;
	}
	
	

}
