package com.adaming.myapp.bean.consomation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.hotel.gestionHotelBean;
import com.adaming.myapp.bean.produit.addProduitBean;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.serviceconsomation.IServiceConsomation;
import com.adaming.myapp.servicehotel.IServiceHotel;

@Component("addConsomationBean")
@ViewScoped
public class addConsomationBean {

	private Logger LOGGER = Logger.getLogger(addConsomationBean.class);
	@Inject
	private IServiceConsomation serviceConsomation;
	@Inject
	private addProduitBean addproduitBean;
	@Inject
	private IServiceHotel serviceHotel;
	
	//===========================
	//	Attribus
	//===========================
	private Long idClient = 1L;
	private Client client;
	private Hotel hotel;
	private Consomation consomation;
	private Produit produit;
	private Long idProduit;
	private Long idHotel = 10L;
	private String nom;
	private Integer quantite;
	private Double coutAchat;
	private Double coutVente;
	private Long idConsommation; 
	private Integer quantiteConsomation;
	private List<Produit> produits = new ArrayList<Produit>();
	private List<Consomation> consomations = new ArrayList<Consomation>();
	private Set<Produit> produitsDispo = new HashSet<Produit>();
	private Produit selectedidProduit;
	private Double coutClient;
	
	
	//===========================
	//	Getter and Setter
	//===========================

	
	
	public Logger getLOGGER() {
		return LOGGER;
	}

	public Double getCoutClient() {
		return coutClient;
	}

	public void setCoutClient(Double coutClient) {
		this.coutClient = coutClient;
	}

	public Produit getSelectedidProduit() {
		return selectedidProduit;
	}

	public void setSelectedidProduit(Produit selectedidProduit) {
		this.selectedidProduit = selectedidProduit;
	}

	public void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	public addProduitBean getAddproduitBean() {
		return addproduitBean;
	}

	public void setAddproduitBean(addProduitBean addproduitBean) {
		this.addproduitBean = addproduitBean;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getCoutAchat() {
		return coutAchat;
	}

	public void setCoutAchat(Double coutAchat) {
		this.coutAchat = coutAchat;
	}

	public Double getCoutVente() {
		return coutVente;
	}

	public void setCoutVente(Double coutVente) {
		this.coutVente = coutVente;
	}

	public Long getIdConsommation() {
		return idConsommation;
	}

	public void setIdConsommation(Long idConsommation) {
		this.idConsommation = idConsommation;
	}

	public Integer getQuantiteConsomation() {
		return quantiteConsomation;
	}

	public void setQuantiteConsomation(Integer quantiteConsomation) {
		this.quantiteConsomation = quantiteConsomation;
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

	public Set<Produit> getProduitsDispo() {
		return produitsDispo;
	}

	public void setProduitsDispo(Set<Produit> produitsDispo) {
		this.produitsDispo = produitsDispo;
	}
	
	
	//===========================
	//	Les methodes
	//===========================
	@PostConstruct
	public void initFields(){
		quantiteConsomation = 0;

		
	}
	
	public String redirect(){
		initFields();
		return "addConsomation?faces-redirect=true";
	}

	public void addConsomation(){
		Consomation consomation = new Consomation(quantiteConsomation);
		
		serviceConsomation.addConsommation(consomation, idClient, selectedidProduit.getIdProduit());
		coutClient = consomation.coutclient();
		System.out.println("le cout de la consomation" + coutClient);
		
		getAllConsomations();
		initFields();
		
	}
	
	public void getOneConsomation(Long idConsomation){
		consomation = serviceConsomation.getConsommation(idConsommation);
	}
	
	public void updateConso(){
		serviceConsomation.updateConsommation(consomation);
		getAllConsomations();
	}
	@PostConstruct
	public void getAllConsomations(){
		consomations = serviceConsomation.consommations();
		System.out.println("miste des consomations est " + consomations);
	}
	
	public void getAllProduits(){
		produits = addproduitBean.getProduits();
	}

	@PostConstruct
	public void getAllProduitsDispo (){
		produitsDispo = serviceHotel.produitsDisposByHotel(idHotel);
	}
	
	
}
