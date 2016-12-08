/*===================================
*CLASS: Payment
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/
package com.adaming.myapp.entities;



import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Payement {

//==========================
//	ATTRIBUTS
//==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idPayement;
	private double coutTotal;
	@DateTimeFormat(iso=ISO.DATE)
	private Date date;
	
	@OneToOne (mappedBy ="payement")
	private Facture facture;
	
//==========================
//	CONSTRUCTEURS
//=========================
	public Payement() {
		super();
	}
		public Payement(double coutTotal, Date date) {
		super();
		this.coutTotal = coutTotal;
		this.date = date;
		
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
		public Facture getFacture() {
			return facture;
		}
		public void setFacture(Facture facture) {
			this.facture = facture;
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
