/*===================================
*CLASS: ChambreDouble
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/

package com.adaming.myapp.entities;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Double")

public class ChambreDouble extends Chambre{
 
	//==============
	//
	//
	
	private double prixDouble;

	public double getPrixDouble() {
		return prixDouble;
	}

	public void setPrixDouble(double prixDouble) {
		this.prixDouble = prixDouble;
	}

	public ChambreDouble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChambreDouble(long idChambre, long numChambre, String description,
			Boolean chambrelibre, double prixDouble) {
		super(idChambre, numChambre, description);
		this.prixDouble = prixDouble;
		// TODO Auto-generated constructor stub
	}





	
}
