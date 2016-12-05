/*===================================
*CLASS: CarteBancaire
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;

/*@Entity
@DiscriminatorValue("CaBanc")*/
public class CarteBancaire extends Payement{

	public CarteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarteBancaire(long idPayement, double coutTotal, Date date) {
		super(idPayement, coutTotal, date);
		// TODO Auto-generated constructor stub
	}

}
