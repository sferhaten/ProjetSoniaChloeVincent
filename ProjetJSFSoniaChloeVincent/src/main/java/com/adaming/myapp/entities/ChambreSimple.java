/*===================================
*CLASS: ChambreSimple
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Simple")
public class ChambreSimple extends Chambre {

	private double prixSimple;

	public double getPrixSimple() {
		return prixSimple;
	}

	public void setPrixSimple(double prixSimple) {
		this.prixSimple = prixSimple;
	}

	public ChambreSimple() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChambreSimple(long numChambre, String description,
			double prixSimple) {
		super(numChambre, description);
		this.prixSimple = prixSimple;
	}
	
	
	

}
