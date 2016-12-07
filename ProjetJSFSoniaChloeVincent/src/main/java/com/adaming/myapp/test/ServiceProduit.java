package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.jboss.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.daoproduit.DaoProduitImpl;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.serviceproduit.IServiceProduit;


public class ServiceProduit {
	
	private static ClassPathXmlApplicationContext context;
    private static IServiceProduit serviceProduit;
    
    private final Logger LOGGER = Logger.getLogger(ServiceProduit.class);

	
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceProduit = (IServiceProduit) context.getBean("ServiceProduitImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAddProduit() {
		Produit  p = new Produit("the", 2, 2.0, 2.0);
		serviceProduit.addProduit(p, 1L);
		assertNotNull(p.getIdProduit());
	}

	@Test
	@Ignore
	public void testUpdateProduit() {
		Produit p1 = serviceProduit.getOneProduit(1L);
		p1.setNom("cafe");
		serviceProduit.updateProduit(p1);
		Produit p2 = serviceProduit.getOneProduit(1L);
		assertThat("cafe", IsEqual.equalTo(p2.getNom()));
		
	}

	@Test
	@Ignore
	public void testGetOneProduit() {
		Produit p = serviceProduit.getOneProduit(1L);
		assertNotNull(p);
	}

	@Test
	@Ignore
	public void testGetAllProduit() {
		List<Produit> produits = new ArrayList<Produit>();
        assertNotNull(produits);
	}

}
