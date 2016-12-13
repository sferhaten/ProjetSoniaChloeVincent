package com.adaming.myapp.bean.hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.servicechambre.IServiceChambre;
import com.adaming.myapp.servicehotel.IServiceHotel;



@Component("gestionHotelBean")
@ViewScoped
public class gestionHotelBean {

	private Logger LOGGER = Logger.getLogger(gestionHotelBean.class);
	@Inject
	private IServiceHotel serviceHotel;
	@Inject
	private IServiceChambre serviceChambre;
	
	private Hotel hotel;
	private Long idHotel;
	private String nomHotel;
	private List<Hotel>hotels = new ArrayList<Hotel>();
	private Set<Produit> produits = new HashSet<Produit>();
	private Set<Produit> produitsDispoByHotel = new HashSet<Produit>();
	private Set<Client>clients = new HashSet<Client>();
	private Set<Employe>employes = new HashSet<Employe>();
	private Long idProduit;
	private String nom;
	private Integer quantite;
	private Double coutAchat;
	private Double coutVente;
	private Long selectedidHotel;
	private Set<Chambre> chambres = new HashSet<Chambre>();
	private String option;
	private Date dateDemandee1;
	private Date dateDemandee2;
	
	private String ListeEmployes;
	private String ListeChambres;
	private String ListeProduits;
	private String ListeClients;
	private Double benefice;
	private Chambre chambre;
	private long idChambre;
	private boolean produitsVisibles = false;
	private boolean chambressVisibles = false;
	private boolean employesVisibles = false;
	private boolean clientsVisibles = false;
	
	private boolean  beneficeVisible=false;
	
	//====================================
	//	Getter and setter
	//====================================
	
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public boolean isBeneficeVisible() {
		return beneficeVisible;
	}
	public void setBeneficeVisible(boolean beneficeVisible) {
		this.beneficeVisible = beneficeVisible;
	}
	public Double getBenefice() {
		return benefice;
	}
	public void setBenefice(Double benefice) {
		this.benefice = benefice;
	}
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public Set<Produit> getProduitsDispoByHotel() {
		return produitsDispoByHotel;
	}
	public void setProduitsDispoByHotel(Set<Produit> produitsDispoByHotel) {
		this.produitsDispoByHotel = produitsDispoByHotel;
	}
	public Date getDateDemandee1() {
		return dateDemandee1;
	}
	public void setDateDemandee1(Date dateDemandee1) {
		this.dateDemandee1 = dateDemandee1;
	}
	public Date getDateDemandee2() {
		return dateDemandee2;
	}
	public void setDateDemandee2(Date dateDemandee2) {
		this.dateDemandee2 = dateDemandee2;
	}
	public String getListeClients() {
		return ListeClients;
	}
	public void setListeClients(String listeClients) {
		ListeClients = listeClients;
	}
	public String getListeEmployes() {
		return ListeEmployes;
	}
	public void setListeEmployes(String listeEmployes) {
		ListeEmployes = listeEmployes;
	}
	public String getListeChambres() {
		return ListeChambres;
	}
	public void setListeChambres(String listeChambres) {
		ListeChambres = listeChambres;
	}
	public String getListeProduits() {
		return ListeProduits;
	}
	public void setListeProduits(String listeProduits) {
		ListeProduits = listeProduits;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	public Set<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}
	
	public String getOption() {
		return option;
	}
	
	public void setOption(String option) {
		this.option = option;
	}
	public Set<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}
	public Long getSelectedidHotel() {
		return selectedidHotel;
	}
	public void setSelectedidHotel(Long selectedidHotel) {
		this.selectedidHotel = selectedidHotel;
	}
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
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
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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

	public boolean isProduitsVisibles() {
		return produitsVisibles;
	}
	public void setProduitsVisibles(boolean produitsVisibles) {
		this.produitsVisibles = produitsVisibles;
	}
	public boolean isChambressVisibles() {
		return chambressVisibles;
	}
	public void setChambressVisibles(boolean chambressVisibles) {
		this.chambressVisibles = chambressVisibles;
	}
	public boolean isEmployesVisibles() {
		return employesVisibles;
	}
	public void setEmployesVisibles(boolean employesVisibles) {
		this.employesVisibles = employesVisibles;
	}
	public boolean isClientsVisibles() {
		return clientsVisibles;
	}
	public void setClientsVisibles(boolean clientsVisibles) {
		this.clientsVisibles = clientsVisibles;
	}


	
	
	//====================================
	//	Les methodes
	//====================================
	

	public String redirect(){
		
		return "gestionHotel?faces-redirect=true";
	}
	
	@PostConstruct
	public void init(){
		getAllHotels();
	}
	public void getAllHotels(){
		hotels = serviceHotel.getAll();
		System.out.println("liste hotels" + hotels);
		
	}
	
	public Set<Produit> getProduitsDispo(Long idHotel){
		return produitsDispoByHotel = serviceHotel.produitsDisposByHotel(idHotel);
	}
	public void getOneChambre(long idChambre){
		chambre = serviceChambre.getOneChambre(idChambre);
	}
	public void updateChambre(){
		serviceChambre.updateChambre(chambre);
	}


	public void getAll(){
		
		System.out.println("GetAll lancé");
		System.out.println("Option : " + option);
		System.out.println();
		
		produitsVisibles = false;
		chambressVisibles = false;
		employesVisibles = false;
		clientsVisibles = false;
		beneficeVisible=false;
		
		if(option.equals("ListeProduits")){
		
			System.out.println("le id selected est " + selectedidHotel);
			produits = serviceHotel.produitsByHotel(selectedidHotel);	
			System.out.println("le liste produits est ---------------- " + produits);
			produitsVisibles = true;
		}
		else if (option.equals("ListeChambres")){
			chambres= serviceHotel.chambreByHotel(selectedidHotel);
			System.out.println("le liste chambres est ---------------- " + chambres);
			chambressVisibles = true;
		}
		else if (option.equals("ListeClients")){
			clients = serviceHotel.clientsByHotel(selectedidHotel);
			System.out.println("le liste clients est ---------------- " + clients);
			clientsVisibles = true;
		}
		else if (option.equals("ListeEmployes")){
			employes = serviceHotel.employesByHotel(selectedidHotel);
			System.out.println("le liste employes est ---------------- " + employes);
			employesVisibles = true;
		}
		
		else if (option.equals("ListeChambresSimples")){
			chambres = serviceHotel.chambreSimpleDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
		}
		else if (option.equals("ListeChambresDoubles")){
			chambres = serviceHotel.chambreDoubleDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
		}
		else if (option.equals("ListeChambresSuite")){
			chambres = serviceHotel.chambreSuiteDisposByHotel(idHotel, dateDemandee1, dateDemandee2);
		}
		else if (option.equals("BeneficeAnnuel")){
			benefice = serviceHotel.beneficeAnnuel(selectedidHotel);
			beneficeVisible=true;
		}
	}

}
