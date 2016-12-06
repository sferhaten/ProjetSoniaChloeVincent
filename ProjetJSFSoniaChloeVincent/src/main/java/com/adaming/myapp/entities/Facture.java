/*===================================
*CLASS: Facture
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/

package com.adaming.myapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Facture {
	
//==========================
//	ATTRIBUTS
//==========================	
	private long idFacture;
	private double coutResa;
	private double coutConso;
	
	@OneToMany (mappedBy ="facture")
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="conso_to_facture")
	private Set<Consomation> consomation = new HashSet<Consomation>();
	
	@OneToOne
	@JoinColumn (name ="payment")
	private Payement payment;
	
	@ManyToOne
	@JoinColumn (name= "hotel")
	private Hotel hotel;
	
//==========================
//	CONSTRUCTEURS
//=========================	
	public Facture(long idFacture, double coutResa, double coutConso) {
		super();
		this.idFacture = idFacture;
		this.coutResa = coutResa;
		this.coutConso = coutConso;
	}

	
//=========================
//	GETTER SETTER
//=========================
	public Facture() {
		super();
	}
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public double getCoutResa() {
		return coutResa;
	}
	public void setCoutResa(double coutResa) {
		this.coutResa = coutResa;
	}
	public double getCoutConso() {
		return coutConso;
	}
	public void setCoutConso(double coutConso) {
		this.coutConso = coutConso;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Set<Consomation> getConsomation() {
		return consomation;
	}


	public void setConsomation(Set<Consomation> consomation) {
		this.consomation = consomation;
	}


	public Payement getPayment() {
		return payment;
	}


	public void setPayment(Payement payment) {
		this.payment = payment;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


//========================
//		METHODES
//========================




	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", coutResa=" + coutResa
				+ ", coutConso=" + coutConso + "]";
	}

}
