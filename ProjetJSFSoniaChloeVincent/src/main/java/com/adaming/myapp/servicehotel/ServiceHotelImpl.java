package com.adaming.myapp.servicehotel;

import com.adaming.myapp.daohotel.IDaoHotel;

public class ServiceHotelImpl implements IServiceHotel{

	
	private IDaoHotel dao;


	public void setDao(IDaoHotel dao) {
		this.dao = dao;
	}
	
}
