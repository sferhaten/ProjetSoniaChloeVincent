/*===================================
*CLASS Stagiaire.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Produit {
	
	//==========================
	//Attributs
	//==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idProduit;
	private String nom;
	private Integer quantite;
	private Double coutAchat;
	private Double coutVente;
	
	@OneToMany(mappedBy = "produit", fetch=FetchType.EAGER)
	private Set<Consomation> consomations =new HashSet<Consomation>();
	
	//==========================
	//Constructeurs
	//==========================
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nom, Integer quantite, Double coutAchat,
			Double coutVente) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.coutAchat = coutAchat;
		this.coutVente = coutVente;
	}
	
	
	//==========================
	//Getters et setters
	//==========================
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Double getCoutAchat() {
		return coutAchat;
	}
	public void setCoutAchat(Double coutAchat) {
		this.coutAchat = coutAchat;
	}
	public Double getCoutVente() {
		return coutVente;
	}
	public void setCoutVente(Double coutVente) {
		this.coutVente = coutVente;
	}
	
	public Set<Consomation> getConsomations() {
		return consomations;
	}
	public void setConsomations(Set<Consomation> consomations) {
		this.consomations = consomations;
	}
	
	
	//==========================
	//To string
	//==========================
	

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom
				+ ", quantite=" + quantite + ", coutAchat=" + coutAchat
				+ ", coutVente=" + coutVente + "]";
	}
	
	

}
