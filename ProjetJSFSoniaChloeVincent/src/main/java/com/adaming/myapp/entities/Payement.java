/*===================================
*CLASS: Payment
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;

import java.sql.Date;
/*@Entity
@DiscriminatorValue("Payement")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)*/
public class Payement {

//==========================
//	ATTRIBUTS
//==========================
	private long idPayement;
	private double coutTotal;
	private Date date;
	
	
//==========================
//	CONSTRUCTEURS
//=========================

	public Payement(long idPayement, double coutTotal, Date date) {
		super();
		this.idPayement = idPayement;
		this.coutTotal = coutTotal;
		this.date = date;
	}
	public Payement() {
		super();
	}
//=========================
//	GETTER SETTER
//=========================
	public long getIdPayement() {
		return idPayement;
	}
	public void setIdPayement(long idPayement) {
		this.idPayement = idPayement;
	}
	public double getCoutTotal() {
		return coutTotal;
	}
	public void setCoutTotal(double coutTotal) {
		this.coutTotal = coutTotal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


//========================
//		METHODES
//========================
	
	@Override
	public String toString() {
		return "Payement [idPayement=" + idPayement + ", coutTotal="
				+ coutTotal + ", date=" + date + "]";
	}
	
}
