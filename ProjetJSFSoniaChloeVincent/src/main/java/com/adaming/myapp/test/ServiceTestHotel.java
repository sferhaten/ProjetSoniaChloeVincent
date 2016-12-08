package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.servicehotel.IServiceHotel;

public class ServiceTestHotel {
	
	private static ClassPathXmlApplicationContext context;
	private static IServiceHotel service;
	private final Logger LOGGER = Logger.getLogger("ServiceTestHotel");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IServiceHotel) context.getBean("ServiceHotelImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAddHotel() {
		
		Adresse adresse = new Adresse("14", "rue des", "75013", "Paris", "France");
		Hotel h = new Hotel("Ibis", adresse, "0606", 3);
		service.addHotel(h);
		assertNotNull(h.getIdHotel());
	}

	@Test
	@Ignore
	public void testGetHotel() {
		Hotel h = service.getHotel(3L);
		assertNotNull(h);
	}	

	@Test
	@Ignore
	public void testGetAll() {
		List<Hotel> hotels = service.getAll();
		System.out.println("testGetAll");
		System.out.println("nombre d hotel : " + hotels.size());
		assertNotNull(hotels);
	}

	@Test
	public void testEmployesByHotel() {
		Set<Employe> employes = service.employesByHotel(2L);
		System.out.println("testEmployesByHotel");
		System.out.println("nombre d employes : " + employes.size());
		assertTrue(employes.size() > 0);
	}

	@Test
	public void testClientsByHotel() {
		Set<Client> clients = service.clientsByHotel(2L);
		System.out.println("testClientsByHotel");
		System.out.println("nombre de clients : " + clients.size());
		assertTrue(clients.size() > 0);
	}

	@Test
	public void testProduitsByHotel() {
		Set<Produit> produits = service.produitsByHotel(2L);
		System.out.println("nombre de produits : " + produits.size());
		assertTrue(produits.size() > 0);
	}

	@Test
	public void testProduitsDisposByHotel() {
		Set<Produit> produits = service.produitsDisposByHotel(2L);
		System.out.println("nombre de produits dispos : " + produits.size());
		assertTrue(produits.size() > 0);
	}
	
	@Test
	public void testProduitsNonDisposByHotel() {
		Set<Produit> produits = service.produitsNonDisposByHotel(2L);
		System.out.println("nombre de produits non dispos : " + produits.size());
		assertTrue(produits.size() > 0);
	}

	@Test
	public void testBeneficeAnnuel() {
		Double benefice = service.beneficeAnnuel(2L);
		System.out.println("benefice : " + benefice);
		assertTrue(benefice > 0.0);
	}

	@Test
	@Ignore
	public void testChambreByHotel() {
		Set<Chambre> chambres = service.chambreByHotel(2L);
		System.out.println("Nombre de chambres : " + chambres.size());
		assertTrue(chambres.size() > 0 );
	}

	@Test
	@Ignore
	public void testChambreDisposByHotel() {
		Set<Chambre> chambresDispos = service.chambreDisposByHotel(2L, new Date());
		System.out.println("Nombre de chambres dispos : " + chambresDispos.size());
		assertTrue(chambresDispos.size() > 0 );
	}

}
