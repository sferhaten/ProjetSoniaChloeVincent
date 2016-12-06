/*===================================
*CLASS Stagiaire.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends Employe {
	
	//==========================
	//Attributs
	//==========================
	
	private Date dateDeSortie;
	
	//==========================
	//Constructeurs
	//==========================

	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stagiaire(String nom, String prenom, Date dateDeNaissance,
			Adresse adressePersonne, Date dateEmbauuche, String role,
			Double salaire) {
		super(nom, prenom, dateDeNaissance, adressePersonne, dateEmbauuche, role,
				salaire);
		// TODO Auto-generated constructor stub
	}

	
	//==========================
	//To string
	//==========================
	
	@Override
	public String toString() {
		return "Stagiaire [dateDeSortie=" + dateDeSortie
				+ ", getDateEmbauuche()=" + getDateEmbauuche() + ", getRole()="
				+ getRole() + ", getSalaire()=" + getSalaire()
				+ ", getIdPersonne()=" + getIdPersonne() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateDeNaissance()=" + getDateDeNaissance()
				+ ", getAdressePersonne()=" + getAdressePersonne() + "]";
	}
	
	
	

	
}
