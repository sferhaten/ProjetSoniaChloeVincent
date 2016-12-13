/*===================================
*CLASS Hotel.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/


package com.adaming.myapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	//==========================
	//Attributs
	//==========================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idHotel;
	private String nomHotel;
	
	@Embedded
	private Adresse adresseHotel;
	private String telephone;
	private Integer qualite;
	
	//==========================
	//Associations
	//==========================
	
	//Produit
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name ="produit_to_hotel")
	private Set<Produit> produits = new HashSet<Produit>();
	
	
	//Chambre
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name ="chambre_to_hotel")
	private Set<Chambre> chambres = new HashSet<Chambre>();
	
	//Personne
	@OneToMany(mappedBy = "hotel" ,fetch=FetchType.EAGER)
	private Set<Personne> personnes = new HashSet<Personne>();
	
	
	//reservation
	@OneToMany(mappedBy="hotel", fetch=FetchType.EAGER)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	
	//facture
	@OneToMany(mappedBy="hotel", fetch=FetchType.EAGER)
	private Set<Facture> factures = new HashSet<Facture>();
	
	
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
	
	public Set<Produit> getProduits() {
		return produits;
	}



	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}



	public Set<Chambre> getChambres() {
		return chambres;
	}



	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}



	public Set<Personne> getPersonnes() {
		return personnes;
	}



	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}



	public Set<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}



	public Set<Facture> getFactures() {
		return factures;
	}



	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
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
