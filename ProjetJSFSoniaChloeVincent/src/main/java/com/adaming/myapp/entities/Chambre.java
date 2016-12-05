/*===================================
*CLASS: Chambre
*VERSION: v1
*NAME: chloe
*DATE: 05-12-2016
*====================================*/


package com.adaming.myapp.entities;

/*@Entity
@DiscriminatorValue("Chambre")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)*/
public class Chambre {
	
//==========================
//	ATTRIBUTS
//==========================
	private long idChambre;
	private long numChambre;
	private String description;
	
//==========================
//	CONSTRUCTEURS
//=========================
	
	public Chambre(long idChambre, long numChambre, String description) {
		super();
		this.idChambre = idChambre;
		this.numChambre = numChambre;
		this.description = description;
	}
	
	public Chambre() {
		super();
	}

//=========================
//	GETTER SETTER
//=========================
	
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	public long getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(long numChambre) {
		this.numChambre = numChambre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

//========================
//		METHODES
//========================
	
	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", numChambre=" + numChambre
				+ ", description=" + description + "]";
	}
	
}
