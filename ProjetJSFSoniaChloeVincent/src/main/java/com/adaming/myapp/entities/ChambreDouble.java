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
	
	private Double prixDouble = 100.0;

	public Double getPrixDouble() {
		return prixDouble;
	}

	public void setPrixDouble(Double prixDouble) {
		this.prixDouble = prixDouble;
	}

	public ChambreDouble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChambreDouble(long numChambre, String description
		) {
		super(numChambre, description);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double cout() {
		// TODO Auto-generated method stub
		return prixDouble;
	}





	
}
