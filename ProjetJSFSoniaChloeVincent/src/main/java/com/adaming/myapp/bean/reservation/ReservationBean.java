package com.adaming.myapp.bean.reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.primefaces.model.chart.DateAxis;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bean.client.ClientBean;
import com.adaming.myapp.bean.hotel.gestionHotelBean;
import com.adaming.myapp.bean.hotel.hotelBean;
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
	
	@Inject
	private hotelBean serviceHotel;
	

	
	
	private Reservation reservation;

	private List<Reservation> listeReservations;
	
	private Date dateArrive;

	private Date dateSortie;
	
	private Date dateMinimum = new Date();
	
	


	private String typeChambre;
	
	private List<Chambre> listeChambres = new ArrayList<Chambre>();

	private Long idClient = 1L;
	private Long idHotel = 2L;
	private Long idChambre;
	
	
	public ReservationBean() {
		super();
		LOGGER.info("------ ReservationBean created ------");
	}


	public void getAll(){
		listeReservations = new ArrayList<Reservation>(serviceClient.GetClient(idClient).getReservations());
	}
	
	@PostConstruct
	public void init(){
		getAll();
		LOGGER.info("Liste de réservations initialisée");
		
//		Chambre ch1 = new ChambreSimple();
//		Chambre ch2 = new ChambreSimple();
//		
//		ch1.setIdChambre(1L);
//		ch2.setIdChambre(2L);
//		
//		ch1.setNumChambre(1L);
//		ch2.setNumChambre(2L);
//		
//		listeChambres.add(ch1);
//		listeChambres.add(ch2);
		
		
		
		System.out.println("Liste de chambres - taille : " + listeChambres.size());
		
	}
	
	public void setd1(){
		setDateArrive(dateArrive);
		System.out.println("d arrivee"+dateArrive);
	}
	public void setd2(){
		setDateSortie(dateSortie);
		System.out.println("d Sortie"+dateSortie);
	}
	public void setd3(){
		setTypeChambre(typeChambre);
		System.out.println("typeChambre"+typeChambre);
	}
	
	
	public void getChambresDispos(){
		setd3();
		System.out.println("adel type chambre : "+typeChambre);
		LOGGER.info("getChambresDispos");
		LOGGER.info("Type de chambre : " + typeChambre);
		LOGGER.info("1ère date : " + dateArrive);
		LOGGER.info("2ème date : " + dateSortie);
		LOGGER.info("Date minimum : " + dateMinimum);

		
		listeChambres = new ArrayList<Chambre>();
		
		if (dateArrive == null || dateSortie  == null) {
			System.out.println("Variables non récupérées");
		} else {
			if (typeChambre.equalsIgnoreCase("ChambreSimple") ) {
				listeChambres = new ArrayList<Chambre>(serviceHotel.getChambreSimpleDispo(idHotel, dateArrive , dateSortie));
			   
			} else {
				if (typeChambre.equalsIgnoreCase("ChambreDouble")) {
					listeChambres = new ArrayList<Chambre>(serviceHotel.getChambreDoubleDispo(idHotel, dateArrive , dateSortie));
					
				} else {
					if (typeChambre.equalsIgnoreCase("Suite")) {
						listeChambres = new ArrayList<Chambre>(serviceHotel.getChambreSuiteDispo(idHotel, dateArrive , dateSortie));
						
					}
				}
			}
		}
		
		
		
		LOGGER.info("Nombre de chambre : " + listeChambres.size());
		
	}
	
	public String add(){
		
		System.out.println("add lancée");
		System.out.println("dateArrive : " + dateArrive);
		System.out.println("dateSortie : " + dateSortie);
		System.out.println("idClient : " + idClient);
		System.out.println("idHotel : " + idHotel);
		System.out.println("idChambre : " + idChambre);
		
		if (dateArrive.before(dateSortie)) {
			Reservation r = new Reservation(dateArrive, dateSortie, 0);
			
			service.addReservation(r, idClient, idHotel, idChambre);
			
			getAll();
			
		} else {
			LOGGER.info("Date de sortie antérieure à la date d'arrivée");
		}
		
		return "addReservations?redirect-faces=true";
	}
	
	public void getOneReservation(Long idReservation){
		
		System.out.println("getOneReservation");
		System.out.println("idReservation : " + idReservation);
		
		reservation = service.getOneReservation(idReservation);
		
	}
	
	public void annuler(){
		
		System.out.println("annuler");
		
		System.out.println("Id Réservation : " + reservation.getIdReservation());
		
		if (reservation.getFacture() == null) {
			System.out.println("Réservation non facturée");
		} else {
			System.out.println("Réservation déjà facturée");
		}
		
		//service.Annulation(reservation.getIdReservation());
		
		getAll();
	}
	
	public String nePasAnnuler(){
		
		System.out.println("Ne pas annuler");
		
		getAll();
		
		return "addReservations?redirect-faces=true";
		
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
	
	
	public Date getDateMinimum() {
		return dateMinimum;
	}


	public void setDateMinimum(Date dateMinimum) {
		this.dateMinimum = dateMinimum;
	}

	
	
	
}
