/*===================================
*CLASS Adresse.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/

package com.adaming.myapp.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	//==========================
	//Attributs
	//==========================
	
	
	private String numero;
	private String voie;
	private String codePostal;
	private String ville;
	private String pays;
	
	//==========================
	//Constructeurs
	//==========================
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(String numero, String voie, String codePostal, String ville,
			String pays) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	
	
	//==========================
	//Getters et setters
	//==========================
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	//==========================
	//To string
	//==========================
	
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", codePostal="
				+ codePostal + ", ville=" + ville + ", pays=" + pays + "]";
	}

}
