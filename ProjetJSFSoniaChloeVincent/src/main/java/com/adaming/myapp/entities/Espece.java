/*===================================
*CLASS: Espece
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;

/*@Entity
@DiscriminatorValue("Esp")*/
public class Espece extends Payement{

	public Espece() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Espece(long idPayement, double coutTotal, Date date) {
		super(idPayement, coutTotal, date);
		// TODO Auto-generated constructor stub
	}

}
