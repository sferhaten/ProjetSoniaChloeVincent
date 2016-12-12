package com.adaming.myapp.bean.consomation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.produit.addProduitBean;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.serviceconsomation.IServiceConsomation;

@Component("consomationBean")
@ViewScoped
public class addConsomationBean {

	private Logger LOGGER = Logger.getLogger(addConsomationBean.class);
	@Inject
	private IServiceConsomation serviceConsomation;
	@Inject
	private addProduitBean produitBean;
	
	//===========================
	//	Attribus
	//===========================
	private Long idClient;
	private Consomation consomation;
	private Produit produit;
	private Long idProduit;
	private Long idConsommation; 
	private Integer quantite;
	private List<Produit> produits = new ArrayList<Produit>();
	private List<Consomation> consomations = new ArrayList<Consomation>();
	

	
	
	//===========================
	//	Getter and Setter
	//===========================
	
	public Integer getQuantite() {
		return quantite;
	}
	public Consomation getConsomation() {
		return consomation;
	}
	public void setConsomation(Consomation consomation) {
		this.consomation = consomation;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Long getIdConsommation() {
		return idConsommation;
	}
	public void setIdConsommation(Long idConsommation) {
		this.idConsommation = idConsommation;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public List<Consomation> getConsomations() {
		return consomations;
	}
	public void setConsomations(List<Consomation> consomations) {
		this.consomations = consomations;
	}
	
	//===========================
	//	Les methodes
	//===========================
	@PostConstruct
	public void initFields(){
		quantite = 0;
	}
	
	public void addConsomation(){
		Consomation consomation = new Consomation(quantite);
		serviceConsomation.addConsommation(consomation, idClient, idProduit);
		initFields();
		getAllConsomations();
	}
	
	public void getOneConsomation(Long idConsomation){
		consomation = serviceConsomation.getConsommation(idConsommation);
	}
	
	public void updateConso(){
		serviceConsomation.updateConsommation(consomation);
		getAllConsomations();
	}
	public void getAllConsomations(){
		consomations = serviceConsomation.consommations();
	}
}
