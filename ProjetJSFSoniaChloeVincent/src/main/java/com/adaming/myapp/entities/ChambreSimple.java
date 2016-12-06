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

	public ChambreSimple() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChambreSimple(long idChambre, long numChambre, String description) {
		super(idChambre, numChambre, description);
		// TODO Auto-generated constructor stub
	}
	
	

}
