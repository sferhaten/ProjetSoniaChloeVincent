package com.adaming.myapp.daohotel;

import java.util.List;

import com.adaming.myapp.entities.Hotel;


public interface IDaoHotel {
	
	
	Hotel addHotel(final Hotel h);
	
	Hotel getHotel(final Long id);
	
	List<Hotel> getAll();

	
}
