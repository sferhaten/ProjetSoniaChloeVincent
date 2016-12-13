/*===================================
*CLASS: ChambreSuite
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/

package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Suite")
public class ChambreSuite extends Chambre{

	private Double prixSuite = 500.0;

	public Double getPrixSuite() {
		return prixSuite;
	}

	public void setPrixSuite(Double prixSuite) {
		this.prixSuite = prixSuite;
	}




	public ChambreSuite(long numChambre, String description) {
		super(numChambre, description);
		// TODO Auto-generated constructor stub
	}

	public ChambreSuite() {
		super();
	}

	@Override
	public Double cout() {
		// TODO Auto-generated method stub
		return prixSuite;
	}
	
	
	
	
}
