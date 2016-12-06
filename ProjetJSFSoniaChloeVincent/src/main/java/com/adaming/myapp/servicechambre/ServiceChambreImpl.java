package com.adaming.myapp.servicechambre;

import java.util.List;

import org.jboss.logging.Logger;

import com.adaming.myapp.daochambre.IDaoChambre;
import com.adaming.myapp.entities.Chambre;

public class ServiceChambreImpl implements IServiceChambre {
	
	private IDaoChambre dao;

	private final Logger LOGGER = Logger.getLogger(ServiceChambreImpl.class);
	
	public void setDao(IDaoChambre dao) {
		this.dao = dao;
		LOGGER.info("<----- Dao Chambre injected ----->");
	}

	@Override
	public Chambre updateChambre(Chambre c) {
		// TODO Auto-generated method stub
		return dao.updateChambre(c);
	}

	@Override
	public Chambre getOneChambre(Long idChambre) {
		// TODO Auto-generated method stub
		return dao.getOneChambre(idChambre);
	}

	@Override
	public List<Chambre> getAllChambre() {
		// TODO Auto-generated method stub
		return dao.getAllChambre();
	}

	@Override
	public Chambre addChambre(Chambre c, Long idHotel) {
		// TODO Auto-generated method stub
		return dao.addChambre(c, idHotel);
	}
	
	

}
