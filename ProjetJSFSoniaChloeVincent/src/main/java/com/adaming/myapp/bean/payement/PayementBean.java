package com.adaming.myapp.bean.payement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.client.ClientBean;
import com.adaming.myapp.bean.facture.FactureBean;
import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.bean.produit.addProduitBean;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.CarteBancaire;
import com.adaming.myapp.entities.Cdd;
import com.adaming.myapp.entities.Cdi;
import com.adaming.myapp.entities.Cheque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Espece;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Payement;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Stagiaire;
import com.adaming.myapp.servicepayement.IServicePayement;

@Component("payementBean")
@ViewScoped
public class PayementBean {
	private Logger LOGGER = Logger.getLogger(PayementBean.class);

	@Inject
	private IServicePayement servicepayement;
	@Inject
	private FactureBean factureBean;
	@Inject
	private hotelBean serviceHotel;
	@Inject
	private ClientBean serviceClient;
	
	

	// ===========================
	// les attribus
	// ===========================

	private Set<Reservation> listeReservations = new HashSet<Reservation>();

	private Set<Consomation> listeConsommations = new HashSet<Consomation>();
	
	private Set<Client> listePersonnes = new HashSet<Client>();
	
	private Long idHotel;

	

	private List<Hotel> listeHotels = new ArrayList<Hotel>();
	private Long idPersonne;
	private List<Payement> payements;
	private Payement payement;
	private double coutTotal;
	private Date date;
	private String devise;
	private List<Facture> factures = new ArrayList<Facture>();
	
	private List<Facture> facturesPayees = new ArrayList<Facture>();
	private List<Facture> facturesNonPayees = new ArrayList<Facture>();
	private Facture facture;
	private Facture idFacture;
	private Long selectidFacture;
	private String typeCarte;
	private int numCarte;
	private int numCheque;
	private String banqueCheque;

	private String option;
	private boolean especeVisible = false;
	private boolean carteBancaireVisible = false;
	private boolean chequeVisible = false;

	// ===========================
	// Les methodes
	// ===========================.
	public PayementBean() {
		super();
		LOGGER.info(" <--------- employe been crée ----------------------> ");
	}

	public String redirect(){
		initFields();
		return "payement?faces-redirect=true";
	}
	
	@PostConstruct
	private void initFields() {
		date = null;
		coutTotal = 0.0;
		devise = "";
		typeCarte = "";
		numCarte = 0;
		numCheque = 0;
		banqueCheque = "";
		getHotel();

	}
	
	public void getHotel() {

		listeHotels = serviceHotel.getHotels();
		idPersonne = 0L;

	}

	public void getClientsHotel() {

		listePersonnes = serviceHotel.clientsByHotel(idHotel);

		listeReservations = new HashSet<Reservation>();

		listeConsommations = new HashSet<Consomation>();

		idPersonne = 0L;

	}
	
	public void getFacturesClient(){
			
		facturesNonPayees = new ArrayList<Facture>(serviceClient.factureClientNonPayees(idPersonne));
		
		
		
	}
	
	
	
	public void choisir() {

		System.out.println("choisir lancée");
		System.out.println("option : " + option);
		especeVisible = false;
		carteBancaireVisible = false;
		chequeVisible = false;
		
		if (option == null) {
			
		}else if (option.equals("espece")) {
			initFields();
			especeVisible = true;
		} else if (option.equals("carteBancaire")) {
			initFields();
			carteBancaireVisible = true;
		} else if (option.equals("cheque")) {
			initFields();
			chequeVisible = true;
		}
	}
	
	public void add() {
		if (option.equals("espece")) {
			Payement espece = new Espece(coutTotal, date, devise);
			servicepayement.addPayement(payement, selectidFacture);
			initFields();
		} else if (option.equals("carteBancaire")) {
			Payement carteBancaire = new CarteBancaire(coutTotal, date,
					numCarte, typeCarte);
			servicepayement.addPayement(payement, selectidFacture);
			initFields();
		} else if (option.equals("cheque")) {
			Payement cheque = new Cheque(coutTotal, date, numCheque,
					banqueCheque);
			servicepayement.addPayement(payement, selectidFacture);
			initFields();
		}
	}
	public void getOnePayement(Long  idPayement)
	{
		payement = servicepayement.addPayement(payement, selectidFacture);
	}
	
	public String update(){
		servicepayement.updatePayement(payement);
		return "home?redirect-faces-true";
	}

	@PostConstruct
	public void getAllPayement(){
		payements = servicepayement.getAllPayement();
	}
	
	@PostConstruct
	public void getAllFactures() {
		factures = factureBean.getAllFactures();
	
	}
	
	//===========================
	//	Getter and Setter
	//===========================
	

	public Logger getLOGGER() {
		return LOGGER;
	}

	public void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	public FactureBean getFactureBean() {
		return factureBean;
	}

	public void setFactureBean(FactureBean factureBean) {
		this.factureBean = factureBean;
	}

	public List<Payement> getPayements() {
		return payements;
	}

	public void setPayements(List<Payement> payements) {
		this.payements = payements;
	}

	public Payement getPayement() {
		return payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}

	public double getCoutTotal() {
		return coutTotal;
	}

	public void setCoutTotal(double coutTotal) {
		this.coutTotal = coutTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Facture getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Facture idFacture) {
		this.idFacture = idFacture;
	}

	public Long getSelectidFacture() {
		return selectidFacture;
	}

	public void setSelectidFacture(Long selectidFacture) {
		this.selectidFacture = selectidFacture;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public int getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public int getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}

	public String getBanqueCheque() {
		return banqueCheque;
	}

	public void setBanqueCheque(String banqueCheque) {
		this.banqueCheque = banqueCheque;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isEspeceVisible() {
		return especeVisible;
	}

	public void setEspeceVisible(boolean especeVisible) {
		this.especeVisible = especeVisible;
	}

	public boolean isCarteBancaireVisible() {
		return carteBancaireVisible;
	}

	public void setCarteBancaireVisible(boolean carteBancaireVisible) {
		this.carteBancaireVisible = carteBancaireVisible;
	}

	public boolean isChequeVisible() {
		return chequeVisible;
	}

	public void setChequeVisible(boolean chequeVisible) {
		this.chequeVisible = chequeVisible;
	}

	public List<Facture> getFacturesPayees() {
		return facturesPayees;
	}

	public void setFacturesPayees(List<Facture> facturesPayees) {
		this.facturesPayees = facturesPayees;
	}

	public Set<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(Set<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}

	public Set<Consomation> getListeConsommations() {
		return listeConsommations;
	}

	public void setListeConsommations(Set<Consomation> listeConsommations) {
		this.listeConsommations = listeConsommations;
	}

	public Set<Client> getListePersonnes() {
		return listePersonnes;
	}

	public void setListePersonnes(Set<Client> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public List<Hotel> getListeHotels() {
		return listeHotels;
	}

	public void setListeHotels(List<Hotel> listeHotels) {
		this.listeHotels = listeHotels;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	
}

