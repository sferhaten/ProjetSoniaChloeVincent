/*===================================
*CLASS Personne.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/

package com.adaming.myapp.entities;

import java.util.Date;

public class Personne {
	
	//==========================
	//Attributs
	//==========================
	
	protected Long idPersonne;
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	protected Adresse adressePersonne;
	
	
	//==========================
	//Constructeurs
	//==========================
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, String prenom, Date dateDeNaissance,
			Adresse adressePersonne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adressePersonne = adressePersonne;
	}
	
	
	//==========================
	//Getters et setters
	//==========================
	
	
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public Adresse getAdressePersonne() {
		return adressePersonne;
	}
	public void setAdressePersonne(Adresse adressePersonne) {
		this.adressePersonne = adressePersonne;
	}
	
	//==========================
	//To string
	//==========================
	
	
	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom
				+ ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", adressePersonne=" + adressePersonne + "]";
	}
	
	
	
	

}
