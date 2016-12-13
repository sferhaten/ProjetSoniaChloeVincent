package com.adaming.myapp.bean.payement;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.produit.addProduitBean;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.CarteBancaire;
import com.adaming.myapp.entities.Cdd;
import com.adaming.myapp.entities.Cdi;
import com.adaming.myapp.entities.Cheque;
import com.adaming.myapp.entities.Espece;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Payement;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.entities.Stagiaire;
import com.adaming.myapp.servicepayement.IServicePayement;

@Component("payementBean")
@ViewScoped
public class PayementBean {
	private Logger LOGGER = Logger.getLogger(PayementBean.class);

	@Inject
	private IServicePayement servicepayement;
	@Inject
	private factureBean factureBean;

	// ===========================
	// les attribus
	// ===========================

	private List<Payement> payements;
	private Payement payement;
	private double coutTotal;
	private Date date;
	private String devise;
	private List<Facture>
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
	// ===========================
	public PayementBean() {
		super();
		LOGGER.info(" <--------- employe been crée ----------------------> ");
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

	}
	public void choisir() {

		System.out.println("choisir lancée");
		System.out.println("option : " + option);
		especeVisible = false;
		carteBancaireVisible = false;
		chequeVisible = false;

		if (option.equals("espece")) {
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
		factures = factureBean.
	
	}
	
	//===========================
	//	Getter and Setter
	//===========================
	
	

}

