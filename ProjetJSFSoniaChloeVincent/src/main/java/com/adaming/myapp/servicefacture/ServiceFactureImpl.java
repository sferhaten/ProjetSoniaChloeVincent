package com.adaming.myapp.servicefacture;

import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.daofacture.IDaoFacture;
import com.adaming.myapp.entities.Consomation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
@Transactional
public class ServiceFactureImpl implements IServicefacture {
	
	private IDaoFacture dao;

	private final Logger LOGGER = Logger.getLogger(ServiceFactureImpl.class);
	
	public void setDao(IDaoFacture dao) {
		this.dao = dao;
		LOGGER.info("<----- Dao Facture injected ----->");
	}

	//===============================
	//		Redefinition des methodes
	//===============================

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
		
		return dao.getConsoByFacture(idFacture);
	}

	@Override
	public Set<Reservation> getReserByFacture(Long idFacture) {
		
		return dao.getReserByFacture(idFacture);
	}
	

	@Override
	public Facture addFactureToReservation(Facture f,
			Set<Reservation> reservations, Long idPersonne, final Long idHotel) {
		
		Double coutRes = 0.0 ;
		
		for (Reservation r : reservations) {
			coutRes = coutRes + r.getCoutResa();
		}
		
		f.setCoutResa(coutRes);
		return dao.addFactureToReservation(f, reservations, idPersonne, idHotel);
	}



	@Override
	public Facture addFactureToConsomation(Facture f,
			Set<Consomation> consomations, Long idPersonne, final Long idHotel) {
		
		
		
		Double coutCons = 0.0 ;	

		for (Consomation c : consomations) {
			coutCons = coutCons + c.coutclient();
		}	
		
		f.setCoutConso(coutCons);	
		
		return dao.addFactureToConsomation(f, consomations, idPersonne,  idHotel);
	}



	@Override
	public Facture addFacture(Facture f, Set<Reservation> reservations,
			Set<Consomation> consomations, Long idPersonne, final Long idHotel) {
		
		Double coutCons = 0.0 ;
		Double coutRes = 0.0 ;		
		
		for (Consomation c : consomations) {
			coutCons = coutCons + c.coutclient();
		}
		for (Reservation r : reservations) {
			coutRes = coutRes + r.getCoutResa();
		}
		
		f.setCoutConso(coutCons);	
		f.setCoutResa(coutRes);
		return dao.addFacture(f, reservations, consomations, idPersonne, idHotel);
	}




	
}
