package com.iit.imprimerie.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.DemandeTirageDao;
import com.iit.imprimerie.entities.DemandeTirage;
import com.iit.imprimerie.entities.Document;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class DemandeTirageService {
	@Autowired
	DemandeTirageDao dto;

	public void AjouterNDemandeTirage(DemandeTirage m) {
		m.setEtat_demande(0);
		dto.saveAndFlush(m);

	}

	public void supprimerDemandeTirage(int id) {

		try {
			dto.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");

		}
	}

	public void modifierDemandeTirage(DemandeTirage m) {
		dto.saveAndFlush(m);
	}

	public DemandeTirage getDemandeTirage(int id) {

		try {
			DemandeTirage m = dto.findById(id).get();
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public List<DemandeTirage> getAllDemandeTirage() {
		return dto.findAll();
	}

	public List<DemandeTirage> getDemandeTirageByDateArrive(Date date) {

		try {
			return dto.getDemandeTirageByDateArrive(date);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the date " + date + " was found in daabase ");
		}
	}

	public List<DemandeTirage> getDemandeTirageByDateDemande(Date date) {

		try {
			return dto.getDemandeTirageByDateDemande(date);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the date " + date + " was found in daabase ");
		}
	}

	public List<DemandeTirage> getDemandeTirageByEns(int id) {
		
		try {
			return dto.getDemandeTirageByEnsignant(id);		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id" + id + " was found in daabase ");
		}
	}

}
