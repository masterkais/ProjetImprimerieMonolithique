package com.iit.imprimerie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.DocumentDao;
import com.iit.imprimerie.entities.Departement;
import com.iit.imprimerie.entities.Document;
import com.iit.imprimerie.exception.ConflitException;
import com.iit.imprimerie.exception.NoException;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class DocumentService {
	@Autowired
	DocumentDao docs;

	public void AjouterDocument(Document m) {

		if (docs.findByPath(m.getPath()) != null) {
			throw new ConflitException("le document existe deja dans la base");
		} else {
			docs.saveAndFlush(m);
			throw new NoException("l'objet est ajouter avec sucée");
		}
	}

	public void supprimerDocument(int id) {

		try {
			docs.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");

		}
	}

	public void modifierDocument(Document m) {
		if (docs.findByPath(m.getPath()) != null) {
			throw new ConflitException("le document existe deja dans la base");
		} else {
			docs.saveAndFlush(m);
			throw new NoException("l'objet est ajouter avec sucée");
		}
	}

	public Document getDocument(int id) {

		try {
			Document m = docs.findById(id).get();
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public List<Document> getAllDocument() {
		return docs.findAll();
	}

	public List<Document> getDocumentByEnseignant(int id) {

		try {
			Document m = docs.findById(id).get();
			return docs.getDocymentByEnsignant(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}

	}

	public List<Document> getDocumentByMatiere(int id) {

		try {
			Document m = docs.findById(id).get();
			return docs.getDocymentByMatiere(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}
}
