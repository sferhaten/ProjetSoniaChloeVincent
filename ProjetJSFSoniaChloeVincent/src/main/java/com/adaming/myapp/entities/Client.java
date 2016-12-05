/*===================================
*CLASS Client.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import java.util.Date;

public class Client extends Personne {
	
	//==========================
	//Attributs
	//==========================
	
	private Integer nombreReservations;

	
	//==========================
	//Constructeurs
	//==========================
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(String nom, String prenom, Date dateDeNaissance,
			Adresse adressePersonne, Integer nombreReservations) {
		super(nom, prenom, dateDeNaissance, adressePersonne);
		this.nombreReservations = nombreReservations;
	}

	
	
	//==========================
	//Getters et setters
	//==========================

	public Integer getNombreReservations() {
		return nombreReservations;
	}


	public void setNombreReservations(Integer nombreReservations) {
		this.nombreReservations = nombreReservations;
	}

	
	//==========================
	//To string
	//==========================

	@Override
	public String toString() {
		return "Client [nombreReservations=" + nombreReservations
				+ ", getIdPersonne()=" + getIdPersonne() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateDeNaissance()=" + getDateDeNaissance()
				+ ", getAdressePersonne()=" + getAdressePersonne() + "]";
	}


	
	

	
	
	
	

}
