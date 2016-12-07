package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreDouble;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.servicechambre.IServiceChambre;
import com.adaming.myapp.servicepersonne.IServicePersonne;

public class ServicePersonneTest {

	private static ClassPathXmlApplicationContext context;
	private static IServicePersonne servicePersonne;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		servicePersonne =(IServicePersonne)context.getBean("ServicePersonneImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAddPersonne() throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Date Date1=sf.parse("06-12-2012");
		Adresse adresse = new Adresse("2", "rue", "pau", "france", "france");
		Personne p = new Client("bob", "dylan", Date1, adresse, 2);
		servicePersonne.addPersonne(p, 1L);
		assertNotNull(p.getIdPersonne());
	}

	@Test
	@Ignore
	public void testGetPersonne() {
		Personne p =servicePersonne.getPersonne(1L);
		assertNotNull(p);
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Personne> personnes = new ArrayList<Personne>();
		assertNotNull(personnes);
		
	}

	@Test
	//@Ignore
	public void testUpdatePersonne() {
		Personne p1= servicePersonne.getPersonne(1L);
		p1.setNom("toto");
		servicePersonne.updatePersonne(p1);
		Personne p2 =servicePersonne.getPersonne(p1.getIdPersonne());
		assertThat("toto", IsEqual.equalTo(p2.getNom()));
		
	}

}
