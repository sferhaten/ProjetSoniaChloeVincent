package com.adaming.myapp.servicefacture;

import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;

import com.adaming.myapp.daofacture.IDaoFacture;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;

public class ServiceFactureImpl implements IServicefacture {
	
	private IDaoFacture dao;

	private final Logger LOGGER = Logger.getLogger(ServiceFactureImpl.class);
	
	public void setDao(IDaoFacture dao) {
		this.dao = dao;
		LOGGER.info("<----- Dao Facture injected ----->");
	}

	@Override
	public Facture addFacture(Facture f) {
		// TODO Auto-generated method stub
		return dao.addFacture(f);
	}

	@Override
	public Facture updateFacture(Facture f) {
		// TODO Auto-generated method stub
		return dao.updateFacture(f);
	}

	@Override
	public Facture getOneFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return dao.getOneFacture(idFacture);
	}

	@Override
	public List<Facture> getAllFacture() {
		// TODO Auto-generated method stub
		return dao.getAllFacture();
	}

	@Override
	public Set<Consomation> getConsoByFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return dao.getConsoByFacture(idFacture);
	}
	
	
}
