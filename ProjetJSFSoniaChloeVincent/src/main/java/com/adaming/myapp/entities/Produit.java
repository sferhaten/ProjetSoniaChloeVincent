/*===================================
*CLASS Stagiaire.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/
package com.adaming.myapp.entities;

public class Produit {
	
	//==========================
	//Attributs
	//==========================
	
	private Long idProduit;
	private String nom;
	private Integer quantite;
	private Double coutAchat;
	private Double coutVente;
	
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
