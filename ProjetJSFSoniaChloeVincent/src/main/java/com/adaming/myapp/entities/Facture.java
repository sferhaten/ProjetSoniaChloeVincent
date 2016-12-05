/*===================================
*CLASS: Facture
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/

package com.adaming.myapp.entities;

public class Facture {
	
//==========================
//	ATTRIBUTS
//==========================	
	private long idFacture;
	private double coutResa;
	private double coutConso;
	
	
	/*private Client client;
	private Employe Employe;*/
	
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



//========================
//		METHODES
//========================

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", coutResa=" + coutResa
				+ ", coutConso=" + coutConso + "]";
	}

}
