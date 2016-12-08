package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.CarteBancaire;
import com.adaming.myapp.entities.Cheque;
import com.adaming.myapp.entities.Espece;
import com.adaming.myapp.entities.Payement;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicepayement.IServicePayement;


public class ServicePayementTest {

	
	private static ClassPathXmlApplicationContext context;
	private static IServicePayement servicePayement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		servicePayement = (IServicePayement) context.getBean("ServicePayementImpl"); 
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	//=============================
	//		les methodes 
	//=============================
	@Test
	//@Ignore
	public void testAddPayement() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Payement payement = new Espece(500, sf.parse("07-12-2016"), "euro");
		//Payement payement = new Cheque(100.5, sf.parse("26-10-2016"), 123, "BNP");
		//Payement payement = new CarteBancaire(100.5, sf.parse("26-10-2016"), 1236, "visa");
		servicePayement.addPayement(payement, 1L);
		assertNotNull(payement.getIdPayement());
		
	}

	@Test
	@Ignore
	public void testUpdatePayement() {
		Payement p1 = servicePayement.getOnePayement(1L);
        p1.setCoutTotal(20.0);
        servicePayement.updatePayement(p1);
        assertThat(20.0, IsEqual.equalTo(servicePayement.getOnePayement(p1.getIdPayement()).getCoutTotal()));
  
	}

	@Test
	@Ignore
	public void testGetOnePayement() {
		Payement p = servicePayement.getOnePayement(1L);
		assertNotNull(p);
	}

	@Test
	@Ignore
	public void testGetAllPayement() {
		List<Payement> payements = servicePayement.getAllPayement();
		assertNotNull(payements);
	}

}
