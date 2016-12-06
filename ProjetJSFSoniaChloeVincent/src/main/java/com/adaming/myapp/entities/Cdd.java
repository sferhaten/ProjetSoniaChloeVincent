/*===================================
*CLASS Cdd.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CDD")
public class Cdd extends Employe {
	
	//==========================
	//Attributs
	//==========================
	
	private Date dateDeSortie;
	private Double primePrecarite;
	
	//==========================
	//Constructeurs
	//==========================
	
	
	public Cdd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cdd(String nom, String prenom, Date dateDeNaissance,
			Adresse adressePersonne, Date dateEmbauuche, String role,
			Double salaire, Date dateDeSortie, Double primePrecarite) {
		super(nom, prenom, dateDeNaissance, adressePersonne, dateEmbauuche,
				role, salaire);
		this.dateDeSortie = dateDeSortie;
		this.primePrecarite = primePrecarite;
	}
	
	//==========================
	//Getters et setters
	//==========================
	
	public Date getDateDeSortie() {
		return dateDeSortie;
	}
	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}
	public Double getPrimePrecarite() {
		return primePrecarite;
	}
	public void setPrimePrecarite(Double primePrecarite) {
		this.primePrecarite = primePrecarite;
	}
	
	
	//==========================
	//To string
	//==========================
	
	@Override
	public String toString() {
		return "Cdd [dateDeSortie=" + dateDeSortie + ", primePrecarite="
				+ primePrecarite + ", getDateEmbauuche()=" + getDateEmbauuche()
				+ ", getRole()=" + getRole() + ", getSalaire()=" + getSalaire()
				+ ", getIdPersonne()=" + getIdPersonne() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateDeNaissance()=" + getDateDeNaissance()
				+ ", getAdressePersonne()=" + getAdressePersonne() + "]";
	}

	
	

}
