package com.adaming.myapp.bean.employe;

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
import com.adaming.myapp.entities.Cdd;
import com.adaming.myapp.entities.Cdi;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Stagiaire;
import com.adaming.myapp.servicepersonne.IServicePersonne;

@Component("empBean")
@ViewScoped
public class employeBean {

	private Logger LOGGER = Logger.getLogger(employeBean.class);

	@Inject
	private IServicePersonne servicePersonne;

	@Inject
	private hotelBean hotelBean;


	private Employe employe;
	private String nom;
	private String prenom;
	private Date dateEmbauuche;
	private String role;
	private Double salaire;
	private Date dateDeNaissance;
	private Adresse adressePersonne;
	private Date dateDeSortie;
	private Double primePrecarite;

	private Hotel hotel;
	private String nomHotel;
	private Adresse adresse;
	private String numero;
	private String voie;
	private String codePostal;
	private String ville;
	private String pays;
	private Long idHotel;
	private Long selectedidHotel;

	private List<Hotel> hotels = new ArrayList<Hotel>();
	private Set<Consomation> consomations = new HashSet<Consomation>();
	//===
	//
	//===
	
	private Personne personne;
	private Long idPersonne;
	private Set<Employe> employes = new HashSet<Employe>();
	private Long idEmploye;

	private String option;
	private boolean cDIVisibles = false;
	private boolean cDDVisibles = false;
	private boolean stagiaireVisibles = false;

	public employeBean() {
		super();
		LOGGER.info(" <--------- employe been crée ----------------------> ");
	}

	
	//===========================
	//		Les methodes
	//===========================

	@PostConstruct
	public void getAllHotels() {
		hotels = hotelBean.getAll();
		System.out.println("++++++++++++++++++++++++++" + hotels);
		LOGGER.info("----------------la liste hotels est--------------"
				+ hotels);

	}
	

	public String update(){
		servicePersonne.updatePersonne(personne);
		System.out.println("==================================" + personne);
		return "home?redirect-faces-true";
	}

	
	public void initFields() {
		nom = "";
		prenom = "";
		dateEmbauuche = null;
		role = "";
		salaire = 0.0;
		dateDeNaissance = null;
		adressePersonne = null;
		dateDeSortie = null;
		primePrecarite = 0.0;
		pays = "";
		ville = "";
		numero = "";
		voie = "";
		codePostal = "";
		
	}
	
	public void choisir() {

		System.out.println("choisir lancée");
		System.out.println("option : " + option);
		cDIVisibles = false;
		cDDVisibles = false;
		stagiaireVisibles = false;

		if (option.equals("CDI")) {
			initFields();
			cDIVisibles = true;
		} else if (option.equals("CDD")) {
			initFields();
			cDDVisibles = true;
		} else if (option.equals("Stagiaire")) {
			initFields();
			stagiaireVisibles = true;
		}
	}

	public void add() {

		System.out.println("add lancée");
		System.out.println("option : " + option);

		if (option.equals("CDI")) {
			Adresse adressePersonne = new Adresse(numero, voie, codePostal,
					ville, pays);
			Personne CDI = new Cdi(nom, prenom, dateDeNaissance,
					adressePersonne, dateEmbauuche, role, salaire);
			servicePersonne.addPersonne(CDI, selectedidHotel);
			getAllEmployeByHotel();
			initFields();
			
		} else if (option.equals("CDD")) {
			Adresse adressePersonne = new Adresse(numero, voie, codePostal,
					ville, pays);
			Personne CDD = new Cdd(nom, prenom, dateDeNaissance,
					adressePersonne, dateEmbauuche, role, salaire,
					dateDeSortie, primePrecarite);
			servicePersonne.addPersonne(CDD, selectedidHotel);
			getAllEmployeByHotel();
			initFields();
		} else if (option.equals("Stagiaire")) {
			Adresse adressePersonne = new Adresse(numero, voie, codePostal,
					ville, pays);
			Personne Stage = new Stagiaire(nom, prenom, dateDeNaissance,
					adressePersonne, dateEmbauuche, role, salaire);
			servicePersonne.addPersonne(Stage, selectedidHotel);
			System.out.println("++++++++++++++++++++++++++" + Stage);
			getAllEmployeByHotel();
			initFields();
		}
		
	}

	
	//=========================================
	//			methodes que jai rajoute
	//=========================================

	public void getAllEmployeByHotel(){
		employes = hotelBean.getEmployeParHotel(selectedidHotel);
		System.out.println("--------------------------------methode employes" + employes);
	}
	
	public void getOneEmploye(Long idPersonne){
		personne = servicePersonne.getPersonne(idPersonne);
		System.out.println("+++++++++++++++++++++++++++++" + personne);
	}
	
	public Set<Consomation> getAllConsomation(Long idPersonne){
		return consomations = servicePersonne.consomations(idPersonne);
	}

public String redirect(){
		initFields();
		return "employe?faces-redirect=true";
	}


	// ===========================
	// Getter and setter
	// ===========================

	
	
	public Logger getLOGGER() {
		return LOGGER;
	}

	public Set<Consomation> getConsomations() {
		return consomations;
	}


	public void setConsomations(Set<Consomation> consomations) {
		this.consomations = consomations;
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Long getIdPersonne() {
		return idPersonne;
	}


	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
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

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public Double getPrimePrecarite() {
		return primePrecarite;
	}

	public void setPrimePrecarite(Double primePrecarite) {
		this.primePrecarite = primePrecarite;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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



	public Set<Employe> getEmployes() {
		return employes;
	}



	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}



	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean iscDIVisibles() {
		return cDIVisibles;
	}

	public void setcDIVisibles(boolean cDIVisibles) {
		this.cDIVisibles = cDIVisibles;
	}

	public boolean iscDDVisibles() {
		return cDDVisibles;
	}

	public void setcDDVisibles(boolean cDDVisibles) {
		this.cDDVisibles = cDDVisibles;
	}

	public boolean isStagiaireVisibles() {
		return stagiaireVisibles;
	}

	public void setStagiaireVisibles(boolean stagiaireVisibles) {
		this.stagiaireVisibles = stagiaireVisibles;
	}

	public IServicePersonne getServicePersonne() {
		return servicePersonne;
	}

	public void setServicePersonne(IServicePersonne servicePersonne) {
		this.servicePersonne = servicePersonne;
	}


	public Long getIdEmploye() {
		return idEmploye;
	}


	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

}
