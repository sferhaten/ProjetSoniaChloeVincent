package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicefacture.IServicefacture;


public class ServiceFactureTest {
	
	private static ClassPathXmlApplicationContext context;
	private static IServicefacture service;
	private final Logger LOGGER = Logger.getLogger("ServiceFactureTest");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IServicefacture) context.getBean("ServiceFactureImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	@Ignore
	public void testAddFactureToReservation() {
		
		System.out.println("Début testAddFactureToReservation");
		
		Facture f = new Facture();
		Reservation reserv1 = new Reservation(new Date(), new Date(), 601);
		reserv1.setIdReservation(5L);
		Reservation reserv2 = new Reservation(new Date(), new Date(), 8010);
		reserv2.setIdReservation(6L);
		Set<Reservation> reservations = new HashSet<Reservation>();
		reservations.add(reserv1);
		reservations.add(reserv2);
		System.out.println("Taille de reservations : " + reservations.size());
		
		service.addFactureToReservation(f, reservations, 2L);
		
		System.out.println("IdFacture du test : " + f.getIdFacture() );
		
		assertNotNull(f.getIdFacture());
		
		System.out.println("Fin testAddFactureToReservation");
		
	}

	@Test
	@Ignore
	public void testAddFactureToConsomation() {
		
		System.out.println("Début testAddFactureToConsomation");
		
		Produit produit1 = new Produit("Cafe", 30, 1.0, 5.0);
		produit1.setIdProduit(1L);
		Produit produit2 = new Produit("The", 120, 2.0, 4.0);
		produit2.setIdProduit(2L);
		
		Facture f = new Facture();
		Consomation conso1 = new Consomation(3);
		conso1.setIdConsommation(1L);
		conso1.setProduit(produit1);
		Consomation conso2 = new Consomation(4);
		conso2.setIdConsommation(2L);
		conso2.setProduit(produit2);
		Set<Consomation> consommations = new HashSet<Consomation>();
		consommations.add(conso1);
		consommations.add(conso2);
		

		service.addFactureToConsomation(f, consommations, 2L);
		
		assertNotNull(f.getIdFacture());
		
		System.out.println("Fin testAddFactureToConsomation");
	}

	@Test
	@Ignore
	public void testAddFacture() {
		
		System.out.println("Début testAddFacture");
		
		Produit produit1 = new Produit("Cafe", 30, 1.0, 5.0);
		produit1.setIdProduit(1L);
		Produit produit2 = new Produit("The", 120, 2.0, 4.0);
		produit2.setIdProduit(2L);
		
		Facture f = new Facture();
		
		Reservation reserv1 = new Reservation(new Date(), new Date(), 1001);
		reserv1.setIdReservation(7L);
		Reservation reserv2 = new Reservation(new Date(), new Date(), 1201);
		reserv2.setIdReservation(8L);
		Set<Reservation> reservations = new HashSet<Reservation>();
		reservations.add(reserv1);
		reservations.add(reserv2);
		
		Consomation conso1 = new Consomation(5);
		conso1.setIdConsommation(3L);
		conso1.setProduit(produit1);
		Consomation conso2 = new Consomation(6);
		conso2.setIdConsommation(4L);
		conso2.setProduit(produit2);
		Set<Consomation> consommations = new HashSet<Consomation>();
		consommations.add(conso1);
		consommations.add(conso2);
		
		service.addFacture(f, reservations, consommations, 2L);
		
		assertNotNull(f.getIdFacture());
		
		System.out.println("Fin testAddFacture");
		
	}
	
	
	@Test
	public void testGetOneFacture() {
		
		System.out.println("Début testGetOneFacture");
		Facture f = service.getOneFacture(1L);
		
		assertNotNull(f);
		
		System.out.println("Fin testGetOneFacture");
	}

	@Test
	public void testUpdateFacture() {
		
		System.out.println("Début testUpdateFacture");

		Facture f = service.getOneFacture(1L);
		Double coutInitial = f.getCoutConso();
		f.setCoutConso(coutInitial + 1);
		
		service.updateFacture(f);
		
		Facture f2 = service.getOneFacture(1L);
		Double coutFinal = f2.getCoutConso();
		
		assertTrue((coutFinal) == (coutInitial + 1) );
		
		System.out.println("Fin testUpdateFacture");
		
	}

	

	@Test
	public void testGetAllFacture() {
		
		System.out.println("Début testGetAllFacture");
	
		List<Facture> factures = service.getAllFacture();
		
		assertTrue(factures.size() > 1);
		
		System.out.println("Fin testGetAllFacture");
		
	}

	@Test
	public void testGetConsoByFacture() {
		
		System.out.println("Début testGetConsoByFacture");
		
		Set<Consomation> consommations = service.getConsoByFacture(19L);
		
		assertTrue(consommations.size() > 1);
		
		System.out.println("Fin testGetConsoByFacture");
		
	}

	@Test
	public void testGetReserByFacture() {
		
		System.out.println("Début testGetReserByFacture");
		
		Set<Reservation> reservations = service.getReserByFacture(18L);
		
		assertTrue(reservations.size() > 1);
		
		System.out.println("Fin testGetReserByFacture");
	}



}
