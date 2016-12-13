package com.adaming.myapp.bean.facture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.client.ClientBean;
import com.adaming.myapp.bean.hotel.gestionHotelBean;
import com.adaming.myapp.bean.hotel.hotelBean;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicefacture.IServicefacture;

@Component("factureBean")
@ViewScoped
public class FactureBean {
	
	private Logger LOGGER = Logger.getLogger("FactureBean");
	
	@Inject
	private IServicefacture service;
	
	@Inject
	private hotelBean serviceHotel;
	
	private ClientBean serviceClient;
	
	private Facture facture;
	private List<Facture> listeFactures = new ArrayList<Facture>();
	private long idFacture;
	private double coutResa;
	private double coutConso;
	private List<Hotel> listeHotels = new ArrayList<Hotel>();
	private Long idHotel;
	private Set<Client> listePersonnes = new HashSet<Client>() ;
	private Long idPersonne;
	private Set<Reservation> listeReservations = new HashSet<Reservation>();
	

	private Set<Consomation> listeConsommations = new HashSet<Consomation>();
	
	
	
	@PostConstruct
	public void init(){
		
		getHotel();
		
	}
	
	public void getHotel(){
		
		listeHotels = serviceHotel.getHotels();
		
	}
	
	
	public void getClientsHotel(){
		
		listePersonnes = serviceHotel.clientsByHotel(idHotel);
		
	}
	
	public void getActivites(){
		
		System.out.println("getActivites lancée");
		
		System.out.println("idPersonne : " + idPersonne);
		
		listeReservations = serviceClient.getReservationsNonFacturees(idPersonne);
		listeConsommations = serviceClient.getConsommationsNonFacturees(idPersonne);
		
	}
	
	
	
	

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<Facture> getListeFactures() {
		return listeFactures;
	}

	public void setListeFactures(List<Facture> listeFactures) {
		this.listeFactures = listeFactures;
	}

	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	public double getCoutResa() {
		return coutResa;
	}

	public void setCoutResa(double coutResa) {
		this.coutResa = coutResa;
	}

	public double getCoutConso() {
		return coutConso;
	}

	public void setCoutConso(double coutConso) {
		this.coutConso = coutConso;
	}

	public List<Hotel> getListeHotels() {
		return listeHotels;
	}

	public void setListeHotels(List<Hotel> listeHotels) {
		this.listeHotels = listeHotels;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	
	

	public Set<Client> getListePersonnes() {
		return listePersonnes;
	}

	public void setListePersonnes(Set<Client> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
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
	
	


	
	
	
}
