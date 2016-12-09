package com.adaming.myapp.bean.client;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.servicepersonne.IServicePersonne;

@Component("clientBean")
@ViewScoped
public class ClientBean {

	private Logger LOGGER = Logger.getLogger(ClientBean.class);
	
	@Inject
	private IServicePersonne service;
	
	
	public Client GetClient(Long idClient){
		Client cl = (Client) service.getPersonne(idClient);
		LOGGER.info("Client trouvé : " + cl.getIdPersonne() );
		return cl;
	}
	
}
