/*===================================
*CLASS: CarteBancaire
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CB")
public class CarteBancaire extends Payement{

	
	private int numCarte;
	private String typeCarte;
	
	//=========================
	//  Getter setter
	//==========================
	public int getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}
	public String getTypeCarte() {
		return typeCarte;
	}
	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	
	
	//==========================
	//	constructeur
	//=========================


	public CarteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarteBancaire(double coutTotal, Date date, int numCarte,
			String typeCarte) {
		super(coutTotal, date);
		this.numCarte = numCarte;
		this.typeCarte = typeCarte;
	}


}
