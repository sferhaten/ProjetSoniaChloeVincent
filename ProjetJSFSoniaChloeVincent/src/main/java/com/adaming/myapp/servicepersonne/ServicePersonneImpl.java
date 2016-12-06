package com.adaming.myapp.servicepersonne;

import com.adaming.myapp.daopersonne.IDaoPersonne;

public class ServicePersonneImpl implements IServicePersonne {
	
	
	private IDaoPersonne dao;

	public void setDao(IDaoPersonne dao) {
		this.dao = dao;
	}
	
	

}
