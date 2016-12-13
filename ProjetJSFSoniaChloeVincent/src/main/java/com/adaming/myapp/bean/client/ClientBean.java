package com.adaming.myapp.bean.client;

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

import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicehotel.IServiceHotel;
import com.adaming.myapp.servicepersonne.IServicePersonne;

@Component("clientBean")
@ViewScoped
public class ClientBean {

	private Logger LOGGER = Logger.getLogger(ClientBean.class);

	@Inject
	private IServicePersonne servicePersonne;

	@Inject
	private hotelBean hotelBean;
	

	private Adresse adresse;

	private List<Personne> clients;
	private List<Hotel> hotels;
	private Client client;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Adresse adressePersonne;
	private Date dateDeSortie;
	private Integer nombreReservations;

	private Hotel hotel;
	private String nomHotel;
	private String numero;
	private String voie;
	private String codePostal;
	private String ville;
	private String pays;
	private Long idHotel;
	private Long selectedidHotel;
	private Set<Reservation> reservations = new HashSet<Reservation>();
	private Set<Consomation> consomations = new HashSet<Consomation>();
	
	
	//===============================
	//		les methodes 
	//===============================

	@PostConstruct
	private void initFields() {
		nom = "";
		prenom = "";
		dateDeNaissance = null;
		dateDeSortie = null;
		nombreReservations = 0;
		numero = "";
		voie = "";
		codePostal = "";
		ville = "";
		pays = "";
	}

	@PostConstruct
	public void getAllClient(){
		clients= servicePersonne.getAll();
	}
	

	public Client GetClient(Long idClient) {
		Client client = (Client) servicePersonne.getPersonne(idClient);
		LOGGER.info("Client trouvé : " + client.getIdPersonne());
		return client;
	}
	
	public void addClient() {
		Adresse adresse = new Adresse(numero, voie, codePostal, ville, pays);
		Client client = new Client(nom, prenom, dateDeNaissance, adresse,
				nombreReservations);
		servicePersonne.addPersonne(client, selectedidHotel);

	}
	
	public String update(){
		servicePersonne.updatePersonne(client);
		return "home?redirect-faces-true";
	}

	
public Set<Reservation> getReservationsNonFacturees(Long idPersonne){
		
		return servicePersonne.reservationsNonFacturees(idPersonne);
	}
	
public Set<Consomation> getConsommationsNonFacturees(Long idPersonne){
		
		return servicePersonne.consomationsNonFacturees(idPersonne);
	}

	public ClientBean() {
		super();
		LOGGER.info(" <--------- client been crée ----------------------> ");
	}

	public IServicePersonne getServicePersonne() {
		return servicePersonne;
	}

	public void setServicePersonne(IServicePersonne servicePersonne) {
		this.servicePersonne = servicePersonne;
	}

	
	public hotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(hotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Personne> getClients() {
		return clients;
	}

	public void setClients(List<Personne> clients) {
		this.clients = clients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Adresse getAdressePersonne() {
		return adressePersonne;
	}

	public void setAdressePersonne(Adresse adressePersonne) {
		this.adressePersonne = adressePersonne;
	}

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public Integer getNombreReservations() {
		return nombreReservations;
	}

	public void setNombreReservations(Integer nombreReservations) {
		this.nombreReservations = nombreReservations;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getSelectedidHotel() {
		return selectedidHotel;
	}

	public void setSelectedidHotel(Long selectedidHotel) {
		this.selectedidHotel = selectedidHotel;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Consomation> getConsomations() {
		return consomations;
	}

	public void setConsomations(Set<Consomation> consomations) {
		this.consomations = consomations;
	}

	
	
}
