/*===================================
*CLASS Employe.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class  Employe extends Personne {
	
	//==========================
	//Attributs
	//==========================
	
	protected Date dateEmbauuche;
	protected String role;
	protected Double salaire;

	
	//==========================
	//Constructeurs
	//==========================

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employe(String nom, String prenom, Date dateDeNaissance,
			Adresse adressePersonne, Date dateEmbauuche, String role,
			Double salaire) {
		super(nom, prenom, dateDeNaissance, adressePersonne);
		this.dateEmbauuche = dateEmbauuche;
		this.role = role;
		this.salaire = salaire;
	}

	
	//==========================
	//Getters et setters
	//==========================

	public Date getDateEmbauuche() {
		return dateEmbauuche;
	}


	public void setDateEmbauuche(Date dateEmbauuche) {
		this.dateEmbauuche = dateEmbauuche;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Double getSalaire() {
		return salaire;
	}


	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	
	//==========================
	//To string
	//==========================

	@Override
	public String toString() {
		return "Employe [dateEmbauuche=" + dateEmbauuche + ", role=" + role
				+ ", salaire=" + salaire + ", getIdPersonne()="
				+ getIdPersonne() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getDateDeNaissance()="
				+ getDateDeNaissance() + ", getAdressePersonne()="
				+ getAdressePersonne() + "]";
	}

	
	
	

}
