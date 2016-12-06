/*===================================
*CLASS Stagiaire.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Consomation {
	
	//==========================
	//Attributs
	//==========================
	
	private Long idConsommation;
	private Integer quantite;
	
	
	@ManyToOne
	@JoinColumn(name = "produit")
	private Produit produit;
	
	
	@ManyToOne
	@JoinColumn(name ="personne")
	private Personne personne;
	
	//==========================
	//Constructeurs
	//==========================
	
	public Consomation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consomation(Integer quantite) {
		super();
		this.quantite = quantite;
	}
	
	//==========================
	//Getters et setters
	//==========================

	public Long getIdConsommation() {
		return idConsommation;
	}

	public void setIdConsommation(Long idConsommation) {
		this.idConsommation = idConsommation;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	//==========================
	//To string
	//==========================

	

	@Override
	public String toString() {
		return "Consomation [idConsommation=" + idConsommation + ", quantite="
				+ quantite + "]";
	}
	
	

}
