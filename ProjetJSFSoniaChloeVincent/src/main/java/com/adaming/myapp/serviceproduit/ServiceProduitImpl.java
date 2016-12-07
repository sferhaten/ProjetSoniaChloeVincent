package com.adaming.myapp.serviceproduit;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.daoproduit.IDaoProduit;
import com.adaming.myapp.entities.Produit;
@Transactional
public class ServiceProduitImpl implements IServiceProduit {
	
	private IDaoProduit dao;
	
	private final Logger LOGGER = Logger.getLogger(ServiceProduitImpl.class);

	public void setDao(IDaoProduit dao) {
		this.dao = dao;
		LOGGER.info("<-------dao Produit injected------->");
	}

	@Override
	public Produit addProduit(final Produit p, Long idHotel) {
		// TODO Auto-generated method stub
		return dao.addProduit(p, idHotel);
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return dao.updateProduit(p);
	}

	@Override
	public Produit getOneProduit(Long idProduit) {
		// TODO Auto-generated method stub
		return dao.getOneProduit(idProduit);
	}

	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return dao.getAllProduit();
	}
	
	

}
