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

import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicehotel.IServiceHotel;



@Component("hotelBean")
@ViewScoped
public class hotelBean {

	private Logger LOGGER = Logger.getLogger(hotelBean.class);
	
	@Inject
	private IServiceHotel serviceHotel;
	
	
	private Hotel hotel;
	private Adresse adresseHotel;
	private Long idHotel;
	private String pays;
	private String voie;
	private String codePostal;
	private String ville;
	private String numero;
	private String nomHotel;
	private String telephone;
	private Integer qualite;
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private Set<Chambre> chambres = new HashSet<Chambre>();
	private Hotel selectedHotel;
	
	//===========================
	//	Getter and Setter
	//===========================

	public Set<Chambre> getChambres() {
		return chambres;
	}


	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	


	public Logger getLOGGER() {
		return LOGGER;
	}


	public void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
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

	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Adresse getAdresseHotel() {
		return adresseHotel;
	}


	public void setAdresseHotel(Adresse adresseHotel) {
		this.adresseHotel = adresseHotel;
	}


	public String getNomHotel() {
		return nomHotel;
	}


	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Integer getQualite() {
		return qualite;
	}


	public void setQualite(Integer qualite) {
		this.qualite = qualite;
	}
	
	
//=======================
//  Les methodes 
//=======================
@PostConstruct
public void intFields(){
	nomHotel = "";
	telephone = "";
	qualite = 0;
	pays = "";
	ville = "";
	codePostal = "";
	voie = "";
	numero = "";
}
 @PostConstruct    
	  public void init() {        
		  getAll();    
		  }
 public void getOne(Long idHotel){
	 hotel = serviceHotel.getHotel(idHotel);
 }


	public List<Hotel> getAll(){
		 hotels = serviceHotel.getAll();
		 return hotels;
	}


public void addHotel(){
	
	Adresse adresseHotel = new Adresse(numero, voie, codePostal, ville, pays);
	Hotel hotel =new Hotel(nomHotel, adresseHotel, telephone, qualite);
	serviceHotel.addHotel(hotel);
	intFields();
	getAll();

}

public String show(Long idHotel) {  
    return "HotelDetails?idHotel=" + idHotel;  
} 







	
}
