package com.adaming.myapp.bean.reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.client.ClientBean;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreSimple;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicereservation.IServiceReservation;

@Component("reservationBean")
@ViewScoped
public class ReservationBean {
	
	private Logger LOGGER = Logger.getLogger(ReservationBean.class);
	
	@Inject
	private IServiceReservation service;
	
	@Inject
	private ClientBean serviceClient;
	
	private Reservation reservation;

	private List<Reservation> listeReservations;
	
	private Date dateArrive;

	private Date dateSortie;
	
	private String typeChambre;
	
	private List<Chambre> listeChambres = new ArrayList<Chambre>()		;

	private Long idClient;
	private Long idHotel;
	private Long idChambre;
	
	
	public ReservationBean() {
		super();
		LOGGER.info("------ ReservationBean created ------");
	}


	public void getAll(){
		listeReservations = new ArrayList<Reservation>(serviceClient.GetClient(1L).getReservations());
	}
	
	@PostConstruct
	public void init(){
		getAll();
		LOGGER.info("Liste de réservations initialisée");
		
		Chambre ch1 = new ChambreSimple();
		Chambre ch2 = new ChambreSimple();
		
		ch1.setIdChambre(1L);
		ch2.setIdChambre(2L);
		
		listeChambres.add(ch1);
		listeChambres.add(ch2);
		System.out.println("Liste de chambres - taille : " + listeChambres.size());
		
	}
	
	
	
	
	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public List<Reservation> getListeReservations() {
		return listeReservations;
	}


	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}


	public Date getDateArrive() {
		return dateArrive;
	}


	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}


	public Date getDateSortie() {
		return dateSortie;
	}


	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}


	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public Long getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}


	public Long getIdChambre() {
		return idChambre;
	}


	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}

	
	
	public String getTypeChambre() {
		return typeChambre;
	}


	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}



	
	
	public List<Chambre> getListeChambres() {
		return listeChambres;
	}


	public void setListeChambres(List<Chambre> listeChambres) {
		this.listeChambres = listeChambres;
	}
	
	
	
	
	
}
