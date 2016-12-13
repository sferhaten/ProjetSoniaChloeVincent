package com.adaming.myapp.bean.chambre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreDouble;
import com.adaming.myapp.entities.ChambreSimple;
import com.adaming.myapp.entities.ChambreSuite;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicechambre.IServiceChambre;

@Component("chambreBean")
@ViewScoped
public class ChambreBean {

	private Logger LOGGER = Logger.getLogger(ChambreBean.class);
	
	@Inject
	private IServiceChambre serviceChambre;
	
	private Chambre chambre;
	
	private List<Chambre> listeChambres;
	
	private Long idChambre;
	private Long numChambre;
	private String description;
	
	private Hotel hotel;
	private Long idHotel;

	private List<Chambre> chambres = new ArrayList<Chambre>();
	
	
	public ChambreBean() {
		super();
		LOGGER.info("------ ChambreBean created ------");
	}
	
	public void addChambreSimple(){
		Chambre ChambreSimple = new ChambreSimple(numChambre, description);
		serviceChambre.addChambre(ChambreSimple, idHotel);
	}
	
	public void addChambreDouble(){
		Chambre ChambreDouble = new ChambreDouble(numChambre, description);
		serviceChambre.addChambre(ChambreDouble, idHotel);
	}
	
	public void addChambreSuite(){
		Chambre ChambreSuite = new ChambreSuite(numChambre, description);
		serviceChambre.addChambre(ChambreSuite, idHotel);
	}
	
	
	@PostConstruct
	public void init(){
		getAll();
		}
	
	public List<Chambre> getAll() {
		chambres = serviceChambre.getAllChambre();
		return chambres;
	}
	
	public void getOne(Long idHotel) {
		chambre = serviceChambre.getOneChambre(idHotel);
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
