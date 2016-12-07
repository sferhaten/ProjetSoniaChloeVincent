package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreDouble;
import com.adaming.myapp.servicechambre.IServiceChambre;


public class ServiceChambreTest {

	private static ClassPathXmlApplicationContext context;
	private static IServiceChambre serviceChambre;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		context = new ClassPathXmlApplicationContext("app.xml");
		serviceChambre =(IServiceChambre)context.getBean("ServiceChambreImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAddChambre() {
		Chambre c = new ChambreDouble(1, "blue", 100);
		serviceChambre.addChambre(c, 1L);
		assertNotNull(c.getIdChambre());
	}
	
	@Test
	@Ignore
	public void testUpdateChambre() {
	Chambre c1 = serviceChambre.getOneChambre(1L);
	c1.setDescription("green");
	serviceChambre.updateChambre(c1);
	Chambre c2 =serviceChambre.getOneChambre(c1.getIdChambre());
	assertThat("green", IsEqual.equalTo(c2.getDescription()));
	}

	@Test
	@Ignore
	public void testGetOneChambre() {
		Chambre c = serviceChambre.getOneChambre(1L);
		assertNotNull(c);
	}

	@Test
	@Ignore
	public void testGetAllChambre() {
		List<Chambre> chambres = new ArrayList<Chambre>();
		
        assertNotNull(chambres);
	}


}
