/*===================================
*CLASS: CarteBancaire
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CB")
public class CarteBancaire extends Payement{

	
	private int numCarte;
	private int typeCarte;
	
	//=========================
	//  Getter setter
	//==========================
	public int getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}
	public int getTypeCarte() {
		return typeCarte;
	}
	public void setTypeCarte(int typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	
	//==========================
	//	constructeur
	//=========================
	public CarteBancaire(double coutTotal, Date date,
			int numCarte, int typeCarte) {
		super(coutTotal, date);
		this.numCarte = numCarte;
		this.typeCarte = typeCarte;
	}
	public CarteBancaire(double coutTotal, Date date) {
		super(coutTotal, date);
	}
	

}
