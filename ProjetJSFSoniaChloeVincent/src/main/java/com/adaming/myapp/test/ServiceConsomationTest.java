package com.adaming.myapp.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.serviceconsomation.IServiceConsomation;

public class ServiceConsomationTest {

	private static ClassPathXmlApplicationContext context;
	private static IServiceConsomation serviceConsomation;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceConsomation = (IServiceConsomation) context.getBean("ServiceConsomationImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	
	//========================
	//	Les methodes a teste
	//========================
	
	@Test
	//@Ignore
	public void testAddConsommation() {
		Consomation consomation = new Consomation(5);
		serviceConsomation.addConsommation(consomation, 1L, 1L);
		assertNotNull(consomation.getIdConsommation());
	}

	@Test
	@Ignore
	public void testUpdateConsommation() {
		Consomation consomation2 = serviceConsomation.getConsommation(6L);
		consomation2.setQuantiteConsomation(10);
		serviceConsomation.updateConsommation(consomation2);
		assertThat(10,IsEqual.equalTo(serviceConsomation.getConsommation(consomation2.getIdConsommation()).getQuantiteConsomation()));
	}

	
	@Test
	@Ignore
	public void testGetConsommation() {
		Consomation consomation = serviceConsomation.getConsommation(6L);
		assertNotNull(consomation);
	}

	
	@Test
	//@Ignore
	public void testConsommations() {
		List<Consomation> consomations = serviceConsomation.consommations();
		assertNotNull(consomations);
	}

}
