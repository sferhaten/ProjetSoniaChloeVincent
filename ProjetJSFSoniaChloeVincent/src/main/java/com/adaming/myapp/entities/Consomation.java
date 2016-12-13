/*===================================
*CLASS Stagiaire.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consomation {
	
	//==========================
	//Attributs
	//==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idConsommation;
	private Integer quantiteConsomation;
	
	
	//produit
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

	public Consomation(Integer quantiteConsomation) {
		super();
		this.quantiteConsomation = quantiteConsomation;
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


	
	public Integer getQuantiteConsomation() {
		return quantiteConsomation;
	}

	public void setQuantiteConsomation(Integer quantiteConsomation) {
		this.quantiteConsomation = quantiteConsomation;
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
		return "Consomation [idConsommation=" + idConsommation
				+ ", quantiteConsomation=" + quantiteConsomation + "]";
	}

	
public Double coutclient(){
		
		Produit p = getProduit();
		
		Double cout = quantiteConsomation *(p.getCoutVente());
		
		return cout;
	}
	
	


public Double benefice(){
		
		Produit p = getProduit();
		
		Double cout = quantiteConsomation*(p.getCoutVente() - p.getCoutAchat());
		
		return cout;
	}
	
	


}
