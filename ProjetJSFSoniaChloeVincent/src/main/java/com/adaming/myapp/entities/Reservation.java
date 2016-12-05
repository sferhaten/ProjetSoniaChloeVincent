/*===================================
*CLASS: Reservation
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.util.Date;

public class Reservation {
	
	private long idReservation;
	private Date dateArrive;
	private Date dateSortie;
	private double coutResa;
	
	
	/*Client
	Chambre*/
	
//==========================
//	CONSTRUCTEURS
//=========================
	public Reservation(long idReservation, Date dateArrive, Date dateSortie,
			double coutResa) {
		super();
		this.idReservation = idReservation;
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
