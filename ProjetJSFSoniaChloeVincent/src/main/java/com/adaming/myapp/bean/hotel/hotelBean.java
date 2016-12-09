package com.adaming.myapp.bean.hotel;

import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.adaming.myapp.bean.client.ClientBean;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicehotel.IServiceHotel;

public class hotelBean {

	private Logger LOGGER = Logger.getLogger(hotelBean.class);
	
	@Inject
	private IServiceHotel serviceHotel;
	
	
	//=================7
	//
	//
	
	
	private List<Hotel> hotels;
	
	
	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	public List<Hotel> getAll(){
		 hotels = serviceHotel.getAll();
		 return hotels;
	}
	
}
