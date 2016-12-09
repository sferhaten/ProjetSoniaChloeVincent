package com.adaming.myapp.bean.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicehotel.IServiceHotel;

public class hotelBean {

	private Logger LOGGER = Logger.getLogger(hotelBean.class);
	
	@Inject
	private IServiceHotel serviceHotel;
	
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	
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
