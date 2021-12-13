package com.iit.imprimerie.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.DemandeTirage;
import com.iit.imprimerie.entities.Matiere;
import com.iit.imprimerie.services.DemandeTirageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DemandeTirageController {
	@Autowired
	DemandeTirageService dto;

	@ApiOperation(value = "passer demande", notes = "cette methode permet au enseignant de passer une demande de tirage ", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet demande est ajouter"),
			@ApiResponse(code = 400, message = "l'objet demande n'est pas valide") })
	@PostMapping("/DemandeTirage")
	public void AjouterNDemandeTirage(@RequestBody DemandeTirage m) {
		dto.AjouterNDemandeTirage(m);
	}

	@ApiOperation(value = "supprimer objet", notes = "cette methode permet de supprimer un objet par son id qui existe dans le base de donnée", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte") })
	@DeleteMapping("/DemandeTirage/{id}")
	public void supprimerDemandeTirage(@PathVariable int id) {
		dto.supprimerDemandeTirage(id);
	}

	@ApiOperation(value = "Modifier objet", notes = "cette methode permet de modifier un objet ", response = Matiere.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/DemandeTirage")
	public void modifierDemandeTirage(@RequestBody DemandeTirage m) {
		dto.modifierDemandeTirage(m);
	}

	@ApiOperation(value = "chercher un objet", notes = "cette methode permet de chercher un objet par son id qui existe dans le base de donnée", response = DemandeTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping("/DemandeTirage/{id}")
	public DemandeTirage getDemandeTirage(@PathVariable int id) {
		DemandeTirage m = dto.getDemandeTirage(id);
		return m;
	}
	
	@ApiOperation(value = "renvoie la liste des objets", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/GetAllDemandeTirage")
	public List<DemandeTirage> getAllDemandeTirage() {
		return dto.getAllDemandeTirage();
	}
	@ApiOperation(value = "renvoie la liste des objets par date arriver", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByDA/{date}")
	public List<DemandeTirage> getDemandeTirageByDateArrive(@PathVariable Date date) {
		return dto.getDemandeTirageByDateArrive(date);
	}
	
	@ApiOperation(value = "renvoie la liste des objets par date demande", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByDD/{date}")
	public List<DemandeTirage> getDemandeTirageByDateDemande(@PathVariable Date date) {
		return dto.getDemandeTirageByDateDemande(date);
	}

	@ApiOperation(value = "renvoie la liste des objets par enseignant", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<DemandeTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/DemandeTirageByEns/{id}")
	public List<DemandeTirage> getDemandeTirageByEns(@PathVariable int id) {
		return dto.getDemandeTirageByEns(id);
	}
}
