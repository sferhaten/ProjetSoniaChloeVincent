/*===================================
*CLASS: Reservation
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idReservation;
	private Date dateArrive;
	private Date dateSortie;
	private double coutResa;
	
	@ManyToOne
	@JoinColumn (name ="personne")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn (name = "hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn (name = "chambre")
	private Chambre chambre;
	
	@ManyToOne
	@JoinColumn (name = "facture")
	private Facture facture;
//==========================
//	CONSTRUCTEURS
//=========================
	public Reservation(Date dateArrive, Date dateSortie,
			double coutResa) {
		super();
		this.dateArrive = dateArrive;
		this.dateSortie = dateSortie;
		this.coutResa = coutResa;
	}

	
//=========================
//	GETTER SETTER
//=========================
	public Reservation() {
		super();
	}
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public double getCoutResa() {
		return coutResa;
	}
	public void setCoutResa(double coutResa) {
		this.coutResa = coutResa;
	}

	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}

//========================
//		METHODES
//========================

	


	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateArrive="
				+ dateArrive + ", dateSortie=" + dateSortie + ", coutResa="
				+ coutResa + "]";
	}
	
}
