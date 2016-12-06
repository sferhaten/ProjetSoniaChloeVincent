/*===================================
*CLASS Personne.java
*VERSION 1
*NAME Vincent
*DATE 05/12/2016
*==================================*/

package com.adaming.myapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Typepersonne", discriminatorType=DiscriminatorType.STRING)
public abstract class Personne {
	
	//==========================
	//Attributs
	//==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	protected Long idPersonne;
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	
	@Embedded
	protected Adresse adressePersonne;
	
	
	//
	@OneToMany(mappedBy="personne", fetch=FetchType.EAGER)
	private Set<Consomation>consomations= new HashSet<Consomation>();
	
	
	//
	@OneToMany(mappedBy = "personne", fetch=FetchType.EAGER)
	private Set<Reservation> reservations= new HashSet<Reservation>();
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
	
	
	
	
	
	
	public Set<Consomation> getConsomations() {
		return consomations;
	}
	public void setConsomations(Set<Consomation> consomations) {
		this.consomations = consomations;
	}
	
	
	
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
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
