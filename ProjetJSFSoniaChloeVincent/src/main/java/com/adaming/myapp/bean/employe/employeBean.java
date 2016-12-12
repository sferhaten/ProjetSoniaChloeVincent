package com.adaming.myapp.bean.employe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.servicepersonne.IServicePersonne;

@Component("employeBean")
@ViewScoped
	public class employeBean {

	private Logger LOGGER = Logger.getLogger(employeBean.class);
		
	@Inject
	private IServicePersonne servicePersonne;
	
	
	
	
	@Inject
	private hotelBean hotelService;
	
	private List<Employe> employes;
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private Hotel hotel;
	private String nomHotel;
	private Long idHotel;
	
	
	private Employe employe;
	private String nom;
	private String prenom;	
	private Date dateEmbauuche;
	private String role;
	private Double salaire;
	private Date dateDeNaissance;
	private Adresse adressePersonne;
	
	public List<Hotel> getAllHotel(){
		hotels= hotelService.getAll();
		return hotels;
	}
	
	public Employe GetEmploye(Long idEmploye){
		
		Employe e = (Employe) servicePersonne.getPersonne(idEmploye);
		LOGGER.info("Employe trouvé : " + e.getIdPersonne() );
		return e;		
							
	}

	
	
	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public hotelBean getHotelService() {
		return hotelService;
	}

	public void setHotelService(hotelBean hotelService) {
		this.hotelService = hotelService;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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

	public Date getDateEmbauuche() {
		return dateEmbauuche;
	}

	public void setDateEmbauuche(Date dateEmbauuche) {
		this.dateEmbauuche = dateEmbauuche;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
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

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	
	public void getHotel(){
		hotelService.getAll();
		
	}
		

	
	
	
}
		

