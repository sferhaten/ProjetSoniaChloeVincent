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

	private Double prixSimple = 70.0;

	public Double getPrixSimple() {
		return prixSimple;
	}

	public void setPrixSimple(Double prixSimple) {
		this.prixSimple = prixSimple;
	}

	public ChambreSimple() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChambreSimple(long numChambre, String description) {
		super(numChambre, description);
	
	}

	@Override
	public Double cout() {
		// TODO Auto-generated method stub
		return prixSimple;
	}
	
	
	

}
