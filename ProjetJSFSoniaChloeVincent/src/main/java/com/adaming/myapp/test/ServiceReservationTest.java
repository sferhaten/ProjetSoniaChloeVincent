package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.servicereservation.IServiceReservation;

public class ServiceReservationTest {

	
	private static ClassPathXmlApplicationContext context;
	private static IServiceReservation serviceReservation;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceReservation = (IServiceReservation) context.getBean("ServiceReservationImpl"); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	

	//========================
	//	Les methodes a teste
	//========================
	
	@Test
	@Ignore
	public void testAddReservation() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Reservation reservation = new Reservation(sf.parse("26-10-2016"), sf.parse("30-10-2016"), 50);
		serviceReservation.addReservation(reservation, 1L, 1L, 3L);
		assertNotNull(reservation.getIdReservation());
	}

	@Test
	//@Ignore
	public void testUpdateReservation() {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Reservation reservation1 = serviceReservation.getOneReservation(1L);
		reservation1.setDateArrive(sf.parse("31-11-2016"));
		serviceReservation.updateReservation(reservation1);
		assertThat(10,IsEqual.equalTo(serviceReservation.getOneReservation(reservation1.getIdReservation()).getDateArrive()));
	}

	@Test
	@Ignore
	public void testGetOneReservation() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetAllReservation() {
		fail("Not yet implemented");
	}

}
