package com.adaming.myapp.bean.hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicehotel.IServiceHotel;



@Component("hotelBean")
@ViewScoped
public class hotelBean {

	private Logger LOGGER = Logger.getLogger(hotelBean.class);
	
	@Inject
	private IServiceHotel serviceHotel;
	
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private Set<Chambre> chambres = new HashSet<Chambre>();
	
	
	public Set<Chambre> getChambres() {
		return chambres;
	}


	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}


	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

@PostConstruct
	public List<Hotel> getAll(){
		 hotels = serviceHotel.getAll();
		 return hotels;
	}

public Set<Chambre> getChambreSimpleDispo(Long idHotel, Date dateDemandee1, Date dateDemandee2){
	chambres = serviceHotel.chambreSimpleDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
	
	return chambres;
}

public Set<Chambre> getChambreDoubleDispo(Long idHotel, Date dateDemandee1, Date dateDemandee2){
	chambres = serviceHotel.chambreDoubleDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
	
	return chambres;
}
public Set<Chambre> getChambreSuiteDispo(Long idHotel, Date dateDemandee1, Date dateDemandee2){
	chambres = serviceHotel.chambreSuiteDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
	
	return chambres;
}

	
}
