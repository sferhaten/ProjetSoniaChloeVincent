/*===================================
*CLASS: Chambre
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/


package com.adaming.myapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
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
@DiscriminatorColumn(name ="Type", discriminatorType=DiscriminatorType.STRING)
public abstract class Chambre {
	
//==========================
//	ATTRIBUTS
//==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idChambre;
	private long numChambre;
	private String description;
	
	
	@OneToMany (mappedBy = "chambre", fetch=FetchType.EAGER)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	
	
	
//==========================
//	CONSTRUCTEURS
//=========================
	

	public Chambre() {
		super();
	}



public Chambre(long numChambre, String description) {
	super();
	this.numChambre = numChambre;
	this.description = description;
}



//=========================
//	GETTER SETTER
//=========================
	
	public long getIdChambre() {
		return idChambre;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	public long getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(long numChambre) {
		this.numChambre = numChambre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


//========================
//		METHODES
//========================


	

	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", numChambre=" + numChambre
				+ ", description=" + description + "]";
	}
	
	
	
	public Boolean DispoChambre(Date dateDemandee){
		
		boolean dispo = true;
		
		for (Reservation r : reservations) {
			if (dateDemandee.after(r.getDateArrive()) && (dateDemandee.before(r.getDateSortie()))) {
				dispo = false;
			}
		}
		
		return dispo;
	}
	
	public abstract Double cout();
}
