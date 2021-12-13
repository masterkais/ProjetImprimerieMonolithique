package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Ligne_Demande;

@Repository
public interface LigneDemandeDao extends JpaRepository <Ligne_Demande, Integer>{

}
