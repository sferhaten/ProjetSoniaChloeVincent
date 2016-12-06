/*===================================
*CLASS: Cheque
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cheque")
public class Cheque extends Payement{

	public Cheque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cheque(long idPayement, double coutTotal, Date date) {
		super(idPayement, coutTotal, date);
		// TODO Auto-generated constructor stub
	}
	
	

}
