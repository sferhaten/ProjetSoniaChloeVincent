/*===================================
*CLASS Hotel.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/


package com.adaming.myapp.entities;

import java.util.Set;


public class Hotel {
	
	//==========================
	//Attributs
	//==========================
	
	
	private Long idHotel;
	private String nomHotel;
	private Adresse adresseHotel;
	private String telephone;
	private Integer qualite;
	
	
	//==========================
	//Constructeurs
	//==========================

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Hotel(String nomHotel, Adresse adresseHotel, String telephone,
			Integer qualite) {
		super();
		this.nomHotel = nomHotel;
		this.adresseHotel = adresseHotel;
		this.telephone = telephone;
		this.qualite = qualite;
	}

	//==========================
	//Getters et setters
	//==========================
	

	public Long getIdHotel() {
		return idHotel;
	}



	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}



	public String getNomHotel() {
		return nomHotel;
	}



	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}



	public Adresse getAdresseHotel() {
		return adresseHotel;
	}



	public void setAdresseHotel(Adresse adresseHotel) {
		this.adresseHotel = adresseHotel;
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
	
	//==========================
	//To string
	//==========================
	
	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nomHotel=" + nomHotel
				+ ", adresseHotel=" + adresseHotel + ", telephone=" + telephone
				+ ", qualite=" + qualite + "]";
	}



	

}
