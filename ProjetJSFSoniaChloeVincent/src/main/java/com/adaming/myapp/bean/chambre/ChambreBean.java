package com.adaming.myapp.bean.chambre;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.servicechambre.IServiceChambre;

@Component("chambreBean")
@ViewScoped
public class ChambreBean {

	private Logger LOGGER = Logger.getLogger(ChambreBean.class);
	
	@Inject
	private IServiceChambre service;
	
	private Chambre chambre;
	
	private List<Chambre> listeChambres;
	
	private long idChambre;
	private long numChambre;
	private String description;
	
	
	public ChambreBean() {
		super();
		LOGGER.info("------ ChambreBean created ------");
	}
	
	
	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	public List<Chambre> getListeChambres() {
		return listeChambres;
	}


	public void setListeChambres(List<Chambre> listeChambres) {
		this.listeChambres = listeChambres;
	}


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



	
	
	
	
	
	
	
	
	
	
}
