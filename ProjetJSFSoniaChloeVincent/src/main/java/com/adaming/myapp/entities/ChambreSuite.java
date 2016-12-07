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

	private double prixSuite;

	public double getPrixSuite() {
		return prixSuite;
	}

	public void setPrixSuite(double prixSuite) {
		this.prixSuite = prixSuite;
	}

	public ChambreSuite(long idChambre, long numChambre, String description,
			Boolean chambrelibre, double prixSuite) {
		super(idChambre, numChambre, description);
		this.prixSuite = prixSuite;
	}
	
	
	
	
}
