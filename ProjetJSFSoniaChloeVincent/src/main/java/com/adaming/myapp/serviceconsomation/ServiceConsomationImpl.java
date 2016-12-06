package com.adaming.myapp.serviceconsomation;

import com.adaming.myapp.daoconsomation.IDaoConsomation;

public class ServiceConsomationImpl implements IServiceConsomation {
	
	private IDaoConsomation dao;

	public void setDao(IDaoConsomation dao) {
		this.dao = dao;
	}
	
	

}
