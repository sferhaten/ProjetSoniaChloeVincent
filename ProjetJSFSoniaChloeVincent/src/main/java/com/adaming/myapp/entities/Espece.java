/*===================================
*CLASS: Espece
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Espece")
public class Espece extends Payement{
	
	private String devise;


	
	//=======================
	//	getter and setter
	//=======================

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}


	//=======================
	//	constructeur
	//=======================

	
	public Espece() {
		super();
	}

	public Espece(double coutTotal, Date date, String devise) {
		super(coutTotal, date);
		this.devise = devise;
	}

	


}
