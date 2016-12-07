package com.adaming.myapp.servicepayement;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.daopayement.IDaoPayement;
import com.adaming.myapp.entities.Payement;
@Transactional
public class ServicePayementImpl implements IServicePayement {
	
	private IDaoPayement dao;
	private final Logger LOGGER = Logger.getLogger(ServicePayementImpl.class);

	public void setDao(IDaoPayement dao) {
		this.dao = dao;
		LOGGER.info("<----- Dao Payement injected ----->");
	}

	@Override
	public Payement addPayement(Payement p, Long idFacture) {
		// TODO Auto-generated method stub
		return dao.addPayement(p, idFacture);
	}

	@Override
	public Payement updatePayement(Payement p) {
		// TODO Auto-generated method stub
		return dao.updatePayement(p);
	}

	@Override
	public Payement getOnePayement(Long idPayement) {
		// TODO Auto-generated method stub
		return dao.getOnePayement(idPayement);
	}

	@Override
	public List<Payement> getAllPayement() {
		// TODO Auto-generated method stub
		return dao.getAllPayement();
	}
	
	
	

}
