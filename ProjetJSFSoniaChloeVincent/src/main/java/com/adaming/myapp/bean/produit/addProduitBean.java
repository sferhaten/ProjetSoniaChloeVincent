package com.adaming.myapp.bean.produit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.consomation.addConsomationBean;
import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.serviceproduit.IServiceProduit;

@Component("addProduitBean")
@ViewScoped
public class addProduitBean {
	private Logger LOGGER = Logger.getLogger(addConsomationBean.class);
	@Inject
	private IServiceProduit serviceProduit;
	@Inject
	private hotelBean hotelBean;
	
	
	//===========================
	//	les attribus
	//===========================
		
		private Produit produit;
		private Hotel hotel;
		private String nom;
		private Integer quantite;
		private Double coutAchat;
		private Double coutVente;
		private List<Produit> produits = new ArrayList<Produit>();
		private List<Hotel>hotels = new ArrayList<Hotel>();
		private Long idHotel;
		private Long idProduit;
		private Long selectedidHotel;
		//===========================
		//	Getter and Setter
		//===========================
		
		
		public Produit getProduit() {
			return produit;
		}
		public Logger getLOGGER() {
			return LOGGER;
		}
		public void setLOGGER(Logger lOGGER) {
			LOGGER = lOGGER;
		}
		public hotelBean getHotelBean() {
			return hotelBean;
		}
		public void setHotelBean(hotelBean hotelBean) {
			this.hotelBean = hotelBean;
		}
		public Long getSelectedidHotel() {
			return selectedidHotel;
		}
		public void setSelectedidHotel(Long selectedidHotel) {
			this.selectedidHotel = selectedidHotel;
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
		public void setProduit(Produit produit) {
			this.produit = produit;
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
		public List<Produit> getProduits() {
			return produits;
		}
		public void setProduits(List<Produit> produits) {
			this.produits = produits;
		}
		
		public Hotel getHotel() {
			return hotel;
		}
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}
		public List<Hotel> getHotels() {
			return hotels;
		}
		public void setHotels(List<Hotel> hotels) {
			this.hotels = hotels;
		}
		
		//===========================
		//	Les methodes
		//===========================
		
	
		@PostConstruct
		private void initFields(){
			 nom = "" ;
			 quantite = 0 ;
			 coutAchat = 0.0 ;
			 coutVente = 0.0;
		}

	public void add(){
		Produit produit = new Produit(nom, quantite, coutAchat, coutVente);
		serviceProduit.addProduit(produit, selectedidHotel);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++" + produit);
		initFields();
		getAllProduits();
	}
		
	
		public Produit getOneProduit(Long idProduit){
			produit = serviceProduit.getOneProduit(idProduit);
			return produit;
		}
		
		public void update(){
			
			serviceProduit.updateProduit(produit);
		}
		
		public void getAllProduits(){
			produits = serviceProduit.getAllProduit();
			
			
			
		}
		public void getAllHotels(){
			hotels = hotelBean.getAll();
			
			LOGGER.info("----------------la liste hotels est--------------" + hotels);
			
		}
		
}
