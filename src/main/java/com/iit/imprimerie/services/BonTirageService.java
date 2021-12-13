package com.iit.imprimerie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.BonTirageDao;
import com.iit.imprimerie.entities.BonTirage;
import com.iit.imprimerie.entities.DemandeTirage;
import com.iit.imprimerie.exception.ConflitException;
import com.iit.imprimerie.exception.NoException;

@Service
public class BonTirageService {
@Autowired
BonTirageDao bdo;
@Autowired
DemandeTirageService dts;
	public void EffectuerBon(BonTirage b) {
		
		

		if (bdo.findById(dts.getDemandeTirage((b.getDemande()).getId_demande()).getId_demande())!= null) {
			throw new ConflitException("demande est deja fait");
		} else {
			DemandeTirage d=dts.getDemandeTirage(b.getDemande().getId_demande());
			d.setEtat_demande(1);
			dts.modifierDemandeTirage(d);
			bdo.save(b);
			throw new NoException("l'objet est ajouter avec sucée");
		}
		
	
}
	
	public List<BonTirage> getAllBonTirage(){
		return bdo.findAll();
	}

	public List<BonTirage> getAllBonTirageByEns(int id) {
		return bdo.getAllBonTirageByEns(id);
	}
}
