/*===================================
*CLASS: Cheque
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cheque")
public class Cheque extends Payement{
	
	
	private int numCheque;
	private String banqueCheque;
	

	//===========================
	//
	//===========================
	
	public int getNumCheque() {
		return numCheque;
	}
	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}
	public String getBanqueCheque() {
		return banqueCheque;
	}
	public void setBanqueCheque(String banqueCheque) {
		this.banqueCheque = banqueCheque;
	}
	
	//============================
	//Constructeur
	//=============================
	public Cheque(double coutTotal, Date date, int numCheque,
			String banqueCheque) {
		super(coutTotal, date);
		this.numCheque = numCheque;
		this.banqueCheque = banqueCheque;
	}
	public Cheque(long idPayement, double coutTotal, Date date) {
		super(coutTotal, date);
	}
	


	

}
