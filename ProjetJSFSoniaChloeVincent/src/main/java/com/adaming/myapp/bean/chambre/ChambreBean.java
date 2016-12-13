package com.adaming.myapp.bean.chambre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreDouble;
import com.adaming.myapp.entities.ChambreSimple;
import com.adaming.myapp.entities.ChambreSuite;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicechambre.IServiceChambre;

@Component("chambreBean")
@ViewScoped
public class ChambreBean {

	private Logger LOGGER = Logger.getLogger(ChambreBean.class);

	@Inject
	private IServiceChambre serviceChambre;

	@Inject
	private hotelBean hotelBean;

	private Chambre chambre;

	private Set<Chambre> chambres = new HashSet<Chambre>();
	private List<Hotel> hotels;
	private Long idChambre;

	private Long numChambre;
	private String description;

	private Hotel hotel;
	private Long idHotel;
	private Long selectedidHotel;

	private String option;
	private boolean simpleVisible = false;
	private boolean doubleVisible = false;
	private boolean suiteVisible = false;

	// ===========================
	// Methodes
	// ===========================
	 
	public String redirect(){
		initFields();
		return "addChambre?faces-redirect=true";
	}
	
	
	@PostConstruct
	public void getAllhotels() {
		hotels = hotelBean.getAll();
	}

	public void getChambreByHotel(){
		chambres = hotelBean.getChambreByHotel(selectedidHotel);
	}
	


	public ChambreBean() {
		super();
		LOGGER.info("------ ChambreBean created ------");
	}
	@PostConstruct
	public void initFields() {
		numChambre = 0L;
		description = "";
		
	}

	public void choisir() {
		simpleVisible = false;
		doubleVisible = false;
		suiteVisible = false;
		if (option.equals("ChambreSimple")) {
			initFields();
			simpleVisible = true;
		} else if (option.equals("ChambreDouble")) {
			initFields();
			doubleVisible = true;
		} else if (option.equals("Suite")) {
			initFields();
			suiteVisible = true;
		}
	}

	public void add() {
		if (option.equals("ChambreSimple")) {
			Chambre chambreSimple = new ChambreSimple(numChambre, description);
			serviceChambre.addChambre(chambreSimple, selectedidHotel);
			initFields();
		} else if (option.equals("ChambreDouble")) {
			Chambre chambreDouble = new ChambreDouble(numChambre, description);
			serviceChambre.addChambre(chambreDouble, selectedidHotel);
			initFields();
		} else if (option.equals("Suite")) {
			Chambre suite = new ChambreSuite(numChambre, description);
			serviceChambre.addChambre(suite, selectedidHotel);
			initFields();
		}
	}

	// ===========================
	// Getter and setter
	// ===========================
	
	public IServiceChambre getServiceChambre() {
		return serviceChambre;
	}

	public void setServiceChambre(IServiceChambre serviceChambre) {
		this.serviceChambre = serviceChambre;
	}

	public hotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(hotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	
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


	public Long getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}

	public Long getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(Long numChambre) {
		this.numChambre = numChambre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getSelectedidHotel() {
		return selectedidHotel;
	}

	public void setSelectedidHotel(Long selectedidHotel) {
		this.selectedidHotel = selectedidHotel;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isSimpleVisible() {
		return simpleVisible;
	}

	public void setSimpleVisible(boolean simpleVisible) {
		this.simpleVisible = simpleVisible;
	}

	public boolean isDoubleVisible() {
		return doubleVisible;
	}

	public void setDoubleVisible(boolean doubleVisible) {
		this.doubleVisible = doubleVisible;
	}

	public boolean isSuiteVisible() {
		return suiteVisible;
	}

	public void setSuiteVisible(boolean suiteVisible) {
		this.suiteVisible = suiteVisible;
	}

	// ===========================
	// Getter and setter
	// ===========================



}
