package com.iit.imprimerie.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.DemandeTirage;

@Repository
public interface DemandeTirageDao extends JpaRepository<DemandeTirage,Integer> {

	@Query("SELECT u FROM DemandeTirage u WHERE u.ens.id = :id")
	public List<DemandeTirage> getDemandeTirageByEnsignant(@Param("id") int id);
	
	@Query("SELECT u FROM DemandeTirage u WHERE u.date_demande = :date")
	public List<DemandeTirage> getDemandeTirageByDateDemande(@Param("date") Date date);
	
	@Query("SELECT u FROM DemandeTirage u WHERE u.date_arrive = :date")
	public List<DemandeTirage> getDemandeTirageByDateArrive(@Param("date") Date date);
	
}
